package com.example.cleanarchdemo.ui.registration.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.cleanarchdemo.BR
import com.example.cleanarchdemo.utils.EMPTY_STRING
import com.example.cleanarchdemo.utils.FormDataValidator

class RegistrationModel(
    private val validator: FormDataValidator
) : BaseObservable() {

    val autofillMap = mutableMapOf<String, AddressEntity>()

    init {
        autofillMap["1200"] = AddressEntity("Dhanmondi", "Dhanmondi Model", "Dhaka")
        autofillMap["1214"] = AddressEntity("Agargaon", "Agargaon Model", "Dhaka")
        autofillMap["1330"] = AddressEntity("Dhamrai", "Dhamrai Sadar", "Savar")
    }

    @Bindable
    var userName: String = EMPTY_STRING
        set(value) {
            if (field == value) return
            field = value
            checkDataValidation()
            notifyPropertyChanged(BR.userName)
        }

    @Bindable
    var phone: String = EMPTY_STRING
        set(value) {
            if (field == value) return
            field = value
            checkDataValidation()
            notifyPropertyChanged(BR.phone)
        }

    @Bindable
    var dob: String = EMPTY_STRING
        set(value) {
            if (field == value) return
            field = value
            checkDataValidation()
            notifyPropertyChanged(BR.dob)
        }

    @Bindable
    var thana: String = EMPTY_STRING
        set(value) {
            if (field == value) return
            field = value
            checkDataValidation()
            notifyPropertyChanged(BR.thana)
        }

    @Bindable
    var district: String = EMPTY_STRING
        set(value) {
            if (field == value) return
            field = value
            checkDataValidation()
            notifyPropertyChanged(BR.district)
        }

    @Bindable
    var postalCode: String = EMPTY_STRING
        set(value) {
            if (field == value) return
            field = value
            checkAutoFill(value)
            checkDataValidation()
            notifyPropertyChanged(BR.postalCode)
        }

    private fun checkAutoFill(value: String) {
        autofillMap[value]?.let { address ->
            postOffice = address.postOffice
            thana = address.thana
            district = address.district
        }
    }

    @Bindable
    var postOffice: String = EMPTY_STRING
        set(value) {
            if (field == value) return
            field = value
            checkDataValidation()
            notifyPropertyChanged(BR.postOffice)
        }

    @Bindable
    var shouldEnable = false
        set(value) {
            if (field == value) return
            field = value
            notifyPropertyChanged(BR.shouldEnable)
        }

    private fun checkDataValidation() {
        shouldEnable = validator.checkName(userName)
                && validator.checkPhone(phone)
                && validator.checkPostalCode(postalCode)
                && validator.checkText(postOffice)
                && validator.checkText(thana)
                && validator.checkText(district)
                && validator.checkDob(dob)
    }

    fun setDefault() {
        userName = EMPTY_STRING
        phone = EMPTY_STRING
        postOffice = EMPTY_STRING
        postalCode = EMPTY_STRING
        thana = EMPTY_STRING
        district = EMPTY_STRING
        dob = EMPTY_STRING
    }
}