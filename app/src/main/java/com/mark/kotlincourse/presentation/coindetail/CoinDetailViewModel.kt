package com.mark.kotlincourse.presentation.coindetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mark.kotlincourse.common.Resource
import com.mark.kotlincourse.common.constants
import com.mark.kotlincourse.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
private val getCoinsUseCase: GetCoinsUseCase,
savedStateHandle:SavedStateHandle

): ViewModel(){
    private val _state= mutableStateOf(CoinDetailState())

    val state:State<CoinDetailState> =_state
    init {
savedStateHandle.get<String>(constants.PARAM_COIN_ID) ?.let { coinId->
    getCoins(coinId)
}

    }


    private fun getCoins(coinId:String){
        getCoinsUseCase().onEach { result->

            when(result){
                is Resource.Success ->{
                    _state.value =CoinDetailState(coin = result.data)


                }
                is Resource.Error ->{
                    _state.value =CoinDetailState(error = result.message ?:"Un expected error occured")

                }
                is Resource.Loading->{
                        _state.value =CoinDetailState(isloading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}