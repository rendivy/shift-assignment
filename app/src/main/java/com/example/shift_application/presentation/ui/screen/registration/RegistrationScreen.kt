package com.example.shift_application.presentation.ui.screen.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shift_application.R
import com.example.shift_application.common.NavigationConstants
import com.example.shift_application.presentation.RegistrationViewModel
import com.example.shift_application.presentation.ui.theme.LargeTitle
import com.example.shift_application.presentation.ui.theme.TitleRegular


@Composable
fun RegistrationScreen(
    registrationViewModel: RegistrationViewModel = hiltViewModel(),
    navController: NavController
) {
    val registrationState by remember { registrationViewModel.registrationState }
    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(rememberScrollState())
            .padding(start = 20.dp, end = 20.dp)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = stringResource(id = R.string.registration_label),
            style = LargeTitle,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 38.dp)
        )
        RegistrationSection(
            registrationState = registrationState,
            registrationViewModel = registrationViewModel
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                registrationViewModel.registerUser()
                navController.popBackStack()
                navController.navigate(NavigationConstants.HOME_ROUTE)
            },
            enabled = registrationState.registrationIsAvailable,
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(size = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
            )
        )
        {
            Text(
                text = stringResource(id = R.string.register),
                style = TitleRegular,
                color = Color.White,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }
    }
}



