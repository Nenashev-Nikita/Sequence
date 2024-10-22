package com.example.sequence.presentation

import androidx.lifecycle.ViewModel

class MainViewModel(
	private val router: MainRouter
) : ViewModel() {

	fun setStartScreen() {
		router.navigateToFilm()
	}
}