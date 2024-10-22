package com.example.sequence.feature.film.presentation

import com.example.sequence.shared.movie.domain.Film

sealed interface FilmState {

	data object Loading : FilmState

	data object Failure : FilmState

	data class Content(
		val films: List<Film>,
		val genre: String?,
	) : FilmState
}