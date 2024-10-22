package com.example.sequence.feature.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.core.bundle.bundleOf
import androidx.fragment.app.Fragment
import com.example.sequence.design.component.Screen
import com.example.sequence.feature.detail.presentation.DetailViewModel
import com.example.sequence.feature.detail.ui.compose.DetailScreen
import com.example.sequence.shared.movie.domain.entity.Film
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

fun getDetailScreen(film: Film) = FragmentScreen {
	DetailFragment.newInstance(film)
}

class DetailFragment : Fragment() {

	internal companion object {

		private const val ID_FILM = "ID_FILM"

		internal fun newInstance(film: Film): DetailFragment = DetailFragment().apply {
			arguments = bundleOf(
				ID_FILM to film,
			)
		}
	}

	private val viewModel: DetailViewModel by viewModel()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(requireContext()).apply {

			setContent {
				Screen {
					DetailScreen(
						film = arguments?.get(ID_FILM) as Film,
						navigateToFilm = viewModel::navigationBack,
					)
				}
			}
		}
}