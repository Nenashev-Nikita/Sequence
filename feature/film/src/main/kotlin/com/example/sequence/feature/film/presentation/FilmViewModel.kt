package com.example.sequence.feature.film.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sequence.feature.film.domain.usecase.FilterFilmsByGenresUseCase
import com.example.sequence.feature.film.domain.usecase.GetAllFilmsUseCase
import com.example.sequence.shared.movie.domain.entity.Film
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class FilmViewModel(
	private val getAllFilmsUseCase: GetAllFilmsUseCase,
	private val filterFilmsByGenresUseCase: FilterFilmsByGenresUseCase,
	private val router: FilmRouter,
) : ViewModel() {

	private val _films = MutableLiveData<List<Film>>()
	val films: LiveData<List<Film>> = _films

	private val _isLoading = MutableLiveData<Boolean>()
	val isLoading: LiveData<Boolean> = _isLoading

	private val _error = MutableLiveData<Boolean>()
	val error: LiveData<Boolean> = _error

	private val _genre = MutableLiveData<String?>()
	val genre: LiveData<String?> = _genre

	private val errorHandler = CoroutineExceptionHandler { _, _ ->
		_error.value = true
		_isLoading.value = false
	}

	fun loadFilms() {
		viewModelScope.launch(errorHandler) {
			_isLoading.value = true
			_error.value = false

			_films.value = getAllFilmsUseCase()
			_isLoading.value = false
		}
	}

	fun filterFilmsByGenres(selectedGenres: String) {
		val genreToFilter = if (selectedGenres != _genre.value) selectedGenres else null
		_genre.value = genreToFilter

		viewModelScope.launch(errorHandler) {
			val filmsByGenre = filterFilmsByGenresUseCase(genreToFilter)
			_films.value = filmsByGenre
		}
	}

	fun openFilmDetails(film: Film) {
		router.navigateToDetail(film)
	}
}