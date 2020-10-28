package com.example.cleanarchdemo.ui.registration

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchdemo.R
import com.example.cleanarchdemo.databinding.FragmentRegistrationBinding
import com.example.cleanarchdemo.ui.state.ViewState
import com.example.cleanarchdemo.utils.AGE_RESTRICTION
import com.example.cleanarchdemo.viewmodel.RegistrationViewModel
import dagger.android.support.DaggerFragment
import java.util.*
import java.util.Calendar.*
import javax.inject.Inject

class RegistrationFragment : DaggerFragment(R.layout.fragment_registration), View.OnClickListener,
    DatePickerDialog.OnDateSetListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: RegistrationViewModel
    private lateinit var binding: FragmentRegistrationBinding
    private val progressBar by lazy {
        ProgressDialog(context).apply {
            setMessage(getString(R.string.text_please_wait))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariable(view)
        initListener()
        subscribe()
    }

    private fun subscribe() {
        viewModel.getViewState().observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is ViewState.Loading -> {
                    progressBar.show()
                }
                is ViewState.Success -> {
                    progressBar.dismiss()
                    showSuccessMessage()
                }
                is ViewState.Error -> {
                    Toast.makeText(
                        context,
                        getString(R.string.text_insertion_error),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun showSuccessMessage() {
        AlertDialog.Builder(context)
            .setMessage(getString(R.string.customer_insertion_success))
            .setPositiveButton(getString(R.string.text_okay)) { dialog, which ->
                dialog.dismiss()
                viewModel.registrationModel.setDefault()
            }
            .create().show()
    }

    private fun initListener() {
        binding.vDob.setOnClickListener(this)
        binding.tvSubmit.setOnClickListener(this)
    }

    private fun initVariable(view: View) {
        binding = DataBindingUtil.bind(view)!!
        viewModel = ViewModelProvider(this, viewModelFactory).get(RegistrationViewModel::class.java)
        binding.model = viewModel.registrationModel
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.vDob -> {
                showDatePicker()
            }
            R.id.tvSubmit -> {
                viewModel.submitCustomer()
            }
        }
    }

    private fun showDatePicker() {
        val calender = Calendar.getInstance()
        calender.set(YEAR, calender.get(YEAR) - AGE_RESTRICTION)
        val picker = DatePickerDialog(
            requireContext(),
            this,
            calender.get(YEAR),
            calender.get(MONTH),
            calender.get(DAY_OF_MONTH)
        )
        calender.set(HOUR_OF_DAY, 23)
        calender.set(MINUTE, 59)
        calender.set(SECOND, 59)
        picker.datePicker.maxDate = calender.timeInMillis
        picker.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        viewModel.registrationModel.dob = "$dayOfMonth-$month-$year"
    }
}