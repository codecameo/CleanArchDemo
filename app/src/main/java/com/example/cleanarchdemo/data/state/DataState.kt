package com.example.cleanarchdemo.data.state

sealed class DataState<Data> {
    class Success<Data>(val dataResponse : DataSuccessResponse<Data>) : DataState<Data>()
    class Error<Data>(val dataResponse : DataErrorResponse<Data>) : DataState<Data>()
}