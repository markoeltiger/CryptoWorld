package com.mark.kotlincourse.data.remote

import com.mark.kotlincourse.data.remote.dto.CoinDetailDto
import com.mark.kotlincourse.data.remote.dto.CoinDto
import com.mark.kotlincourse.domain.model.Coin
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {
    @GET("/v1/coins")
    suspend fun getCoins():List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId:String):CoinDetailDto
}