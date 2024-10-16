package com.example.sequence.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val lightPrimary = Color(0xFF0E3165)
val lightBackground= Color(0xFFFFFFFF)
val lightSecondary = Color(0xFF4B4B4B)
val lightContainer = Color(0xFFFFC967)
val lightTextPrimary = Color(0xFF000000)
val lightTextInvert = Color(0xFFFFFFFF)

val darkPrimary = Color(0xFF0E3165)
val darkBackground= Color(0xFFFFFFFF)
val darkSecondary = Color(0xFF4B4B4B)
val darkContainer = Color(0xFFFFC967)
val darkTextPrimary = Color(0xFF141C24)
val darkTextInvert = Color(0xFFFFFFFF)

@Immutable
data class SequenceColors(
	val primary: Color,
	val background: Color,
	val secondary: Color,
	val container: Color,
	val textPrimary: Color,
	val textInvert: Color,
)

val LocalSequenceColors = staticCompositionLocalOf {
	SequenceColors(
		primary = Color.Unspecified,
		background = Color.Unspecified,
		secondary = Color.Unspecified,
		container = Color.Unspecified,
		textPrimary = Color.Unspecified,
		textInvert = Color.Unspecified,
	)
}

val LightColors = SequenceColors(
	primary = lightPrimary,
	background = lightBackground,
	secondary = lightSecondary,
	container = lightContainer,
	textPrimary = lightTextPrimary,
	textInvert = lightTextInvert,
)

val DarkColors = SequenceColors(
	primary = darkPrimary,
	background = darkBackground,
	secondary = darkSecondary,
	container = darkContainer,
	textPrimary = darkTextPrimary,
	textInvert = darkTextInvert,
)
