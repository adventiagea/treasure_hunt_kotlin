package com.dicoding.picodiploma.treasurehunt_kotlin.api

import com.dicoding.picodiploma.treasurehunt_kotlin.data.RegisterUserData
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {
    @POST("/mobile/v1/registration")
    fun registerUser(
        @Path("email") email : String,
        @Path("password") password : String,
        @Path("full_name") fullName : String,
        @Path("address") address : String,
        @Path("phone_number") phoneNumber : String
    ) : Call<RegisterUserData>

}