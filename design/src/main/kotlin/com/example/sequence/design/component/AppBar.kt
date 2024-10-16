package com.example.sequence.design.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.sequence.design.theme.SequenceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
	title: String? = null,
	leftIcon: ImageVector? = null,
	onLeftButtonClick: (() -> Unit)? = null,
) {
	TopAppBar(
		title = {
			Text(
				modifier = Modifier.fillMaxWidth(),
				text = title ?: "",
				textAlign = TextAlign.Center,
				style = SequenceTheme.typography.titleMedium,
				maxLines = 1,
				overflow = TextOverflow.Ellipsis,
			)
		},
		modifier = Modifier.fillMaxWidth(),
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = SequenceTheme.colors.primary,
			titleContentColor = SequenceTheme.colors.textInvert,
			navigationIconContentColor = SequenceTheme.colors.textInvert,
		),
		navigationIcon =
		{
			leftIcon?.let { icon ->
				IconButton(
					onClick = { onLeftButtonClick?.invoke() },
				) {
					Icon(
						imageVector = icon,
						contentDescription = null,
						modifier = Modifier.size(24.dp)
					)
				}
			}
		},
	)
}
