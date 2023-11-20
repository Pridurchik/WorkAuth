package com.example.myapplication

data class Status(
    val error: Boolean,
    val data: Any,
    val number_not_found: Boolean,
    val expired_time: String,
    val status: Int
)