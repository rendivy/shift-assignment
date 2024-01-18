package com.example.shift_application.presentation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shift_application.R
import com.example.shift_application.common.NavigationConstants
import com.example.shift_application.presentation.HomeViewModel
import com.example.shift_application.presentation.ui.theme.TitleRegular
import com.example.shift_application.presentation.ui.theme.largePadding
import com.example.shift_application.presentation.ui.theme.shortPadding


@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navController: NavController
) {
    val homeState = remember { homeViewModel.homeState }
    val showDialog = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        homeViewModel.getUserInformation()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { showDialog.value = true },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = largePadding, end = largePadding),
            shape = RoundedCornerShape(size = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text(
                text = stringResource(id = R.string.greetings),
                style = TitleRegular,
                color = Color.White,
                modifier = Modifier.padding(top = shortPadding, bottom = shortPadding)
            )
        }
        Spacer(modifier = Modifier.height(largePadding))
        Button(
            onClick = {
                homeViewModel.logout()
                navController.navigate(NavigationConstants.REGISTRATION_ROUTE){
                    popUpTo(NavigationConstants.HOME_ROUTE) {
                        inclusive = true
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = largePadding, end = largePadding),
            shape = RoundedCornerShape(size = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            )
        ) {
            Text(
                text = stringResource(id = R.string.logout),
                style = TitleRegular,
                color = Color.White,
                modifier = Modifier.padding(top = shortPadding, bottom = shortPadding)
            )
        }
    }
    if (showDialog.value) {
        ModalWindow(
            name = homeState.value.name,
            onClick = { showDialog.value = false }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ModalWindow(name: String, onClick: () -> Unit) {
    AlertDialog(onDismissRequest = onClick) {
        Column(
            modifier = Modifier
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                style = TitleRegular,
                color = Color.Black,
                modifier = Modifier.padding(top = largePadding, bottom = largePadding)
            )
            Button(
                onClick = onClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = largePadding, end = largePadding, bottom = 32.dp),
                shape = RoundedCornerShape(size = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                Text(
                    text = stringResource(id = R.string.close),
                    style = TitleRegular,
                    color = Color.White,
                    modifier = Modifier.padding(top = shortPadding, bottom = shortPadding)
                )
            }
        }
    }
}