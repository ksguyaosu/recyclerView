package com.example.android.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.recyclerview.databinding.PlayerItemBinding

class BasketballAdapter: RecyclerView.Adapter<BasketballAdapter.BasketballHolder>() {
    val PlayerList = ArrayList<Player>()
    class BasketballHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PlayerItemBinding.bind(item)
        fun bind(player: Player) = with(binding){
            im.setImageResource(player.imageId)
            tvTitle.text = player.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketballHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.player_item, parent, false)
        return BasketballHolder(view)
    }

    override fun onBindViewHolder(holder: BasketballHolder, position: Int) {
        holder.bind(PlayerList[position])
    }

    override fun getItemCount(): Int {
        return PlayerList.size
    }

    fun addPlayer(player: Player){
        PlayerList.add(player)
        notifyDataSetChanged()
    }

}