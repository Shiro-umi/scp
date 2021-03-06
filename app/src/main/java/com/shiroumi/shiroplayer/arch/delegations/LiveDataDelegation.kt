package com.shiroumi.shiroplayer.arch.delegations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.shiroumi.shiroplayer.arch.livedata.BaseLiveData
import com.shiroumi.shiroplayer.arch.viewmodel.BaseStatefulViewModel
import kotlin.reflect.KProperty

class LiveDataDelegation<T> constructor(
    private val savedStateHandle: SavedStateHandle,
    private val tag: String
) : AbstractViewModelFieldDelegation<MutableLiveData<T>>() {
    override val value: MutableLiveData<T> = BaseLiveData(tag, savedStateHandle)
        get() {
            field.value = savedStateHandle[tag]
            return field
        }

    override operator fun getValue(
        thisRef: BaseStatefulViewModel,
        property: KProperty<*>
    ): MutableLiveData<T> {
        return value
    }
}