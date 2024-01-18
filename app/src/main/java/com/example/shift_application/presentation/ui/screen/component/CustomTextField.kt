package com.example.shift_application.presentation.ui.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shift_application.common.Constants
import com.example.shift_application.presentation.ui.theme.UbuntuRegular

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    textFieldValue: String = Constants.EMPTY_STRING,
    singleLine: Boolean = true,
    error: String? = null,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    val outlinedColor = if (error != null) Color.Red else Color.Gray
    val containerColor = if (error != null) Color.Red.copy(alpha = 0.1f) else Color.White
    BasicTextField(
        modifier = Modifier
            .background(
                color = containerColor,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = outlinedColor,
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxWidth(),
        value = textFieldValue,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontFamily = UbuntuRegular,
            color = Color.Black
        ),
        keyboardOptions = keyboardOptions,
        singleLine = singleLine,
        enabled = true,
        cursorBrush = SolidColor(Color.Black),
        decorationBox = @Composable { innerTextField ->
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                innerTextField()
            }
        }
    )
}