package com.example.sequence.feature.film.domain.usecase

import com.example.sequence.feature.film.domain.repository.FilmRepository
import com.example.sequence.shared.movie.domain.entity.Film

class FilterFilmsByGenresUseCase(
	private val repository: FilmRepository
) {

	suspend operator fun invoke(genre: String?): List<Film> {
		val films = repository.getAllFilms()

		return if (genre != null) {
			films.filter {
				it.genres.contains(genre)
			}
		} else {
			films
		}
	}
}