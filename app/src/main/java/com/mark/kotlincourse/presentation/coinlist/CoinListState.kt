package com.mark.kotlincourse.presentation.coinlist

import com.mark.kotlincourse.domain.model.Coin

data class CoinListState(
    val isloading: Boolean= false,
    val coins:List<Coin>  = emptyList(),
    val error:String =""


)
