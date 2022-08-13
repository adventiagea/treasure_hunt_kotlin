package com.dicoding.picodiploma.treasurehunt_kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.picodiploma.treasurehunt_kotlin.api.RetrofitClient
import com.dicoding.picodiploma.treasurehunt_kotlin.api.auth.AuthInterface
import com.dicoding.picodiploma.treasurehunt_kotlin.api.auth.login.LoginBody
import com.dicoding.picodiploma.treasurehunt_kotlin.api.auth.registration.RegisterBody
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.dicoding.picodiploma.treasurehunt_kotlin.api.games.GameInterface as GameInterface1

class ApiTestActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val auth = RetrofitClient.init().create(AuthInterface::class.java)
        val games = RetrofitClient.init().create(GameInterface1::class.java)

        GlobalScope.launch {
            // AUTH
            val registerBody = RegisterBody("test111@gmail.com", "12345678", "junaris", "jl. fd", "34242342342")
            val regist = auth.registUser(registerBody)
            Log.d("API-register: ", regist.body().toString())

            val loginRes = auth.login(LoginBody("test111@gmail.com", "12345678"))
            Log.d("API-login: ", loginRes.body().toString())

            val token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIzMDkzMjg4YS00YWY1LTRiYmYtYWE5Ny0wMWMwYWU5NzgyODIiLCJpYXQiOjE2NjAzMTU3NDd9.6_C871Ge4QxKvEwwW3kZEECbFe3ETAxLIY8bJLfLczY"
            val userRes = auth.getCurrentUser(token)
            Log.d("API-get current user: ", userRes.body().toString())

            //GAMES
            val gameListRes = games.getGameLists(token)
            Log.d("API-game list: ", gameListRes.body().toString())

            val gameID = gameListRes.body()?.data!![0].id
            val gameDetail = games.getGameDetail(token, gameID)
            Log.d("API-game detail: ", gameDetail.body().toString())


        }
    }
}