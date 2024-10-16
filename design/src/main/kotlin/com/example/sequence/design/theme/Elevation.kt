package com.example.sequence.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class SequenceElevation(
	val default: Dp,
	val pressed: Dp
)

val LocalSequenceElevation = staticCompositionLocalOf {
	SequenceElevation(
		default = Dp.Unspecified,
		pressed = Dp.Unspecified
	)
}

val sequenceElevation = SequenceElevation(
	default = 4.dp,
	pressed = 8.dp
)