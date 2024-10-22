package com.example.sequence.feature.film.data.converter

import com.example.sequence.feature.film.data.model.FilmModel
import com.example.sequence.shared.movie.domain.entity.Film

class FilmConverter {

	operator fun invoke(model: FilmModel): Film =
		Film(
			id = model.id,
			name = model.name,
			originalName = model.originalName,
			description = model.description,
			genres = model.genres,
			year = model.year,
			rating = model.rating,
			img = model.img,
		)
}