package com.example.sequence.feature.film.data.repository

import com.example.sequence.feature.film.data.converter.FilmConverter
import com.example.sequence.feature.film.data.datasource.FilmDataSourceLocal
import com.example.sequence.feature.film.data.network.FilmApi
import com.example.sequence.feature.film.domain.repository.FilmRepository
import com.example.sequence.shared.movie.domain.entity.Film

class FilmRepositoryImpl(
	private val api: FilmApi,
	private val filmConverter: FilmConverter,
) : FilmRepository {

	override suspend fun getAllFilmsRepository(): List<Film> {
		val films = api.getAll().films
			.map { filmConverter(it) }
			.sortedBy { it.originalName }

		return films
	}
}