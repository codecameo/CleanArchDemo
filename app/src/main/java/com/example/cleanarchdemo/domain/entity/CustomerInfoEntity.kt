package com.example.cleanarchdemo.domain.entity

import androidx.room.ColumnInfo

data class CustomerInfoEntity(
    @ColumnInfo(name = "username")
    val name: String,
    @ColumnInfo(name = "phone")
    val phoneNumber: String
)