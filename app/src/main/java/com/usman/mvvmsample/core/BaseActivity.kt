package com.usman.mvvmsample.core


import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

abstract class BaseActivity<DB:ViewDataBinding,VM:BaseViewModel>(mViewModelClass: Class<VM>) : AppCompatActivity() {

    @LayoutRes
    abstract fun getLayoutRes(): Int

    lateinit var binding:DB

    val viewModel by lazy {
        ViewModelProviders.of(this, getVMFactory()).get(mViewModelClass)
    }

    abstract fun getVMFactory(): ViewModelProvider.Factory

    /**
     * If you want to inject Dependency Injection
     * on your activity, you can override this.
     */
    open fun onInject() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        onInject()
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        super.onCreate(savedInstanceState)
        initViewModel(viewModel)
    }

    /**
     *
     *  You need override this method.
     *  And you need to set viewModel to binding: binding.viewModel = viewModel
     *
     */
    abstract fun initViewModel(viewModel: VM)
}


