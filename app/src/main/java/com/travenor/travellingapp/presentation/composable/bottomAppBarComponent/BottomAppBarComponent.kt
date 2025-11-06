package com.travenor.travellingapp.presentation.composable.bottomAppBarComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.travenor.travellingapp.R
import com.travenor.travellingapp.data.utils.Constants
import com.travenor.travellingapp.presentation.composable.cardComponents.CardComponentsViewModel
import com.travenor.travellingapp.presentation.theme.MainWhite
import com.travenor.travellingapp.presentation.theme.Primary
import com.travenor.travellingapp.presentation.theme.SubTextColor
import com.travenor.travellingapp.presentation.theme.Typography

@Composable
fun BottomAppBarComponent(
    navController: NavHostController = rememberNavController(),
    viewModel: BottomAppBarViewModel = hiltViewModel()
) {
    val selectedIndex by viewModel.selectedIndex.collectAsState()


    BottomAppBar(
        modifier = Modifier
            .background(MainWhite)
            .border(1.dp, SubTextColor)
            .height(100.dp)
            .fillMaxWidth(), containerColor = MainWhite
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Constants.navs.forEachIndexed { index, btn ->
                val isSelected = index == selectedIndex

                if (btn.title.isEmpty()) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {
                                navController.navigate(btn.route)
                                viewModel.select(index)
                            },
                            modifier = Modifier
                                .size(50.dp)
                                .clip(RoundedCornerShape(100.dp))
                                .background(Primary, RoundedCornerShape(100.dp))
                        ) {
                            Icon(
                                painterResource(btn.icon),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                tint = Color.Unspecified
                            )
                        }
                    }
                } else {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {
                                navController.navigate(btn.route)
                                viewModel.select(index)
                            },
                            modifier = Modifier,
                        ) {
                            Icon(
                                painterResource(btn.icon),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp),
                                tint = if (isSelected) Primary else SubTextColor
                            )
                        }
                        Text(
                            btn.title,
                            style = Typography.bodyMedium.copy(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                lineHeight = 16.sp,
                                color = if (isSelected) Primary else SubTextColor
                            )
                        )
                    }
                }
            }
        }
    }

}
