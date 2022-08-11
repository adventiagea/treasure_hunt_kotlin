package com.dicoding.picodiploma.treasurehunt_kotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
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