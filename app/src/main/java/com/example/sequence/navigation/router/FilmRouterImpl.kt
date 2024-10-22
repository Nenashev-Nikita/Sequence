package com.example.sequence.navigation.router

import com.example.sequence.feature.detail.ui.getDetailScreen
import com.example.sequence.feature.film.presentation.FilmRouter
import com.example.sequence.shared.movie.domain.entity.Film
import com.github.terrakok.cicerone.Router

class FilmRouterImpl(private val router: Router) : FilmRouter {

    override fun navigateToDetail(film: Film) {
        router.navigateTo(getDetailScreen(film))
    }
}