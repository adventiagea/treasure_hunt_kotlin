package com.dicoding.picodiploma.treasurehunt_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailBraceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_brace)

        supportActionBar?.hide()
    }
}