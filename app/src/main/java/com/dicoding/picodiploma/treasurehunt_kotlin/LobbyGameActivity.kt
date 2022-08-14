package com.dicoding.picodiploma.treasurehunt_kotlin

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.dicoding.picodiploma.treasurehunt_kotlin.api.RetrofitClient
import com.dicoding.picodiploma.treasurehunt_kotlin.api.game_control.GameControlInterface
import com.dicoding.picodiploma.treasurehunt_kotlin.databinding.ActivityLobbyGameBinding

class LobbyGameActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private val tokenGame = "key_token_game"
    private val tokenKey = "key_token"
    private lateinit var binding : ActivityLobbyGameBinding
    private val gameControl = RetrofitClient.init().create(GameControlInterface::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLobbyGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.readyButton.setOnClickListener {
//            BELUM BERHASIL BY : WAHYU
//            val readyCheck = gameControl.readyCheck(getTokenUser().toString(), getTokenGame().toString())
//            Log.d(String(),readyCheck.body().toString())
//            if(readyCheck.isSuccessful){
//                Log.d("wnb-start: ", readyCheck.body().toString())
//                // DISABLE TOMBOL READY DAN UBAH WARNA MENJADI DISABLED
//            }else{
//                Log.d("gagal ready", readyCheck.body().toString())
//            }
        }

        binding.playGameButton.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
        binding.playGameButton.setOnClickListener {

//            BELUM BERHASIL BY : WAHYU
//            Log.d(String(), "wnb-start: start ditekan")
//            val startGame = gameControl.startGame(getTokenUser().toString(), getTokenGame().toString())
//
//            if(startGame.isSuccessful){
//                Log.d("wnb-start: ", startGame.body().toString())
//                // MASUK KE GAME ACTIVITY (MULAI PERMAINAN)
//            }
//            Log.d("gagal start", startGame.body().toString())
//
            val intent = Intent(this, PlayGameActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getTokenUser() : String? = sharedPreferences.getString(tokenKey, null)
    private fun getTokenGame() : String? = sharedPreferences.getString(tokenGame, null)
}