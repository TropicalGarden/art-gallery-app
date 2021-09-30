package com.example.artgallery.network.service

import com.example.artgallery.model.Art
import com.example.artgallery.network.model.Token
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL =
    "https://www.deviantart.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DeviantApiService {

    @GET("/api/v1/oauth2/browse/topic?topic=digital-art&limit=max")
    suspend fun getArt(@Header("Authorization") token: String): Art

    @FormUrlEncoded
    @POST("/oauth2/token")
    suspend fun getToken(
        @Field("grant_type") grantType: String,
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String
    ): Token

}

object DeviantApi {
    val retrofitService: DeviantApiService by lazy {
        retrofit.create(DeviantApiService::class.java)
    }
}
