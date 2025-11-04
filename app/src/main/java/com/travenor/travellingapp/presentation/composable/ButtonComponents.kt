package com.travenor.travellingapp.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.travenor.travellingapp.presentation.theme.MainWhite
import com.travenor.travellingapp.presentation.theme.Primary
import com.travenor.travellingapp.presentation.theme.SFUI
import com.travenor.travellingapp.presentation.theme.Typography

/**
 * A base button component that is most commonly used throughout the application.
 *
 * Displays a centered text with rounded corners and the [Primary] background color.
 *
 * @param text the text displayed inside the button.
 * @param onClick a function that will be called when the button is clicked.
 *
 * @sample DefaultButtonPreview
 */
@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Primary, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp)),
        colors = ButtonDefaults.buttonColors(Primary)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text, style = Typography.bodyMedium.copy(color = MainWhite, fontWeight = FontWeight.SemiBold))
        }
    }
}


@Preview
@Composable
fun DefaultButtonPreview() {
    DefaultButton("Example Text") { /* Do something! */ }
}