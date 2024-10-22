package com.example.sequence.feature.film.presentation

import com.example.sequence.shared.movie.domain.entity.Film

interface FilmRouter {

	fun navigateToDetail(film: Film)
}