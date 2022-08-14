package com.dicoding.picodiploma.treasurehunt_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.picodiploma.treasurehunt_kotlin.databinding.ActivityPlayGameBinding

class PlayGameActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPlayGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


    }
}