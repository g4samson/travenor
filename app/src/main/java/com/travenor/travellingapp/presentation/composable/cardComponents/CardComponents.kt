package com.travenor.travellingapp.presentation.composable.cardComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.travenor.travellingapp.R
import com.travenor.travellingapp.data.models.Place
import com.travenor.travellingapp.presentation.theme.FrameShape
import com.travenor.travellingapp.presentation.theme.MainWhite
import com.travenor.travellingapp.presentation.theme.Star
import com.travenor.travellingapp.presentation.theme.SubTextColor
import com.travenor.travellingapp.presentation.theme.Typography

@Composable
fun PlaceListItem(
    place: Place, viewModel: CardComponentsViewModel = hiltViewModel(), onClick: () -> Unit
) {
    val favourite by viewModel.favourite.collectAsState()
    val imageUrl by viewModel.imageUrl.collectAsState()

    LaunchedEffect(place.image) {
        viewModel.loadImage(place.image)
    }

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
//            if (imageUrl != null) {
//                AsyncImage(
//                    model = imageUrl,
//                    contentDescription = place.name,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clip(RoundedCornerShape(20.dp)),
//                    contentScale = ContentScale.Crop
//                )
//            } else {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.LightGray, RoundedCornerShape(20.dp)),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text("Loading...", color = SubTextColor)
//                }
//            }

            Image(
                painterResource(R.drawable.nilardi),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            IconButton(
                onClick = { viewModel.onFavouriteChange(!favourite) },
                modifier = Modifier
                    .padding(end = 14.dp, top = 14.dp)
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    painterResource(R.drawable.btn_favourite),
                    contentDescription = null,
                    tint = if (favourite) Star else Color.Unspecified,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Spacer(Modifier.height(14.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                place.name,
                style = Typography.titleMedium.copy(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.5.sp
                )
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(3.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.icon_star),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Text(
                    place.rate.toString(),
                    style = Typography.titleMedium.copy(
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Normal,
                        letterSpacing = 0.3.sp
                    )
                )
            }
        }

        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(3.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painterResource(R.drawable.icon_location),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    place.address,
                    style = Typography.titleMedium.copy(
                        fontSize = 15.sp, color = SubTextColor,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Normal,
                        letterSpacing = 0.3.sp
                    )
                )
            }

            Box(
                modifier = Modifier
                    .height(24.dp)
                    .width(65.dp)
            ) {
                Image(
                    painterResource(R.drawable.user_av_all),
                    contentDescription = null,
                    modifier = Modifier
                        .width(51.dp)
                        .height(24.dp), contentScale = ContentScale.Crop
                )
                Row {
                    Spacer(Modifier.width(41.dp))
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(FrameShape, RoundedCornerShape(12.dp))
                            .clip(RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "+${place.feedbackNumber.toString()}",
                            style = Typography.titleMedium.copy(
                                fontSize = 11.sp,
                                lineHeight = 13.sp,
                                fontWeight = FontWeight.Normal,
                            )
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun P() {
    Box(
        modifier = Modifier
            .height(24.dp)
            .width(65.dp)
    ) {
        Image(
            painterResource(R.drawable.user_av_all),
            contentDescription = null,
            modifier = Modifier
                .width(51.dp)
                .height(24.dp), contentScale = ContentScale.Crop
        )
        Row {
            Spacer(Modifier.width(41.dp))
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(FrameShape, RoundedCornerShape(12.dp))
                    .clip(RoundedCornerShape(12.dp)), contentAlignment = Alignment.Center
            ) {
                Text(
                    "+50",
                    style = Typography.titleMedium.copy(
                        fontSize = 11.sp,
                        lineHeight = 13.sp,
                        fontWeight = FontWeight.Normal,
                    )
                )
            }
        }
    }
}