package ru.gonchar17narod.grouapp.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.gonchar17narod.grouapp.R
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideConverterFactory(): Converter.Factory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideAdapterFactory(): CallAdapter.Factory =
        RxJava2CallAdapterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(
        context: Context,
        converterFactory: Converter.Factory,
        adapterFactory: CallAdapter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl(context.getString(R.string.base_url))
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(adapterFactory)
            .build()
}