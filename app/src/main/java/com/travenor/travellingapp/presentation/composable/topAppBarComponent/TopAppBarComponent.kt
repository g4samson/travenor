package com.travenor.travellingapp.presentation.composable.topAppBarComponent

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.travenor.travellingapp.R
import com.travenor.travellingapp.presentation.theme.MainWhite
import com.travenor.travellingapp.presentation.theme.Star
import com.travenor.travellingapp.presentation.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(title: String, viewModel: TopAppBarViewModel = hiltViewModel(), onClick: () -> Unit) {
    val favourite by viewModel.favourite.collectAsState()


    TopAppBar(
        title = {},
        modifier = Modifier.fillMaxWidth(),
        navigationIcon = {
            if (title.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 50.dp, bottom = 50.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onClick, modifier = Modifier.size(44.dp)) {
                        Icon(
                            painterResource(R.drawable.btn_back_transparent),
                            contentDescription = null,
                            tint = Color.Unspecified, modifier = Modifier.fillMaxSize()
                        )
                    }

                    Text(
                        title,
                        style = Typography.titleMedium.copy(
                            fontSize = 18.sp,
                            lineHeight = 22.sp,
                            color = MainWhite
                        )
                    )

                    IconButton(onClick = { viewModel.onFavouriteChange(!favourite) }, modifier = Modifier.size(44.dp)) {
                        Icon(
                            painterResource(R.drawable.btn_favourite_medium),
                            contentDescription = null,
                            tint = if (!favourite) Color.Unspecified else Star, modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 50.dp, bottom = 50.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    IconButton(onClick = onClick, modifier = Modifier.size(44.dp)) {
                        Icon(
                            painterResource(R.drawable.btn_back),
                            contentDescription = null,
                            tint = Color.Unspecified
                        )
                    }
                }
            }
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
    )
}