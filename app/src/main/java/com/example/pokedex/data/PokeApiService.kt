package com.example.pokedex.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class PokeApiService(
    private val config: ClientConfig
) : PokeApiInterface by Retrofit.Builder()
    .baseUrl(config.rootUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .client(OkHttpClient.Builder().(config.okHttpClient)().build())
    .build()
    .create(PokeApiInterface::class.java){
}