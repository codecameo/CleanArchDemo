package com.example.cleanarchdemo.data.state

import com.example.cleanarchdemo.utils.INTERNAL_ERROR

sealed class DataResponse<Data>

data class DataSuccessResponse<Data>(
    val data: Data? = null,
    val message: String? = null
) : DataResponse<Data>()

data class DataErrorResponse<Data>(
    val statusCode: Int = INTERNAL_ERROR,
    val errorMessage: String? = null
) : DataResponse<Data>()