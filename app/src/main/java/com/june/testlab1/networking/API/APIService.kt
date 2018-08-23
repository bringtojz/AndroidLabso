package com.june.testlab1.networking.API

import com.june.testlab1.networking.modelAPI.LoginRequest
import com.june.testlab1.networking.modelAPI.Nasa
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.*


interface APIService {

    @POST("Account/Login")
    fun login(@Body loginRequest: LoginRequest) : Observable<ResponseBody>

    @POST ("planetary/apod")
    fun nasa (@Body nasa: Nasa): Observable<ResponseBody>
}