package com.travenor.travellingapp.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.travenor.travellingapp.presentation.theme.MainWhite
import com.travenor.travellingapp.presentation.theme.SFUI

@Composable
fun H1Text(text: String, fontSize: TextUnit, color: Color, lineHeight: TextUnit, modifier: Modifier) {
    Text(
        text = text,
        fontSize = fontSize,
        color = color,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier,
        maxLines = 1,
        fontFamily = SFUI, lineHeight = lineHeight
    )
}

@Composable
fun H2Text(text: String, fontSize: TextUnit, color: Color, lineHeight: TextUnit, modifier: Modifier) {
    Text(
        text = text,
        fontSize = fontSize,
        color = color,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Normal,
        modifier = modifier,
        maxLines = 1,
        fontFamily = SFUI, lineHeight = lineHeight
    )
}

@Preview
@Composable
private fun TextsPreview() {
    Column {
        H1Text("Example text", 26.sp, MainWhite, 34.sp, Modifier)
        H2Text("Example text", 16.sp, MainWhite, 20.sp, Modifier)
    }
}