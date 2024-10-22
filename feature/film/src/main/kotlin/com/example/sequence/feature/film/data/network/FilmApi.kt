package com.example.sequence.feature.film.data.network

import com.example.sequence.feature.film.data.model.FilmsModel
import retrofit2.http.GET

interface FilmApi {

	@GET("films.json")
	suspend fun getAll(): FilmsModel
}