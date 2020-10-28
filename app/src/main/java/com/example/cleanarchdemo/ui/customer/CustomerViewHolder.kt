package com.example.cleanarchdemo.ui.customer

import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchdemo.databinding.ItemCustomerBinding
import com.example.cleanarchdemo.domain.entity.CustomerInfoEntity

class CustomerViewHolder(
    private val binding: ItemCustomerBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bindTo(model: CustomerInfoEntity) {
        binding.model = model
    }
}