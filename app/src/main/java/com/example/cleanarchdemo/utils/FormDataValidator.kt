package com.example.cleanarchdemo.utils

class FormDataValidator {
    private val minTextLength = 2
    private val textRex = "([a-zA-z]|\\s|)*".toRegex()
    private val nameRex = "([a-zA-z.]|\\s|-)*".toRegex()
    private val phoneRex = "01[35-9][0-9]{8}".toRegex()
    private val postalCodeRex = "[0-9]{4}".toRegex()

    fun checkText(text: String): Boolean {
        return text.length >= minTextLength && textRex.matches(text)
    }

    fun checkName(text: String): Boolean {
        return text.length >= minTextLength && nameRex.matches(text)
    }

    fun checkPostalCode(text: String): Boolean {
        return postalCodeRex.matches(text)
    }

    fun checkPhone(text: String): Boolean {
        return phoneRex.matches(text)
    }

    fun checkDob(text: String): Boolean {
        return text.isNotEmpty()
    }
}