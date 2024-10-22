package com.example.sequence.feature.detail.presentation

import androidx.lifecycle.ViewModel

class DetailViewModel(
	private val router: DetailRouter,
) : ViewModel() {

	fun navigationBack() {
		router.navigationBack()
	}
}