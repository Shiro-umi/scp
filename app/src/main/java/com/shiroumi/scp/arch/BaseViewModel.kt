package com.shiroumi.scp.arch

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiroumi.scp.KEY_AUTO_INITIALIZED
import com.shiroumi.scp.arch.delegations.ViewModelStateDelegation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val viewModelStateDelegation = ViewModelStateDelegation(savedStateHandle)

    private var autoInitialized: Boolean? = savedStateHandle.get<Boolean>(KEY_AUTO_INITIALIZED)

    fun autoInitialize() {
        if (autoInitialized == true) return
        initialize()
        savedStateHandle.set(KEY_AUTO_INITIALIZED, true)
        autoInitialized = true
    }

    abstract fun initialize()
}