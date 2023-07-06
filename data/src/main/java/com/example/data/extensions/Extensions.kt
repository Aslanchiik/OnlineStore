package com.example.data.extensions

import com.example.data.remote.APIErrorDto
import com.google.gson.Gson
import okhttp3.ResponseBody

fun ResponseBody.parseErrorBody(): APIErrorDto {
    return Gson().fromJson(this.string(), APIErrorDto::class.java)
}