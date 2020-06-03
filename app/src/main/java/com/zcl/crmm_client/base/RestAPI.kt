package com.zcl.crmm_client.base

import com.zcl.crmm_client.login.bean.User
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

/**
 *Created by zcl
 *
 */

var API = Retrofit.Builder().client(
    OkHttpClient().newBuilder().build())
    .addConverterFactory(JacksonConverterFactory.create())
    .baseUrl(RestAPI.BASE_URL)
    .build().create(RestAPI::class.java)

/**
 *  OkHttpClient().newBuilder()
.addInterceptor {
val method = it.request().method()
var body = it.request().body()
var url = it.request().url()

it.proceed(it.request().newBuilder().method(method, body).url(url).build())
}.build()
 */

interface RestAPI {
    companion object {
       // const val BASE_URL = "http://127.0.0.1:8080"
        const val BASE_URL = "http://192.168.0.106:9008"
    }

    /**
     *  private boolean flag;
    private Integer code;
    private String message;
    private Object data;
     */
    class Result<T> {
        var flag: Boolean = false
        var code: Int = -1
        var message: String = ""
        var data: T? = null
    }

    @POST("user/sendsms/{mobile}")
    fun sendSMS(@Path("mobile") mobile: String): Call<Result<Any>>

    @POST("user/register/{code}")
    fun register(@Path("code") code:String,@Body user:User):Call<Result<Any>>

    @POST("user/login")
    fun login(@Body user:User):Call<Result<HashMap<String,String>>>
}