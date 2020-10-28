package com.example.cleanarchdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchdemo.data.local.db.CustomerEntity
import com.example.cleanarchdemo.data.state.DataState
import com.example.cleanarchdemo.domain.usecase.InsertCustomerUsecase
import com.example.cleanarchdemo.ui.registration.model.RegistrationModel
import com.example.cleanarchdemo.ui.state.ViewState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(
    private val insertCustomerUsecase: InsertCustomerUsecase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    @Inject
    lateinit var registrationModel: RegistrationModel
    private val _viewState = MediatorLiveData<ViewState<Long>>()

    fun getViewState(): LiveData<ViewState<Long>> = _viewState
    fun submitCustomer() {
        _viewState.value = ViewState.Loading()
        viewModelScope.launch(dispatcher) {
            when(val response = insertCustomerUsecase.insertCustomer(getCustomerEntity())) {
                is DataState.Success -> _viewState.postValue(ViewState.Success(response.dataResponse.data))
                is DataState.Error -> _viewState.postValue(ViewState.Error(response.dataResponse.errorMessage))
            }
        }
    }

    private fun getCustomerEntity(): CustomerEntity {
        return registrationModel.run {
            CustomerEntity(id = null,
            username = userName,
            phone = phone,
            postalCode = postalCode,
            postOffice = postOffice,
            district = district,
            thana = thana,
            dob = dob,
            createdAt = System.currentTimeMillis())
        }
    }
}