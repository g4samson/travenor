package com.travenor.travellingapp.presentation.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.travenor.travellingapp.R
import com.travenor.travellingapp.data.utils.Destinations
import com.travenor.travellingapp.presentation.composable.cardComponents.PlaceListItem
import com.travenor.travellingapp.presentation.theme.Action
import com.travenor.travellingapp.presentation.theme.Gray
import com.travenor.travellingapp.presentation.theme.MainWhite
import com.travenor.travellingapp.presentation.theme.SecTextColor
import com.travenor.travellingapp.presentation.theme.TextColor
import com.travenor.travellingapp.presentation.theme.Typography

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    val isLoading by viewModel.isLoading.collectAsState(initial = false)
    val placeList = viewModel.placeList.collectAsState(initial = listOf()).value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainWhite)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(80.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .width(120.dp)
                    .height(44.dp)
                    .background(
                        Gray,
                        RoundedCornerShape(22.dp)
                    )
                    .clip(RoundedCornerShape(22.dp)), verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(Modifier.width(4.dp))

                Image(
                    painter = painterResource(R.drawable.user_av_4),
                    contentDescription = null,
                    modifier = Modifier.size(37.dp)
                )

                Spacer(Modifier.width(6.dp))

                Text(
                    "Leonardo",
                    style = Typography.titleMedium.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 16.sp
                    )
                )

                Spacer(Modifier.width(4.dp))
            }

            IconButton(onClick = { }, modifier = Modifier.size(44.dp)) {
                Icon(
                    painterResource(R.drawable.btn_notification),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(), tint = Color.Unspecified
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Text(
                "Explore the ",
                style = Typography.titleMedium.copy(
                    fontSize = 38.sp, textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 50.sp, color = SecTextColor
                ), modifier = Modifier.fillMaxWidth()
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Beautiful",
                    style = Typography.titleMedium.copy(
                        fontSize = 38.sp,
                        fontWeight = FontWeight.Black,
                        lineHeight = 50.sp
                    )
                )
                Column {
                    Text(
                        " world!",
                        style = Typography.titleMedium.copy(
                            fontSize = 38.sp,
                            fontWeight = FontWeight.Black,
                            lineHeight = 50.sp, color = Action
                        )
                    )

                }
            }
        }

        Spacer(Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Best Destination",
                style = Typography.titleMedium.copy(
                    fontSize = 20.sp,
                    lineHeight = 28.sp,
                    textAlign = TextAlign.Start
                )
            )
            Text(
                "View all",
                style = Typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    lineHeight = 16.sp, textAlign = TextAlign.End,
                    color = Action
                ), modifier = Modifier.clickable { }
            )
        }
        Spacer(Modifier.height(20.dp))

        if (!placeList.isNullOrEmpty()) {
            LazyHorizontalGrid(
                rows = GridCells.Fixed(1),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp)
                    .padding(start = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(placeList) { place ->
                    PlaceListItem(place) {
                        navController.navigate(Destinations.PlaceDetails(place.id))
                    }
                }

                item { Spacer(Modifier.width(10.dp)) }
            }
        } else {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(50.dp)
                    .padding(top = 200.dp),
                color = TextColor,
                strokeWidth = 3.dp
            )
        }
    }
}