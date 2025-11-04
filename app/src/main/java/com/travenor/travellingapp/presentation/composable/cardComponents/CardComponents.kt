package com.travenor.travellingapp.presentation.composable.cardComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.travenor.travellingapp.R
import com.travenor.travellingapp.data.models.Place
import com.travenor.travellingapp.presentation.screens.homeScreen.HomeScreenViewModel
import com.travenor.travellingapp.presentation.theme.MainWhite
import com.travenor.travellingapp.presentation.theme.Star
import com.travenor.travellingapp.presentation.theme.SubTextColor

@Composable
fun PlaceListItem(
    place: Place, onClick: () -> Unit, viewModel: CardComponentsViewModel = hiltViewModel(),
) {
    val favourite by viewModel.favourite.collectAsState()

    Column(
        modifier = Modifier
            .height(380.dp)
            .width(270.dp)
            .background(MainWhite, RoundedCornerShape(24.dp))
            .border(1.dp, SubTextColor, RoundedCornerShape(24.dp))
            .clip(RoundedCornerShape(24.dp))
            .padding(14.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
        ) {
//            Image(
//                ,
//                contentDescription = null,
//                contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth()
//            )
            IconButton(
                onClick = { viewModel.onFavouriteChange(!favourite) },
                modifier = Modifier.size(34.dp).align(Alignment.TopEnd).padding(14.dp)
            ) {
                Icon(
                    painterResource(R.drawable.btn_favourite),
                    contentDescription = null,
                    tint = if (favourite) Star else Color.Unspecified
                )
            }
        }
    }
}