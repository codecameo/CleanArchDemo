package com.example.cleanarchdemo.ui.customer

import androidx.recyclerview.widget.DiffUtil
import com.example.cleanarchdemo.domain.entity.CustomerInfoEntity

class CustomerDiffutil: DiffUtil.ItemCallback<CustomerInfoEntity>() {
    override fun areItemsTheSame(
        oldItem: CustomerInfoEntity,
        newItem: CustomerInfoEntity
    ): Boolean {
        return oldItem.name == newItem.name && oldItem.phoneNumber == newItem.phoneNumber
    }

    override fun areContentsTheSame(
        oldItem: CustomerInfoEntity,
        newItem: CustomerInfoEntity
    ): Boolean {
        return oldItem.name == newItem.name && oldItem.phoneNumber == newItem.phoneNumber
    }
}