package com.mark.kotlincourse.data.repository

import com.mark.kotlincourse.data.remote.CoinPaprikaAPI
import com.mark.kotlincourse.data.remote.dto.CoinDetailDto
import com.mark.kotlincourse.data.remote.dto.CoinDto
import com.mark.kotlincourse.domain.repository.coinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private  val  api: CoinPaprikaAPI):coinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
        TODO("Not yet implemented")
    }

    override suspend fun getCoinbyId(coindId: String)  : CoinDetailDto {
        return api.getCoinById(coindId)
        TODO("Not yet implemented")
    }
}