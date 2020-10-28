package com.example.cleanarchdemo.ui.customer

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchdemo.R
import com.example.cleanarchdemo.databinding.FragmentCustomerBinding
import com.example.cleanarchdemo.domain.entity.CustomerInfoEntity
import com.example.cleanarchdemo.ui.state.ViewState
import com.example.cleanarchdemo.viewmodel.CustomerViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CustomerFragment : DaggerFragment(R.layout.fragment_customer) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CustomerViewModel
    private lateinit var binding: FragmentCustomerBinding
    private val adapter by lazy { CustomerAdapter() }
    private val progressBar by lazy {
        ProgressDialog(context).apply {
            setMessage(getString(R.string.text_please_wait))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariable(view)
        setupList()
        subscribe()
        fetchData()
    }

    private fun fetchData() {
        viewModel.getLatestCustomer()
    }

    private fun setupList() {
        binding.rvCustomer.adapter = adapter
    }

    private fun initVariable(view: View) {
        binding = DataBindingUtil.bind(view)!!
        viewModel = ViewModelProvider(this, viewModelFactory).get(CustomerViewModel::class.java)
    }

    private fun subscribe() {
        viewModel.getViewState().observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is ViewState.Loading -> {
                    progressBar.show()
                }
                is ViewState.Success -> {
                    progressBar.dismiss()
                    showList(state.data)
                }
                is ViewState.Error -> {
                    Toast.makeText(
                        context,
                        getString(R.string.text_error_fetch_customer),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun showList(data: List<CustomerInfoEntity>?) {
        if (data.isNullOrEmpty()) return
        adapter.submitList(data)
    }
}