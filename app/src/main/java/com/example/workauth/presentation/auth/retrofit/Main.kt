package com.example.workauth.presentation.auth.retrofit

import com.example.myapplication.StatusAPI
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


suspend fun main() {
    val BASE_URL = "http://185.189.100.107:4000/SL/hs/SLapi/"

    val jsonData = """{ "number": "9896540041" } """.trimMargin()

    val requestBody = RequestBody.create("package.json".toMediaTypeOrNull(), jsonData)


    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    val productAPI = retrofit.create(StatusAPI::class.java)

    val product = productAPI.getProductById(requestBody)
    println(product)
}