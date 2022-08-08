package com.mark.kotlincourse.presentation.coindetail

import com.mark.kotlincourse.domain.model.Coin
import com.mark.kotlincourse.domain.model.CoinDetail

data class CoinDetailState(
    val isloading: Boolean= false,
    val coin: List<Coin>? =  null,
    val error:String =""


)
