package com.example.sequence.design.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.sequence.design.R

@Immutable
data class SequenceTypography(
	val titleMedium: TextStyle,
	val titleLarge: TextStyle,
	val paragraph: TextStyle,
	val regular: TextStyle,
)

val LocalSequenceTypography = staticCompositionLocalOf {
	SequenceTypography(
		titleMedium = TextStyle.Default,
		titleLarge = TextStyle.Default,
		paragraph = TextStyle.Default,
		regular = TextStyle.Default,
	)
}

val interFontFamily = FontFamily(
	Font(R.font.inter_medium, FontWeight(400), FontStyle.Normal),
	Font(R.font.inter_semibold, FontWeight(500), FontStyle.Normal),
	Font(R.font.inter_bold, FontWeight(600), FontStyle.Normal),
	Font(R.font.inter_extrabold, FontWeight(700), FontStyle.Normal),
)

val robotoFontFamily = FontFamily(
	Font(R.font.roboto_medium, FontWeight(400), FontStyle.Normal),
	Font(R.font.roboto_bold, FontWeight(500), FontStyle.Normal),
)

val sequenceTypography = SequenceTypography(
	titleMedium = TextStyle(
		fontSize = 20.sp,
		lineHeight = 24.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(600),
		fontFamily = interFontFamily,
	),
	titleLarge = TextStyle(
		fontSize = 24.sp,
		lineHeight = 30.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(700),
		fontFamily = interFontFamily,
	),
	paragraph = TextStyle(
		fontSize = 14.sp,
		lineHeight = 20.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(400),
		fontFamily = robotoFontFamily,
	),
	regular = TextStyle(
		fontSize = 14.sp,
		lineHeight = 20.sp,
		fontStyle = FontStyle.Normal,
		fontWeight = FontWeight(400),
		fontFamily = interFontFamily,
	),
)