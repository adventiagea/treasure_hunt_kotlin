package com.dicoding.picodiploma.treasurehunt_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.treasurehunt_kotlin.api.ApiBase
import com.dicoding.picodiploma.treasurehunt_kotlin.api.RetrofitClient
import com.dicoding.picodiploma.treasurehunt_kotlin.api.auth.AuthInterface
import com.dicoding.picodiploma.treasurehunt_kotlin.api.auth.login.LoginBody
import com.dicoding.picodiploma.treasurehunt_kotlin.api.auth.login.LoginResponse
import com.dicoding.picodiploma.treasurehunt_kotlin.api.auth.registration.RegisterBody
import com.dicoding.picodiploma.treasurehunt_kotlin.api.games.detail.Game
import com.dicoding.picodiploma.treasurehunt_kotlin.api.games.list.GameDatas
import com.dicoding.picodiploma.treasurehunt_kotlin.api.games.list.Games
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel : ViewModel() {
    private val listGame = MutableLiveData<ArrayList<GameDatas>>()
    private val login = MutableLiveData<LoginResponse>()

    fun listGameApi(token : String){
        ApiBase.apiInterface.getGameLists(token).enqueue(object : Callback<Games> {
            override fun onResponse(call: Call<Games>, response: Response<Games>) {
                listGame.postValue(response.body()?.data!!)
            }

            override fun onFailure(call: Call<Games>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getListGame() : LiveData<ArrayList<GameDatas>> = listGame

    fun login(email : String, pass : String){
        RetrofitClient.init().create(AuthInterface::class.java).login(LoginBody(email, pass)).enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                login.postValue(response.body())
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    fun loginResponse() : LiveData<LoginResponse>{
        return login
    }
}