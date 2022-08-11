package com.dicoding.picodiploma.treasurehunt_kotlin

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.dicoding.picodiploma.treasurehunt_kotlin.databinding.ActivityMainBinding
import com.dicoding.picodiploma.treasurehunt_kotlin.databinding.ActivityOnBoardBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: HomeBraceAdapter
    private val list = ArrayList<BraceData>()
    private lateinit var dot : ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        list.add(
            BraceData(
                R.drawable.brace1
            )
        )

        list.add(
            BraceData(
                R.drawable.brace2
            )
        )

        list.add(
            BraceData(
                R.drawable.brace3
            )
        )

        adapter = HomeBraceAdapter(list)
        binding.viewPagerHome.adapter = adapter
        dot = ArrayList()

        setIndicator()

        binding.viewPagerHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                selectedImage(position)
                super.onPageSelected(position)
            }
        })

        val inputCode = binding.inputCode
        val playButton = binding.playButton

        inputCode.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                playButton.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.login_gray))
                playButton.isClickable = false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                playButton.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.green))

                play()
            }

            override fun afterTextChanged(s: Editable?) {
                playButton.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.green))

                play()
            }

        })
    }

    private fun play() {
        val inputCode = binding.inputCode
        val playButton = binding.playButton

        playButton.setOnClickListener{
            if (inputCode.text.toString().isNotEmpty()){
                val intent = Intent(this, LobbyActivity::class.java)

                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Masukkan Kode Permainan!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun selectedImage(position: Int) {
        for (i in 0 until list.size){
            if (i == position){
                dot[i].setTextColor(ContextCompat.getColor(this, R.color.yellow))
            }
            else{
                dot[i].setTextColor(ContextCompat.getColor(this, R.color.text))
            }
        }
    }

    private fun setIndicator() {
        for(i in 0 until list.size){
            dot.add(TextView(this))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                dot[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()
            }
            else {
                dot[i].text = Html.fromHtml("&#9679")
            }

            dot[i].textSize = 12f
            binding.indikatorHome.addView(dot[i])
        }
    }
}