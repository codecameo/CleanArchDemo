package com.example.cleanarchdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchdemo.data.state.DataState
import com.example.cleanarchdemo.domain.entity.CustomerInfoEntity
import com.example.cleanarchdemo.domain.usecase.LatestCustomerUsecase
import com.example.cleanarchdemo.ui.state.ViewState
import com.example.cleanarchdemo.ui.state.ViewState.Error
import com.example.cleanarchdemo.ui.state.ViewState.Success
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class CustomerViewModel @Inject constructor(
    private val latestCustomerUsecase: LatestCustomerUsecase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _viewState = MediatorLiveData<ViewState<List<CustomerInfoEntity>>>()
    fun getViewState(): LiveData<ViewState<List<CustomerInfoEntity>>> = _viewState

    fun getLatestCustomer() {
        _viewState.value = ViewState.Loading()
        viewModelScope.launch(dispatcher) {
            when(val response = latestCustomerUsecase.getLatestConsumers()) {
                is DataState.Success -> _viewState.postValue(Success(response.dataResponse.data))
                is DataState.Error -> _viewState.postValue(Error(response.dataResponse.errorMessage))
            }
        }
    }
}