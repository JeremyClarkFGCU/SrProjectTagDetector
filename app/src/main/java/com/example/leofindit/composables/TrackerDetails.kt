package com.example.leofindit.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.leofindit.R
import com.example.leofindit.ui.theme.LeoFindItTheme


@Composable
fun TrackerDetails() {
    var ignoreTracker by remember { mutableStateOf(false) }
    var tracker = "Tile"
    var bluetoothData = null
    var clock: Nothing? = null
    var notCurrentlyReachable: Boolean? = false

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Spacer(modifier = Modifier.size(56.dp))
        // Device name
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = tracker,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.weight(1f),
                maxLines = 1
            )
        }

        // Connection status and last seen time
        val connectionStatus = true
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (notCurrentlyReachable == true) {
                BasicText(
                    text = "No Connection",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            } else {
                if (connectionStatus == null) {
                    Text(
                        text = "connectionStatus.description",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            //Last seen
            Text(
                text = "Last seen: Just Now",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.fillMaxWidth()
            )
            //map TBA
            Card(modifier = Modifier
                .height(200.dp)
                .width(400.dp),
                onClick = {}
            ){}
            // options for tracker
            Card(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .shadow(elevation = 24.dp),
                border = BorderStroke(Dp.Hairline, Color.LightGray)
            ) {
                // list of options
                RoundedListItem(
                    onClick = {},
                    color = Color(0xff007aff),
                    icon = ImageVector.vectorResource(R.drawable.outline_explore_24),
                    leadingText = "Locate Tracker", trailingText = "Nearby"
                )

                HorizontalDivider(thickness = Dp.Hairline, color = Color.LightGray)

                RoundedListItem(
                    onClick = {},
                    color = colorResource(R.color.purple_200),
                    icon = ImageVector.vectorResource(R.drawable.outline_access_time_24),
                    leadingText = "Observe Tracker", trailingText = "Off"
                )

                HorizontalDivider(thickness = Dp.Hairline, color = Color.LightGray)

                RoundedListItem(
                    color = Color.Red,
                    icon = ImageVector.vectorResource(R.drawable.outline_not_interested_24),
                    leadingText = "Ignore Tracker",
                    customTrailingContent = {
                        Switch(
                            checked = ignoreTracker,
                            onCheckedChange = { isChecked -> ignoreTracker = isChecked },
                        )
                    }
                )
            }
            //
            Text(
                text = "Ignoring trackers will stop notifications in the background",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )

            Card(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .shadow(elevation = 16.dp),
                border = BorderStroke(Dp.Hairline, Color.LightGray)
            ) {
                RoundedListItem(
                    onClick = {},
                    icon = ImageVector.vectorResource(R.drawable.outline_info_24),
                    color = Color.Green,
                    leadingText = "Manufacture's Website",
                    trailingIcon = ImageVector.vectorResource(R.drawable.baseline_link_24),
                    iconModifier = Modifier.rotate(-45F)
                )
            }

            Text(
                text = " Learn more, e.g how to disable the tracker",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}

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

@Preview
@Composable
fun TrackerDetailsPreview() {
    LeoFindItTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            TrackerDetails()
        }
    }
}