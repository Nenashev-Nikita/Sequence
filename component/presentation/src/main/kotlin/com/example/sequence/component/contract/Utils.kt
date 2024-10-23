package com.example.sequence.component.contract

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

fun <T> LiveData<T>.asStateFlow(initialValue: T): StateFlow<T> {
	val stateFlow = MutableStateFlow(initialValue)
	this.observeForever { value ->
		stateFlow.value = value ?: initialValue
	}
	return stateFlow
}