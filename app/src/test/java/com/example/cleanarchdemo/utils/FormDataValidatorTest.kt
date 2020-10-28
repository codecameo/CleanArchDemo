package com.example.cleanarchdemo.utils

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class FormDataValidatorTest {

    private lateinit var sut: FormDataValidator

    @Before
    fun setup() {
        sut = FormDataValidator()
    }

    @Test
    fun checkValidName() {
        val text = "test"
        val actual = sut.checkName(text)
        assertEquals(true, actual)
    }

    @Test
    fun checkNumericName() {
        val text = "text1"
        val actual = sut.checkName(text)
        assertEquals(false, actual)
    }

    @Test
    fun checkShortName() {
        val text = "t"
        val actual = sut.checkName(text)
        assertEquals(false, actual)
    }

    @Test
    fun checkMinLengthName() {
        val text = "tx"
        val actual = sut.checkName(text)
        assertEquals(true, actual)
    }

    @Test
    fun checkUpperCaseName() {
        val text = "txTEXT"
        val actual = sut.checkName(text)
        assertEquals(true, actual)
    }

    @Test
    fun checkValidSpecialCharName() {
        val text = "Md. Sifat-Ul Haque"
        val actual = sut.checkName(text)
        assertEquals(true, actual)
    }

    @Test
    fun checkInvalidSpecialCharName() {
        val text = "*txTEX T.-$%("
        val actual = sut.checkName(text)
        assertEquals(false, actual)
    }

    @Test
    fun checkValidText() {
        val text = "test"
        val actual = sut.checkText(text)
        assertEquals(true, actual)
    }

    @Test
    fun checkNumericText() {
        val text = "text1"
        val actual = sut.checkText(text)
        assertEquals(false, actual)
    }

    @Test
    fun checkShortText() {
        val text = "t"
        val actual = sut.checkText(text)
        assertEquals(false, actual)
    }

    @Test
    fun checkMinLengthText() {
        val text = "tx"
        val actual = sut.checkText(text)
        assertEquals(true, actual)
    }

    @Test
    fun checkUpperCaseText() {
        val text = "txTEXT"
        val actual = sut.checkText(text)
        assertEquals(true, actual)
    }

    @Test
    fun checkValidSpecialCharText() {
        val text = "Md. Sifat-Ul Haque"
        val actual = sut.checkText(text)
        assertEquals(false, actual)
    }

    @Test
    fun checkInvalidSpecialCharText() {
        val text = "*txTEX T.-$%("
        val actual = sut.checkText(text)
        assertEquals(false, actual)
    }

    @Test
    fun checkValidPhone() {
        val phone = "01682425474"
        val actual = sut.checkPhone(phone)
        assertEquals(true, actual)
    }

    @Test
    fun checkValidGPPhone() {
        val phone = "01382425474"
        val actual = sut.checkPhone(phone)
        assertEquals(true, actual)
    }

    @Test
    fun checkInvalidPhone() {
        val phone = "01282425474"
        val actual = sut.checkPhone(phone)
        assertEquals(false, actual)
    }

    @Test
    fun checkInvalidOperatorPhone() {
        val phone = "11682425474"
        val actual = sut.checkPhone(phone)
        assertEquals(false, actual)
    }

    @Test
    fun checkLargePhone() {
        val phone = "016824254741"
        val actual = sut.checkPhone(phone)
        assertEquals(false, actual)
    }

    @Test
    fun checkShortPhone() {
        val phone = "0168242547"
        val actual = sut.checkPhone(phone)
        assertEquals(false, actual)
    }

    @Test
    fun checkValidPostalCode() {
        val code = "7264"
        val actual = sut.checkPostalCode(code)
        assertEquals(true, actual)
    }

    @Test
    fun checkInvalidPostalCode() {
        val code = "726X"
        val actual = sut.checkPostalCode(code)
        assertEquals(false, actual)
    }

    @Test
    fun checkShortPostalCode() {
        val code = "726"
        val actual = sut.checkPostalCode(code)
        assertEquals(false, actual)
    }

    @Test
    fun checkLongPostalCode() {
        val code = "72694"
        val actual = sut.checkPostalCode(code)
        assertEquals(false, actual)
    }
}