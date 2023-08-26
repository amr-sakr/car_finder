package com.example.carfinder.features.carsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.carfinder.data.models.UsedCar
import com.example.carfinder.databinding.UsedCarsListItemBinding
import com.google.android.material.tabs.TabLayoutMediator

class CarsListAdapter : ListAdapter<UsedCar, CarsListAdapter.CarsViewHolder>(UsedCarDiffUtil) {

    class CarsViewHolder(
        private val binding: UsedCarsListItemBinding
    ) : ViewHolder(binding.root) {

        fun bind(item: UsedCar) {
            val imagesAdapter = CarsImagesAdapter(item.images ?: listOf())
            binding.apply {

                if (!item.images.isNullOrEmpty()) {
                    viewPagerImages.adapter = imagesAdapter
                    TabLayoutMediator(
                        imagesTabLayout,
                        viewPagerImages
                    ) { _, _ -> }.attach()
                    viewPagerImages.visibility = View.VISIBLE
                    imagesTabLayout.visibility = View.VISIBLE

                } else {
                    viewPagerImages.visibility = View.GONE
                    imagesTabLayout.visibility = View.GONE
                }


                val brandAndModel = "${item.make} ${item.model}"
                tvBrandAndModel.text = brandAndModel
                tvFirstRegister.text = item.firstRegistration
                tvModelLine.text = item.modelline
                tvModelLine.visibility = if (item.modelline != null) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
                val mileage = "${item.mileage} KM"
                tvMileage.text = mileage

                tvFuel.text = item.fuel
                val price = "€ ${item.price}"
                tvPrice.text = price

                tvDescription.text = item.description

                if (item.seller != null) {
                    tvSellerType.text = item.seller.type
                    tvSellerPhone.text = item.seller.phone
                    tvSellerCity.text = item.seller.city
                    layoutSellerIfo.visibility = View.VISIBLE
                } else {
                    layoutSellerIfo.visibility = View.GONE
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): CarsViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = UsedCarsListItemBinding.inflate(inflater, parent, false)
                return CarsViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        return CarsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        object UsedCarDiffUtil : DiffUtil.ItemCallback<UsedCar>() {
            override fun areItemsTheSame(oldItem: UsedCar, newItem: UsedCar): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UsedCar, newItem: UsedCar): Boolean {
                return oldItem == newItem
            }

        }
    }
}