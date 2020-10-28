package com.example.cleanarchdemo.ui.customer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.cleanarchdemo.R
import com.example.cleanarchdemo.databinding.ItemCustomerBinding
import com.example.cleanarchdemo.domain.entity.CustomerInfoEntity

class CustomerAdapter: ListAdapter<CustomerInfoEntity, CustomerViewHolder>(CustomerDiffutil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val binding = DataBindingUtil.inflate<ItemCustomerBinding>(LayoutInflater.from(parent.context), R.layout.item_customer, parent, false)
        return CustomerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }
}