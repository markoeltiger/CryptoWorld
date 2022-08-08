package com.mark.kotlincourse.domain.repository

import com.mark.kotlincourse.data.remote.dto.CoinDetailDto
import com.mark.kotlincourse.data.remote.dto.CoinDto

interface coinRepository {
    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinbyId(coindId:String): CoinDetailDto
}