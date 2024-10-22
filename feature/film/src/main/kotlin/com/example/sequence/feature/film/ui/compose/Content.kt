package com.example.sequence.feature.film.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.sequence.design.theme.SequenceTheme
import com.example.sequence.feature.film.R
import com.example.sequence.feature.film.presentation.Genres
import com.example.sequence.shared.movie.domain.entity.Film
import com.example.sequence.design.R as DesignR

private val COLOR_LACK_PICTURE = Color(0xFFEFEFEF)

@Composable
fun Content(
	films: List<Film>,
	genre: String?,
	onFilmClicked: (Film) -> Unit,
	onGenreClicked: (String) -> Unit
) {
	LazyColumn {
		item {
			Spacer(modifier = Modifier.height(SequenceTheme.padding.small))
		}

		item {
			Text(
				modifier = Modifier.padding(
					vertical = SequenceTheme.padding.small,
					horizontal = SequenceTheme.padding.medium,
				),
				text = stringResource(R.string.genres),
				color = SequenceTheme.colors.textPrimary,
				style = SequenceTheme.typography.paragraph.copy(fontSize = 20.sp, fontWeight = FontWeight(500)),
			)
		}

		items(Genres.entries) {
			Genre(
				genre = stringResource(it.title),
				checked = stringResource(it.title) == genre,
				onClicked = onGenreClicked,
			)
		}

		item {
			Spacer(modifier = Modifier.height(SequenceTheme.padding.medium))
		}

		item {
			Text(
				modifier = Modifier.padding(
					vertical = SequenceTheme.padding.small,
					horizontal = SequenceTheme.padding.medium,
				),
				text = stringResource(R.string.cinema_title),
				color = SequenceTheme.colors.textPrimary,
				style = SequenceTheme.typography.paragraph.copy(fontSize = 20.sp, fontWeight = FontWeight(500)),
			)
		}

		itemsGridFilms(
			listFilms = films.chunked(2),
			onFilmClicked = onFilmClicked,
		)
	}
}

@Composable
private fun Genre(
	genre: String,
	checked: Boolean,
	onClicked: (String) -> Unit
) {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		modifier = Modifier
			.fillMaxWidth()
			.background(
				if (checked) SequenceTheme.colors.container
				else SequenceTheme.colors.background
			)
			.clickable(
				interactionSource = remember { MutableInteractionSource() },
				indication = rememberRipple(color = SequenceTheme.colors.primary),
			) {
				onClicked(genre)
			}
	) {
		Text(
			text = (genre).first().uppercase() + (genre).substring(1),
			modifier = Modifier
				.padding(
					vertical = 10.dp,
					horizontal = SequenceTheme.padding.medium,
				),
			color = SequenceTheme.colors.textPrimary,
			style = SequenceTheme.typography.paragraph.copy(fontSize = 16.sp),
		)
	}
}

private fun LazyListScope.itemsGridFilms(
	listFilms: List<List<Film>>,
	onFilmClicked: (Film) -> Unit,
) {
	items(listFilms, key = { it.hashCode() }) { films ->
		Row(
			modifier = Modifier
				.fillMaxSize()
				.padding(
					vertical = SequenceTheme.padding.small,
					horizontal = SequenceTheme.padding.medium
				),
			horizontalArrangement = Arrangement.spacedBy(SequenceTheme.padding.small),
		) {
			val rowSize = films.size

			films.forEachIndexed { index, film ->
				FilmItem(film, onFilmClicked)

				if (index == rowSize - 1 && rowSize % 2 != 0) {
					Box(modifier = Modifier.weight(1f)) {}
				}
			}
		}
	}
}

@Composable
private fun RowScope.FilmItem(
	film: Film,
	onFilmClicked: (Film) -> Unit
) {
	Box(
		modifier = Modifier
			.weight(1f)
			.clickable { onFilmClicked(film) },
		contentAlignment = Alignment.Center
	) {
		Poster(
			name = film.name,
			img = film.img,
		)
	}
}

@Composable
private fun Poster(
	name: String,
	img: String?,
) {
	Column(horizontalAlignment = Alignment.Start) {
		ImageFilm(img)

		Spacer(modifier = Modifier.height(SequenceTheme.padding.small))

		Text(
			text = name,
			color = SequenceTheme.colors.textPrimary,
			style = SequenceTheme.typography.paragraph.copy(fontWeight = FontWeight(500)),
			overflow = TextOverflow.Ellipsis,
			maxLines = 2,
		)

		Spacer(modifier = Modifier.height(20.dp))
	}
}

@Composable
private fun ImageFilm(
	img: String?,
) {
	if (img != null) {
		Image(
			painter = rememberAsyncImagePainter(img),
			contentDescription = null,
			modifier = Modifier
				.aspectRatio(0.8F)
				.clip(RoundedCornerShape(SequenceTheme.shapes.small)),
			contentScale = ContentScale.FillBounds,
		)
	} else {
		Box(
			modifier = Modifier
				.clip(RoundedCornerShape(SequenceTheme.shapes.medium))
				.aspectRatio(0.8F)
				.background(COLOR_LACK_PICTURE),
			contentAlignment = Alignment.Center
		) {
			Image(
				painter = painterResource(id = DesignR.drawable.perm_media),
				contentDescription = null,
				modifier = Modifier.size(48.dp),
				contentScale = ContentScale.FillBounds,
			)
		}
	}
}