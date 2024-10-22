package com.example.sequence.navigation.router

import com.example.sequence.feature.film.ui.getFilmScreen
import com.example.sequence.presentation.MainRouter
import com.github.terrakok.cicerone.Router

class MainRouterImpl(
	private val router: Router
) : MainRouter {

	override fun navigateToFilm() {
		router.newRootScreen(getFilmScreen())
	}
}