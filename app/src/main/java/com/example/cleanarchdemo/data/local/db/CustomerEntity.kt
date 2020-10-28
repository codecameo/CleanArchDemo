package com.example.cleanarchdemo.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CustomerEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long? = null,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "dob")
    val dob: String,
    @ColumnInfo(name = "postal_code")
    val postalCode: String,
    @ColumnInfo(name = "post_office")
    val postOffice: String,
    @ColumnInfo(name = "thana")
    val thana: String,
    @ColumnInfo(name = "district")
    val district: String,
    @ColumnInfo(name = "created_at")
    val createdAt: Long
)