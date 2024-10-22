package com.example.sequence.feature.film.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmModel(
	val id: Long,
	@Json(name = "localized_name")
	val name: String,
	@Json(name = "name")
	val originalName: String,
	val year: Int,
	val rating: Double?,
	@Json(name = "image_url")
	val img: String?,
	val description: String?,
	val genres: List<String>,
)

@JsonClass(generateAdapter = true)
data class FilmsModel(
	val films: List<FilmModel>
)