package com.example.sequence.feature.detail.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.sequence.design.component.AppBar
import com.example.sequence.feature.detail.R
import com.example.sequence.shared.movie.domain.entity.Film

@Composable
internal fun DetailScreen(
	film: Film?,
	navigateToFilm: () -> Unit,
) {

	Column(
		modifier = Modifier
			.fillMaxSize()
			.verticalScroll(rememberScrollState())
	) {
		AppBar(
			title = film?.originalName ?: "Нет названия у фильма",
			leftIcon = ImageVector.vectorResource(id = R.drawable.ic_left),
			onLeftButtonClick = navigateToFilm,
		)

		film?.let {
			Content(
				film = it
			)
		} ?: Text("нет фильма")
	}
}