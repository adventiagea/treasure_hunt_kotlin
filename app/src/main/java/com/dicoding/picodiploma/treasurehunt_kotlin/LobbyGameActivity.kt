package com.dicoding.picodiploma.treasurehunt_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.dicoding.picodiploma.treasurehunt_kotlin.databinding.ActivityLobbyGameBinding
import com.dicoding.picodiploma.treasurehunt_kotlin.manohara.ManoharaMainActivity

class LobbyGameActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLobbyGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLobbyGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.readyButton.setOnClickListener {

        }

        binding.playGameButton.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
        binding.playGameButton.setOnClickListener {
            val intent = Intent(this, PlayGameActivity::class.java)
            startActivity(intent)
        }
    }
}