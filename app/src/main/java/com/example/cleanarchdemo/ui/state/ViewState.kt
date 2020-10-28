package com.example.cleanarchdemo.ui.state

import com.example.cleanarchdemo.utils.EMPTY_STRING

sealed class ViewState<Data> {
    class Loading<Data>(
        val data: Data? = null
    ) : ViewState<Data>()

    class Success<Data>(
        val data: Data?,
        val message: String? = EMPTY_STRING
    ) : ViewState<Data>()

    class Error<Data>(
        val errorMessage: String? = null
    ) : ViewState<Data>()
}