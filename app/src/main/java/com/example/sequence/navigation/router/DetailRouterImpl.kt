package com.example.sequence.navigation.router

import com.example.sequence.feature.detail.presentation.DetailRouter
import com.example.sequence.feature.film.ui.getFilmScreen
import com.github.terrakok.cicerone.Router

class DetailRouterImpl(private val router: Router): DetailRouter {

	override fun navigationBack() {
		router.navigateTo(getFilmScreen())
	}
}