package com.example.sequence.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class SequencePadding(
	val extraSmall: Dp,
	val small: Dp,
	val medium: Dp,
	val large: Dp,
)

val LocalSequencePadding = staticCompositionLocalOf {
	SequencePadding(
		extraSmall = Dp.Unspecified,
		small = Dp.Unspecified,
		medium = Dp.Unspecified,
		large = Dp.Unspecified,
	)
}

val sequencePadding = SequencePadding(
	extraSmall = 4.dp,
	small = 8.dp,
	medium = 16.dp,
	large = 24.dp,
)