package com.example.sequence.shared.movie.domain.entity

import java.io.Serializable

data class Film(
	val id: Long,
	val name: String,
	val originalName: String,
	val year: Int,
	val rating: Double? = null,
	val img: String? = null,
	val description: String? = null,
	val genres: List<String>,
) : Serializable
