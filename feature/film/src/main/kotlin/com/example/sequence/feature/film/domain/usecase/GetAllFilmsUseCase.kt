package com.example.sequence.feature.film.domain.usecase

import com.example.sequence.feature.film.domain.repository.FilmRepository
import com.example.sequence.shared.movie.domain.entity.Film

class GetAllFilmsUseCase(
	private val repository: FilmRepository
) : suspend () -> List<Film> by repository::getAllFilmsRepository