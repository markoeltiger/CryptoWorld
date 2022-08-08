package com.mark.kotlincourse.data.remote.dto

import com.mark.kotlincourse.domain.model.Coin

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
fun CoinDto.toCoin(): Coin{
    return Coin(
        id=id,
        name = name,
        is_active = is_active,
        is_new = is_new,
        rank = rank,
        symbol = symbol,
        type = type


    )
}