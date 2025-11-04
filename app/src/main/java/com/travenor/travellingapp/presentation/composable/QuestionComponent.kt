package com.travenor.travellingapp.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.travenor.travellingapp.presentation.theme.Action
import com.travenor.travellingapp.presentation.theme.SFUI
import com.travenor.travellingapp.presentation.theme.SubTextColor
import com.travenor.travellingapp.presentation.theme.Typography

@Composable
fun QuestionComponent(text1: String, text2: String, paddingBottom: Dp, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = paddingBottom),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                "$text1 ",
                style = Typography.bodyMedium.copy(fontSize = 14.sp, lineHeight = 16.sp)
            )
            Text(
                text2,
                style = Typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    color = Action,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.clickable(onClick = onClick)
            )
        }
        Spacer(Modifier.height(20.dp))
        Text(
            "Or connect",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp,
            fontFamily = SFUI,
            color = SubTextColor
        )
    }
}