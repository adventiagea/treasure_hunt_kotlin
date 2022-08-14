package com.dicoding.picodiploma.treasurehunt_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.treasurehunt_kotlin.api.ApiBase
import com.dicoding.picodiploma.treasurehunt_kotlin.api.games.detail.Game
import com.dicoding.picodiploma.treasurehunt_kotlin.api.games.list.GameDatas
import com.dicoding.picodiploma.treasurehunt_kotlin.api.games.list.Games
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel : ViewModel() {
    private val listGame = MutableLiveData<ArrayList<GameDatas>>()

    fun listGameApi(token : String){
        ApiBase.apiInterface.getGameLists("Bearer "+ token).enqueue(object : Callback<Games> {
            override fun onResponse(call: Call<Games>, response: Response<Games>) {
                listGame.postValue(response.body()?.data!!)
            }

            override fun onFailure(call: Call<Games>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getListGame() : LiveData<ArrayList<GameDatas>> = listGame
}