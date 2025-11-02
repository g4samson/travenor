package com.travenor.travellingapp.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.travenor.travellingapp.R

@Composable
fun SocialNetworkComponent(
    facebookOnClick: () -> Unit,
    instagramOnClick: () -> Unit,
    twitterOnClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            IconButton(onClick = facebookOnClick, modifier = Modifier.size(44.dp)) {
                Icon(
                    painterResource(R.drawable.facebook),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }

            IconButton(onClick = instagramOnClick, modifier = Modifier.size(44.dp)) {
                Icon(
                    painterResource(R.drawable.instagram),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }

            IconButton(onClick = twitterOnClick, modifier = Modifier.size(44.dp)) {
                Icon(
                    painterResource(R.drawable.twitter),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }
    }
}

@Preview
@Composable
private fun SNCPrev() {
    SocialNetworkComponent({}, {}, {})
}