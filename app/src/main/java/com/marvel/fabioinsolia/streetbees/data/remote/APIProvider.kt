package com.marvel.fabioinsolia.streetbees.data.remote

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIProvider : IAPIProvider {

  override fun create(): IAPIClient {
    val baseUrl = "https://gateway.marvel.com"
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(IAPIClient::class.java)
  }


}