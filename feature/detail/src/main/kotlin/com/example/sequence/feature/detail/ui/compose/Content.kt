package com.example.sequence.feature.detail.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.sequence.design.theme.SequenceTheme
import com.example.sequence.feature.detail.R
import com.example.sequence.shared.movie.domain.entity.Film
import java.util.Locale

@Composable
internal fun Content(
	film: Film,
) {
	Column(modifier = Modifier.padding(horizontal = SequenceTheme.padding.medium)) {
		Spacer(Modifier.height(SequenceTheme.padding.large))

		Poster(
			name = film.name,
			img = film.img,
		)

		Spacer(Modifier.height(SequenceTheme.padding.small))

		GenreAndDate(
			genres = film.genres,
			year = film.year,
		)

		Spacer(Modifier.height(10.dp))

		film.rating?.let {
			Text(
				text = stringResource(
					id = R.string.film_rating,
					String.format(Locale.US, "%.1f", it).toDouble()
				),
				color = SequenceTheme.colors.primary,
				style = SequenceTheme.typography.paragraph.copy(fontSize = 18.sp),
			)
		}

		Spacer(Modifier.height(14.dp))

		film.description?.let {
			Text(
				text = it,
				color = SequenceTheme.colors.textPrimary,
				style = SequenceTheme.typography.paragraph,
			)
		}
	}
}

@Composable
private fun Poster(
	name: String,
	img: String?,
) {
	Column {
		Image(
			painter = rememberAsyncImagePainter(img),
			contentDescription = null,
			modifier = Modifier
				.padding(horizontal = 114.dp)
				.aspectRatio(0.6F)
				.clip(RoundedCornerShape(SequenceTheme.shapes.small)),
			contentScale = ContentScale.FillBounds,
		)

		Spacer(modifier = Modifier.height(SequenceTheme.padding.large))

		Text(
			text = name,
			color = SequenceTheme.colors.textPrimary,
			style = SequenceTheme.typography.titleLarge,
		)
	}
}

@Composable
private fun GenreAndDate(
	genres: List<String>,
	year: Int
) {
	Text(
		text = "${genres.joinToString(separator = ", ")} ${stringResource(id = R.string.film_year, year)}",
		color = SequenceTheme.colors.secondary,
		style = SequenceTheme.typography.paragraph.copy(fontSize = 18.sp),
	)
}