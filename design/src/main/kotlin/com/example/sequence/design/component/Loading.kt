package com.example.sequence.design.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.sequence.design.theme.SequenceTheme

@Composable
fun Loading(modifier: Modifier = Modifier) {
	Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
		CircularProgressIndicator(
			color = SequenceTheme.colors.container,
		)
	}
}