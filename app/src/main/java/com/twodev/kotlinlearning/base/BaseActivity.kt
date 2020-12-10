package com.twodev.kotlinlearning.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.twodev.kotlinlearning.App.LocaleManager
import com.twodev.kotlinlearning.showToast

abstract class BaseActivity<ViewModel : BaseViewModel>(private var layoutId: Int) : AppCompatActivity() {

    abstract val viewModel: ViewModel

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleManager.setLocale(newBase!!))
        initLanguage()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        setupViews()
        setupLiveData()
        showError()
    }

private fun initLanguage() {

}


abstract fun setupLiveData()
abstract fun setupViews()

private fun showError() {
    viewModel.errorMessage.observeForever {
        showToast(it.toString())
    }
}


}