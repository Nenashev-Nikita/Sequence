package com.example.sequence.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.example.sequence.design.theme.DarkColors
import com.example.sequence.design.theme.LightColors
import com.example.sequence.design.theme.LocalSequenceColors
import com.example.sequence.design.theme.LocalSequenceElevation
import com.example.sequence.design.theme.LocalSequencePadding
import com.example.sequence.design.theme.LocalSequenceTypography
import com.example.sequence.design.theme.SequenceColors
import com.example.sequence.design.theme.SequenceElevation
import com.example.sequence.design.theme.SequencePadding
import com.example.sequence.design.theme.SequenceTypography

object SequenceTheme {
	val colors: SequenceColors
		@Composable
		get() = LocalSequenceColors.current
	val typography: SequenceTypography
		@Composable
		get() = LocalSequenceTypography.current
	val elevation: SequenceElevation
		@Composable
		get() = LocalSequenceElevation.current
	val shapes: SequenceShapes
		@Composable
		get() = LocalSequenceShapes.current
	val padding: SequencePadding
		@Composable
		get() = LocalSequencePadding.current
}

@Composable
fun SequenceTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	content: @Composable () -> Unit
) {
	val colorScheme = if (darkTheme) DarkColors else LightColors

	CompositionLocalProvider(
		LocalSequenceColors provides colorScheme,
		LocalSequenceTypography provides sequenceTypography,
		LocalSequenceElevation provides sequenceElevation,
		LocalSequenceShapes provides sequenceShapes,
		LocalSequencePadding provides sequencePadding,
		content = content
	)
}