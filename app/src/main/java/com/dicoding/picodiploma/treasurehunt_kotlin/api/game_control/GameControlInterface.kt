package com.dicoding.picodiploma.treasurehunt_kotlin.api.game_control

import com.dicoding.picodiploma.treasurehunt_kotlin.api.game_control.join_game.Join
import com.dicoding.picodiploma.treasurehunt_kotlin.api.game_control.join_game.JoinBody
import com.dicoding.picodiploma.treasurehunt_kotlin.api.game_control.lobby.Lobby
import com.dicoding.picodiploma.treasurehunt_kotlin.api.game_control.me.Me
import retrofit2.Response
import retrofit2.http.*

interface GameControlInterface {
    @Headers("Content-Type: application/json")
    @POST("/mobile/v1/game-controls/join-game")
    suspend fun join(@Header("Authorization") token: String, @Body code : JoinBody) : Response<Join>

    @GET("/mobile/v1/game-controls/me")
    suspend fun getUserInfoInGame(@Header("Authorization") token: String,
                               @Query("game_token") game_token: String) : Response<Me>

    @GET("/mobile/v1/game-controls/lobbies/{lobbyID}")
    suspend fun getLobbyDetail(@Header("Authorization") token: String,
                               @Path("lobbyID") lobbyID : String,
                               @Query("game_token") game_token: String,) : Response<Lobby>

}