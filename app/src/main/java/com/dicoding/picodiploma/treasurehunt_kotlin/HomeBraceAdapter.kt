package com.dicoding.picodiploma.treasurehunt_kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.picodiploma.treasurehunt_kotlin.databinding.ItemBraceHomeBinding

class HomeBraceAdapter(private val item : List<BraceData>) : RecyclerView.Adapter<HomeBraceAdapter.BraceViewHolder>() {
    inner class BraceViewHolder (itemView : ItemBraceHomeBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView
        fun bind(data: BraceData){
            with(binding){
                Glide.with(itemView)
                    .load(data.imageBrace)
                    .into(braceImage)


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BraceViewHolder {
        return BraceViewHolder(ItemBraceHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BraceViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun getItemCount(): Int = item.size
}