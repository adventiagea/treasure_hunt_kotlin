package com.dicoding.picodiploma.treasurehunt_kotlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.treasurehunt_kotlin.databinding.ItemListgameBinding

class ListGameAdapter(private val item : List<ListGameData>) : RecyclerView.Adapter<ListGameAdapter.ListGameViewHolder>() {
    inner class ListGameViewHolder(itemview : ItemListgameBinding) : RecyclerView.ViewHolder(itemview.root) {
        private val binding = itemview

        fun bind(data: ListGameData){
            with(binding){
                Glide.with(itemView)
                    .load(data.imageListGame)
                    .into(imageView5)

                textView9.text = data.titleImage
                textView7.text = data.titleGame
                textView8.text = data.desc

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListGameViewHolder {
        return ListGameViewHolder(ItemListgameBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ListGameViewHolder, position: Int) {
        holder.bind(item[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailGameActivity::class.java)

            holder.itemView.context.startActivity(intent)
        }

        holder.itemView.findViewById<Button>(R.id.button_play_game_adapter).setOnClickListener {
            val intent = Intent(holder.itemView.context, WelcomeGameActivity::class.java)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = item.size
}