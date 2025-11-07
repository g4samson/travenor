package com.travenor.travellingapp.presentation.screens.placeDetailsScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SheetValue.Expanded
import androidx.compose.material3.SheetValue.PartiallyExpanded
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.travenor.travellingapp.R
import com.travenor.travellingapp.presentation.composable.DefaultButton
import com.travenor.travellingapp.presentation.composable.topAppBarComponent.TopAppBarComponent
import com.travenor.travellingapp.presentation.theme.Primary
import com.travenor.travellingapp.presentation.theme.TextColor
import com.travenor.travellingapp.presentation.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceDetailsScreen(
    navController: NavHostController = rememberNavController(),
    placeId: String,
    viewModel: PlaceDetailsViewModel = hiltViewModel<PlaceDetailsViewModel>()
) {
//    val scope = rememberCoroutineScope()
//    var showBottomSheet by remember { mutableStateOf(true) }
    val place by viewModel.place.collectAsState()
    val sheetState =
        rememberStandardBottomSheetState(skipHiddenState = false, initialValue = Expanded)
    val scaffoldState = rememberBottomSheetScaffoldState(sheetState)

    LaunchedEffect(placeId) {
        viewModel.loadPlaceById(placeId)
    }

    val context = LocalContext.current
    val imageRes = remember(place?.image) {
        place?.image?.let {
            context.resources.getIdentifier(it, "drawable", context.packageName)
        } ?: 0
    }

    LaunchedEffect(sheetState.currentValue) {
        if (sheetState.currentValue == PartiallyExpanded) {
            navController.navigateUp()
        }
        Log.i("UI", "${sheetState.currentValue}")
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
        sheetContainerColor = Color.White,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                if (place != null) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                place!!.name,
                                style = Typography.titleMedium.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 24.sp,
                                    lineHeight = 32.sp,
                                    letterSpacing = 0.5.sp
                                )
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(
                                place!!.address,
                                style = Typography.bodyMedium.copy(
                                    fontSize = 15.sp,
                                    letterSpacing = 0.3.sp
                                )
                            )
                        }

                        Image(
                            painterResource(R.drawable.user_av_3),
                            contentDescription = null, modifier = Modifier.size(48.dp)
                        )
                    }

                    Spacer(Modifier.height(24.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painterResource(R.drawable.icon_location),
                                contentDescription = null,
                                tint = Color.Unspecified, modifier = Modifier.size(16.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                place!!.address, style = Typography.bodyMedium.copy(
                                    fontSize = 15.sp,
                                    letterSpacing = 0.3.sp
                                )
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painterResource(R.drawable.icon_star),
                                contentDescription = null,
                                tint = Color.Unspecified, modifier = Modifier.size(16.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                place!!.rate.toString(), style = Typography.bodyMedium.copy(
                                    fontSize = 15.sp,
                                    letterSpacing = 0.3.sp, color = TextColor
                                )
                            )
                            Text(
                                " (${place!!.feedbackNumber.toString()})",
                                style = Typography.bodyMedium.copy(
                                    fontSize = 15.sp,
                                    letterSpacing = 0.3.sp
                                )
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                "$${place!!.price.toInt().toString()}/",
                                style = Typography.bodyMedium.copy(
                                    fontSize = 15.sp,
                                    letterSpacing = 0.3.sp, color = Primary
                                )
                            )
                            Text(
                                "Person", style = Typography.bodyMedium.copy(
                                    fontSize = 15.sp,
                                    letterSpacing = 0.3.sp
                                )
                            )
                        }
                    }
                    Spacer(Modifier.height(24.dp))


                    Spacer(Modifier.height(24.dp))

                    Text(
                        "About Description",
                        style = Typography.titleMedium.copy(
                            fontSize = 20.sp,
                            lineHeight = 28.sp
                        )
                    )
                    Spacer(Modifier.height(8.dp))

                    Text(
                        place!!.description, style = Typography.bodyMedium.copy(
                            fontSize = 13.sp,
                            lineHeight = 22.sp, textAlign = TextAlign.Start
                        ), modifier = Modifier.padding(end = 17.dp)
                    )
                    Spacer(Modifier.height(16.dp))

                    DefaultButton("Book Now") { }

                    Spacer(Modifier.height(150.dp))

                } else {
                    Text("Loading...", style = Typography.bodyMedium)
                }
            }
        },
    ) { innerPadding ->
        if (imageRes != 0) {
            Image(
                painterResource(imageRes), modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth, contentDescription = null
            )
        }
        TopAppBarComponent("Details") {
            navController.navigateUp()
        }
    }
}