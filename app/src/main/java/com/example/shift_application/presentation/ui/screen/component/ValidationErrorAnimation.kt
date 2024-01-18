package com.example.shift_application.presentation.ui.screen.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shift_application.presentation.ui.theme.UbuntuRegular
import com.example.shift_application.presentation.ui.theme.shortPadding


@Composable
fun ValidationErrorAnimation(errorMessage: String) {
    AnimatedVisibility(visible = true, modifier = Modifier.padding(top = shortPadding)) {
        Text(
            text = errorMessage,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            color = Color.Red,
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = UbuntuRegular,
                color = Color.Red
            )
        )
    }
}