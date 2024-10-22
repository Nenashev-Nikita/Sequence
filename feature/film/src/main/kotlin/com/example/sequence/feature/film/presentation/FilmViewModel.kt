package com.example.sequence.feature.film.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sequence.feature.film.domain.usecase.GetAllFilmsUseCase
import com.example.sequence.feature.film.domain.usecase.FilterFilmsByGenresUseCase
import com.example.sequence.shared.movie.domain.Film
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FilmViewModel(
	private val getAllFilmsUseCase: GetAllFilmsUseCase,
	private val filterFilmsByGenresUseCase: FilterFilmsByGenresUseCase,
	private val router: FilmRouter,
) : ViewModel() {

	private val _uiState = MutableStateFlow<FilmState>(FilmState.Loading)
	val uiState: StateFlow<FilmState> = _uiState

	private val errorHandler = CoroutineExceptionHandler { _, _ ->
		_uiState.value = FilmState.Failure
	}

	fun getFilms() {
		viewModelScope.launch(errorHandler) {
				val films = getAllFilmsUseCase()
				_uiState.value = FilmState.Content(
					films = films,
					genre = null,
				)
		}
	}

	fun filterFilmsByGenres(selectedGenres: String) {
		val state = uiState.value as? FilmState.Content ?: return

		val genreToFilter = if (selectedGenres != state.genre) selectedGenres else null

		viewModelScope.launch(errorHandler) {
			val films = filterFilmsByGenresUseCase(genreToFilter)

			_uiState.value = FilmState.Content(
				films = films,
				genre = genreToFilter,
			)
		}
	}

	fun openFilmDetails(film: Film) {
		router.navigateToDetail(film)
	}
}