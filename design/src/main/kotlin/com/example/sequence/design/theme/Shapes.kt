package com.example.sequence.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
class SequenceShapes(
	val small: Dp,
	val medium: Dp,
)

val LocalSequenceShapes = staticCompositionLocalOf {
	SequenceShapes(
		small = Dp.Unspecified,
		medium = Dp.Unspecified,
	)
}

val sequenceShapes = SequenceShapes(
	small = 4.dp,
	medium = 8.dp,
)