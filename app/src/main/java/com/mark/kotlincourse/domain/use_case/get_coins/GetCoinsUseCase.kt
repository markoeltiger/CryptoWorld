package com.mark.kotlincourse.domain.use_case.get_coins

import com.mark.kotlincourse.common.Resource
import com.mark.kotlincourse.data.remote.dto.toCoin
import com.mark.kotlincourse.data.repository.CoinRepositoryImpl
import com.mark.kotlincourse.domain.model.Coin
import com.mark.kotlincourse.domain.repository.coinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val  repository: coinRepository


){
operator  fun invoke():Flow<Resource<List<Coin>>>  = flow {
     try {
emit(Resource.Loading())
         val coins = repository.getCoins().map { it.toCoin() }
         emit(Resource.Success(coins))
     }catch (e:HttpException){
emit(Resource.Error(e.localizedMessage?:"An unexpected http connection problem"))
     }catch (e:IOException){}
    emit(Resource.Error("Couldnt reach server check connection"))


}

}