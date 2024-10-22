package com.example.sequence.feature.film.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.sequence.design.component.AppBar
import com.example.sequence.design.component.Loading
import com.example.sequence.design.theme.SequenceTheme
import com.example.sequence.feature.film.R
import com.example.sequence.feature.film.presentation.FilmState
import com.example.sequence.shared.movie.domain.Film
import kotlinx.coroutines.flow.StateFlow

@Composable
internal fun FilmScreen(
	uiStateFlow: StateFlow<FilmState>,
	onReloadFilms: () -> Unit,
	onGenres: (String) -> Unit,
	navigateToDetail: (Film) -> Unit,
) {

	val uiState by uiStateFlow.collectAsState()

	Column(
		modifier = Modifier
			.fillMaxSize()
			.background(SequenceTheme.colors.background)
	) {
		AppBar(
			title = stringResource(R.string.title_appbar),
		)

		when (val state = uiState) {
			is FilmState.Loading -> Loading()

			is FilmState.Failure -> {
				val colors = ButtonDefaults.textButtonColors().copy(
					containerColor = Color.Transparent,
					contentColor = SequenceTheme.colors.container,
				)

				Box(
					modifier = Modifier.fillMaxSize(),
					contentAlignment = Alignment.BottomCenter
				) {

					Snackbar(
						modifier = Modifier.padding(SequenceTheme.padding.small),
						action = {
							TextButton(
								onClick = { onReloadFilms() },
								colors = colors
							) {
								Text(text = stringResource(R.string.repeat))
							}
						}
					) {
						Text(text = stringResource(R.string.error))
					}
				}
			}

			is FilmState.Content -> Content(
				films = state.films,
				genre = state.genre,
				onFilmClicked = { navigateToDetail(it) },
				onGenreClicked = { onGenres(it) }
			)
		}
	}
}