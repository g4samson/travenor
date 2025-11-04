package com.travenor.travellingapp.presentation.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.travenor.travellingapp.presentation.composable.cardComponents.PlaceListItem
import com.travenor.travellingapp.presentation.theme.Action
import com.travenor.travellingapp.presentation.theme.MainWhite
import com.travenor.travellingapp.presentation.theme.SecTextColor
import com.travenor.travellingapp.presentation.theme.Typography

@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
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
        Spacer(Modifier.height(140.dp))

        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Text(
                "Explore the ",
                style = Typography.titleMedium.copy(
                    fontSize = 38.sp,
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
            modifier = Modifier.padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Best Destination",
                style = Typography.titleMedium.copy(fontSize = 20.sp, lineHeight = 28.sp)
            )
            Text(
                "View all",
                style = Typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
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
                    .padding(start = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(placeList) { place ->
                    PlaceListItem(place) {

                    }
                }
            }
        } else {
            Text("Product list is empty!", style = Typography.bodyMedium)
        }



    }
}