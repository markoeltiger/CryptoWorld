package com.mark.kotlincourse.di

import android.provider.SyncStateContract
import com.mark.kotlincourse.common.constants
import com.mark.kotlincourse.data.remote.CoinPaprikaAPI
import com.mark.kotlincourse.data.repository.CoinRepositoryImpl
import com.mark.kotlincourse.domain.repository.coinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
@Provides
@Singleton
fun providesPaprikaApi():CoinPaprikaAPI{
    return Retrofit.Builder().baseUrl(constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaAPI::class.java)
}

    @Provides
    @Singleton
    fun provideCoinRebository(api: CoinPaprikaAPI):coinRepository{

        return CoinRepositoryImpl(api)
    }
}