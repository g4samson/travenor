package com.travenor.travellingapp.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.travenor.travellingapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

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