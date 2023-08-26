package com.example.carfinder.features.carsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.carfinder.data.models.Image
import com.example.carfinder.databinding.CarsImagesListItemBinding

class CarsImagesAdapter(
    private val images: List<Image>
) : Adapter<CarsImagesAdapter.ImagesViewHolder>() {

    class ImagesViewHolder(
        private val binding: CarsImagesListItemBinding
    ) : ViewHolder(binding.root) {

        fun bind(item: Image) {
            Glide
                .with(itemView.context)
                .load(item.url)
                .centerCrop()
                .into(binding.ivCarImage)
        }

        companion object {
            fun from(parent: ViewGroup): ImagesViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = CarsImagesListItemBinding.inflate(inflater, parent, false)
                return ImagesViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        return ImagesViewHolder.from(parent)
    }

    override fun getItemCount() = images.size

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val item = images[position]
        holder.bind(item)
    }
}