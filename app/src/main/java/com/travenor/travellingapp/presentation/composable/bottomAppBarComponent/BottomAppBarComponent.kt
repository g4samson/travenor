package com.travenor.travellingapp.presentation.composable.bottomAppBarComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.travenor.travellingapp.presentation.theme.MainWhite
import com.travenor.travellingapp.presentation.theme.SubTextColor

@Composable
fun BottomAppBarComponent(modifier: Modifier = Modifier) {


    BottomAppBar(modifier = Modifier
        .background(MainWhite)
        .border(1.dp, SubTextColor, RoundedCornerShape(24.dp))
        .height(100.dp).fillMaxWidth(), containerColor = MainWhite
    ) {

    }

}