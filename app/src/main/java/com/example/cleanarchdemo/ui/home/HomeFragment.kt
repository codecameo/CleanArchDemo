package com.example.cleanarchdemo.ui.home

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.cleanarchdemo.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : DaggerFragment(R.layout.fragment_home), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariables()
        initListener()
    }

    private fun initListener() {
        tvRegisterCustomer.setOnClickListener(this)
        tvViewCustomer.setOnClickListener(this)
    }

    private fun initVariables() {
        navController = findNavController(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.tvViewCustomer -> navController.navigate(R.id.action_homeFragment_to_customerFragment)
            R.id.tvRegisterCustomer-> navController.navigate(R.id.action_homeFragment_to_registrationFragment)
        }
    }
}