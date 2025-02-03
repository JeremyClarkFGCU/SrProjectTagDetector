package com.example.leofindit.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun RoundedListItem(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    icon: ImageVector,
    color: Color,
    leadingText: String,
    trailingText: String = "",
    trailingIcon: ImageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
    customTrailingContent : @Composable (() -> Unit)? = null,
    iconModifier: Modifier = Modifier,
) {
    ListItem(
        leadingContent = {
            Box(
                modifier = modifier
                    .size(24.dp) // Circle size
                    .background(
                        color = color,
                        shape = CircleShape // Circle shape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.background,
                )
            }
        },
        headlineContent = { Text(leadingText) },
        trailingContent = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (customTrailingContent != null) {
                    customTrailingContent()
                } else {
                    Text(
                        text = trailingText,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = iconModifier
                    )
                }
            }
        },
        modifier = if (onClick != null) Modifier.clickable { onClick() } else Modifier
    )
}