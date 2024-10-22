package com.example.sequence.feature.film.presentation

import androidx.annotation.StringRes
import com.example.sequence.feature.film.R

enum class Genres(@StringRes val title: Int) {
	BIOGRAPHY(
		title = R.string.biography,
	),
	ACTION_MOVIE(
		title = R.string.action_movie,
	),
	DETECTIVE(
		title = R.string.detective,
	),
	DRAMA(
		title = R.string.drama,
	),
	COMEDY(
		title = R.string.comedy,
	),
	CRIME(
		title = R.string.crime,
	),
	MELODRAMA(
		title = R.string.melodrama,
	),
	MUSICAL(
		title = R.string.musical,
	),
	ADVENTURES(
		title = R.string.adventures,
	),
	THRILLER(
		title = R.string.thriller,
	),
	HORRORS(
		title = R.string.horrors,
	),
	FANTASY(
		title = R.string.fantasy,
	),
}