package com.example.sequence.feature.film.domain.repository

import com.example.sequence.shared.movie.domain.entity.Film

interface FilmRepository {

	suspend fun getAllFilms(): List<Film>
}