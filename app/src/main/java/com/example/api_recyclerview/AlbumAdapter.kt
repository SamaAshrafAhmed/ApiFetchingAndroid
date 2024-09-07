package com.example.apidepi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apidepi.databinding.AlbumLayoutBinding

class AlbumAdapter(
    val list:List<Album>
):RecyclerView.Adapter<AlbumAdapter.viewHolder>(){

    inner class viewHolder(val binding:AlbumLayoutBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(album:Album){
            binding.albumTitleTv.text = album.title
            binding.albumIdTv.text = album.id.toString()
            binding.userIdTv.text = album.userId.toString()


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding = AlbumLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
       holder.bind(list[position])
    }
}