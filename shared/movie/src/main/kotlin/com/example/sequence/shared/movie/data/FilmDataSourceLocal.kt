package com.example.sequence.shared.movie.data

import android.content.SharedPreferences
import com.example.sequence.component.preferences.convertObjectFromJson
import com.example.sequence.component.preferences.convertToJsonAndPut
import com.example.sequence.shared.movie.domain.Film
import com.google.gson.Gson

class FilmDataSourceLocal(
	private val gson: Gson,
	private val sharedPreferences: SharedPreferences,
) {

	companion object {

		const val PREFERENCES = "PREFERENCES"
		private const val EMPTY_STRING = ""
		private const val KEY_FILMS = "KEY_FILMS"
		private const val KEY_DETAIL = "KEY_DETAIL"
	}

	fun saveFilms(films: List<Film>) {
		sharedPreferences.edit().convertToJsonAndPut(gson = gson, key = KEY_FILMS, data = films)
	}

	fun getAllFilms(): List<Film> {
		val json = sharedPreferences.getString(KEY_FILMS, EMPTY_STRING) ?: EMPTY_STRING
		return convertObjectFromJson<List<Film>>(gson = gson, objectInJson = json) ?: listOf()
	}

	fun changeDetailFilm(film: Film) {
		sharedPreferences.edit().remove(KEY_DETAIL).apply()
		sharedPreferences.edit().convertToJsonAndPut(gson = gson, key = KEY_DETAIL, data = film)
	}

	fun getDetailFilm(): Film? {
		val json = sharedPreferences.getString(KEY_DETAIL, EMPTY_STRING) ?: EMPTY_STRING
		return convertObjectFromJson<Film>(gson = gson, objectInJson = json)
	}
}