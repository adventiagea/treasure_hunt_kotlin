package com.dicoding.picodiploma.treasurehunt_kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.picodiploma.treasurehunt_kotlin.api.RetrofitClient
import com.dicoding.picodiploma.treasurehunt_kotlin.api.auth.AuthInterface
import com.dicoding.picodiploma.treasurehunt_kotlin.api.auth.registration.RegisterBody
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ApiTestActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIzMDkzMjg4YS00YWY1LTRiYmYtYWE5Ny0wMWMwYWU5NzgyODIiLCJpYXQiOjE2NjAzMTU3NDd9.6_C871Ge4QxKvEwwW3kZEECbFe3ETAxLIY8bJLfLczY"

        val auth = RetrofitClient.init().create(AuthInterface::class.java)
        val registerBody = RegisterBody("test111@gmail.com", "12345678", "junaris", "jl. fd", "34242342342")

        GlobalScope.launch {
            val result = auth.getCurrentUser(token)
            Log.d("juna: ", result.body().toString())

            val regist = auth.registUser(registerBody)
            Log.d("juna: ", regist.body().toString())

//            val loginRes = auth.login(LoginBody("testemail@gmail.com", "12345678"))
//            Log.d("juna", loginRes.body().toString())

        }
    }
}