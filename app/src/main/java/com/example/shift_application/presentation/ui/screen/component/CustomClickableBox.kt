package com.example.shift_application.presentation.ui.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shift_application.presentation.ui.theme.UbuntuRegular
import com.example.shift_application.presentation.ui.theme.mediumPadding
import com.example.shift_application.presentation.ui.theme.shortPadding


@Composable
fun CustomClickableBox(
    checked: MutableState<Boolean>,
    birth: String,
    error: String? = null
) {
    val outlinedColor = if (error != null) Color.Red else Color.Gray
    val containerColor = if (error != null) Color.Red.copy(alpha = 0.1f) else Color.White
    Box(
        modifier = Modifier
            .clickable { checked.value = !checked.value }
            .background(
                color = containerColor,
                shape = RoundedCornerShape(shortPadding)
            )
            .border(
                width = 1.dp,
                color = outlinedColor,
                shape = RoundedCornerShape(shortPadding)
            )
            .heightIn(min = 42.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = birth,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .fillMaxWidth()
                .padding(start = mediumPadding),
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = UbuntuRegular,
                color = Color.Black
            )
        )
    }

}