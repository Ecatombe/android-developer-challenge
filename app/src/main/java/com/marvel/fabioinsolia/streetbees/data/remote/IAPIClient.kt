package com.marvel.fabioinsolia.streetbees.data.remote

import com.marvel.fabioinsolia.streetbees.data.model.ComicList
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface IAPIClient {

  @GET("/v1/public/comics")
  fun retrieveComics(@Query("ts") timestamp: String, @Query("apikey") apikey: String, @Query(
      "hash") hash: String): Single<ComicList>

}