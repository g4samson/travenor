package com.travenor.travellingapp.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.travenor.travellingapp.R

// Set of Material typography styles to start with
val Geometr = FontFamily(
    Font(R.font.geometr415_blk_bt_black, FontWeight.Black),
)

val GillSansMT = FontFamily(
    Font(R.font.gillsansmt, FontWeight.Normal),
)

val SFUI = FontFamily(
    Font(R.font.sf_ui_display_regular, FontWeight.Normal),
    Font(R.font.sf_ui_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_ui_display_medium, FontWeight.Medium),
)

val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = SFUI,
        fontWeight = FontWeight.SemiBold,
        fontSize = 26.sp,
        lineHeight = 34.sp,
        letterSpacing = 0.sp,
        textAlign = TextAlign.Center,
        color = TextColor
    ),

    bodyMedium = TextStyle(
        fontFamily = SFUI,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp,
        textAlign = TextAlign.Center,
        color = SubTextColor
    ),

    titleLarge = TextStyle(
        fontFamily = Geometr,
        fontWeight = FontWeight.Black,
        fontSize = 30.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
        textAlign = TextAlign.Center,
        color = SubTextColor
    ),

)