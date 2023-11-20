package com.example.myapplication

import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface StatusAPI {
    @POST("maketoken")
    suspend fun getProductById(@Body body: RequestBody): Status
}