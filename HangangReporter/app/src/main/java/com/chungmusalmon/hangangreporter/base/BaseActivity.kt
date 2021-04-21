package com.chungmusalmon.hangangreporter.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<DB : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {
    protected lateinit var binding : DB

    abstract val layoutRes : Int
    abstract val viewModel : VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init(){
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.lifecycleOwner = this
    }
}