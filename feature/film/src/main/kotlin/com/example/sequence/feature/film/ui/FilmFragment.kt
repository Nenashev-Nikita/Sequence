package com.example.sequence.feature.film.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.sequence.design.component.Screen
import com.example.sequence.feature.film.presentation.FilmViewModel
import com.example.sequence.feature.film.ui.compose.FilmScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

fun getFilmScreen() = FragmentScreen { FilmFragment.newInstance() }

class FilmFragment : Fragment() {

	internal companion object {

		fun newInstance() = FilmFragment()
	}

	private val viewModel: FilmViewModel by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {
			setContent {
				viewModel.loadFilms()

				Screen {
					FilmScreen(
						filmsLiveData = viewModel.films,
						genreLiveData = viewModel.genre,
						isLoadingLiveData = viewModel.isLoading,
						isErrorLiveData = viewModel.error,
						onReloadFilms = viewModel::loadFilms,
						onGenres = viewModel::filterFilmsByGenres,
						navigateToDetail = viewModel::openFilmDetails,
					)
				}
			}
		}
}
