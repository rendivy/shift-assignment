package com.example.shift_application.presentation.ui.screen.component


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shift_application.R
import com.example.shift_application.common.Constants
import com.example.shift_application.presentation.ui.theme.UbuntuRegular
import com.example.shift_application.presentation.ui.theme.largePadding
import com.example.shift_application.presentation.ui.theme.shortPadding

@Composable
fun PasswordTextField(
    textFieldValue: String = Constants.EMPTY_STRING,
    onValueChange: (String) -> Unit,
    error: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    val outlinedColor = if (error != null) Color.Red else Color.Gray
    val containerColor = if (error != null) Color.Red.copy(alpha = 0.1f) else Color.White
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }
    val visibilityIconState = if (passwordVisibility) {
        ImageVector.vectorResource(id = R.drawable.hide)

    }
    else {
        ImageVector.vectorResource(id = R.drawable.show)
    }

    BasicTextField(
        modifier = Modifier
            .background(
                color = containerColor,
                shape = RoundedCornerShape(shortPadding)
            )
            .border(
                width = 1.dp,
                color = outlinedColor,
                shape = RoundedCornerShape(shortPadding)
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
        visualTransformation = if (!passwordVisibility) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        singleLine = true,
        enabled = true,
        cursorBrush = SolidColor(Color.Black),
        decorationBox = @Composable { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                innerTextField()
                Icon(
                    imageVector = visibilityIconState,
                    modifier = Modifier
                        .clickable(onClick = {
                            passwordVisibility = !passwordVisibility
                        })
                        .size(largePadding),
                    tint = Color.Black,
                    contentDescription = null,
                )
            }
        }


    )
}