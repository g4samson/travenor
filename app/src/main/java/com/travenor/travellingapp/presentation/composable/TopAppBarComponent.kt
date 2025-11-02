package com.travenor.travellingapp.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.travenor.travellingapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(title: String, onClick: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Row(modifier = Modifier.fillMaxWidth().padding(start = 20.dp, top = 50.dp), horizontalArrangement = Arrangement.Start) {
            IconButton(onClick = onClick, modifier = Modifier.size(44.dp)) {
                Icon(
                    painterResource(R.drawable.back_btn),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
            }
        }
    }
}