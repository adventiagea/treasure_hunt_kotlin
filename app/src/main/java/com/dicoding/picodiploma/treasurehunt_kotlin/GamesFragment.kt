package com.dicoding.picodiploma.treasurehunt_kotlin

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.dicoding.picodiploma.treasurehunt_kotlin.databinding.FragmentGamesBinding
import java.lang.StringBuilder

class GamesFragment : Fragment() {

    private lateinit var adapter: GameBraceAdapter
    private lateinit var listAdapter: ListGameAdapter
    private val list = ArrayList<BraceGameData>()
    private val listGame = ArrayList<ListGameData>()
    private lateinit var dot : ArrayList<TextView>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGamesBinding.inflate(inflater, container, false)

        activity?.actionBar?.hide()

        list.add(
            BraceGameData(
                R.drawable.banner_brace,
                "BRACE",
                "2022"
            )
        )

        list.add(
            BraceGameData(
                R.drawable.banner_manohara,
                "MANOHARA",
                ""
            )
        )

        adapter = GameBraceAdapter(list)
        binding.viewPagerList.adapter = adapter
        dot = ArrayList()

        listGame.add(
            ListGameData(
                R.drawable.banner_manohara,
                "MANOHARA",
                "Manohara",
                "Lorem ipsum dolor sit amet"
            )
        )

        listGame.add(
            ListGameData(
                R.drawable.banner_brace,
                "BRACE\n2022",
                "BRACE 2022",
                "Lorem ipsum dolor sit amet"
            )
        )

        listGame.add(
            ListGameData(
                R.drawable.list_game_3,
                "SHUDANNA",
                "Shudanna",
                "Lorem ipsum dolor sit amet"
            )
        )

        listAdapter = ListGameAdapter(listGame)
        binding.listGameRv.adapter = listAdapter
        binding.listGameRv.layoutManager = LinearLayoutManager(context)

        setIndicator()

        binding.viewPagerList.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                selectedImage(position)
                super.onPageSelected(position)
            }
        })

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun selectedImage(position: Int) {
        for (i in 0 until list.size){
            if (i == position){
                dot[i].setTextColor(ContextCompat.getColor(requireContext(), R.color.yellow))
            }
            else{
                dot[i].setTextColor(ContextCompat.getColor(requireContext(), R.color.text))
            }
        }
    }

    private fun setIndicator() {

        for(i in 0 until list.size){
            dot.add(TextView(requireContext()))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                dot[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()
            }
            else {
                dot[i].text = Html.fromHtml("&#9679")
            }

            dot[i].textSize = 12f
            view?.findViewById<LinearLayout>(R.id.indikator_game)?.addView(dot[i])
        }
    }

}