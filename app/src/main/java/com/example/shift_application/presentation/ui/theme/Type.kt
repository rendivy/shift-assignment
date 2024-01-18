package com.example.shift_application.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val LargeTitle = TextStyle(
    fontFamily = PopinsBold,
    fontSize = 26.sp,
    lineHeight = 39.sp,
)

val TitleSmall = TextStyle(
    fontFamily = UbuntuRegular,
    fontSize = 15.sp,
    lineHeight = 24.sp,
)


val TitleRegular = TextStyle(
    fontFamily = UbuntuRegular,
    fontSize = 18.sp,
    lineHeight = 24.sp,
)