package com.example.shift_application.presentation.ui.screen.registration

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shift_application.R
import com.example.shift_application.common.Constants
import com.example.shift_application.presentation.RegistrationViewModel
import com.example.shift_application.presentation.ui.screen.component.CustomClickableBox
import com.example.shift_application.presentation.ui.screen.component.CustomTextField
import com.example.shift_application.presentation.ui.screen.component.PasswordTextField
import com.example.shift_application.presentation.ui.screen.component.ValidationErrorAnimation
import com.example.shift_application.presentation.ui.screen.datepicker.DatePickerAlert
import com.example.shift_application.presentation.ui.state.RegistrationState
import com.example.shift_application.presentation.ui.theme.TitleSmall

@Composable
private fun RegistrationField(
    labelId: Int,
    textFieldValue: String,
    onValueChange: (String) -> Unit,
    error: String?,
    singleLine: Boolean = true
) {
    Text(
        text = stringResource(id = labelId),
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        style = TitleSmall,
        color = Color.Black
    )
    Spacer(modifier = Modifier.height(8.dp))
    CustomTextField(
        onValueChange = onValueChange,
        textFieldValue = textFieldValue,
        error = error,
        singleLine = singleLine
    )
}

@Composable
private fun PasswordField(
    labelId: Int,
    textFieldValue: String,
    onValueChange: (String) -> Unit,
    error: String?
) {
    Text(
        text = stringResource(id = labelId),
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        style = TitleSmall,
        color = Color.Black
    )
    Spacer(modifier = Modifier.height(8.dp))
    PasswordTextField(onValueChange = onValueChange, textFieldValue = textFieldValue, error = error)
}


@Composable
fun RegistrationSection(
    registrationState: RegistrationState,
    registrationViewModel: RegistrationViewModel
) {

    val isDialogOpen = remember { mutableStateOf(false) }

    RegistrationField(
        labelId = R.string.name,
        textFieldValue = registrationState.name,
        onValueChange = { registrationViewModel.setName(it) },
        error = registrationState.nameError,
        singleLine = true
    )
    if (registrationState.nameError != null) {
        ValidationErrorAnimation(errorMessage = registrationState.nameError)
    }
    Spacer(modifier = Modifier.height(22.dp))
    RegistrationField(
        labelId = R.string.surname,
        textFieldValue = registrationState.surname,
        onValueChange = { registrationViewModel.setSurname(it) },
        error = registrationState.surnameError,
        singleLine = true
    )
    if (registrationState.surnameError != null) {
        ValidationErrorAnimation(errorMessage = registrationState.surnameError)
    }
    Spacer(modifier = Modifier.height(22.dp))
    Text(
        text = stringResource(id = R.string.birthDate),
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        style = TitleSmall,
        color = Color.Black
    )
    Spacer(modifier = Modifier.height(8.dp))
    CustomClickableBox(
        checked = isDialogOpen,
        birth = registrationState.birthDate ?: Constants.EMPTY_STRING,
        error = null
    )
    Spacer(modifier = Modifier.height(22.dp))
    PasswordField(
        labelId = R.string.password,
        textFieldValue = registrationState.password,
        onValueChange = { registrationViewModel.setPassword(it) },
        error = registrationState.passwordError
    )
    if (registrationState.passwordError != null) {
        ValidationErrorAnimation(errorMessage = registrationState.passwordError)
    }
    Spacer(modifier = Modifier.height(22.dp))
    PasswordField(
        labelId = R.string.confirmPassword,
        textFieldValue = registrationState.confirmPassword,
        onValueChange = { registrationViewModel.setConfirmPassword(it) },
        error = registrationState.confirmPasswordError
    )
    if (registrationState.confirmPasswordError != null) {
        ValidationErrorAnimation(errorMessage = registrationState.confirmPasswordError)
    }
    Spacer(modifier = Modifier.height(22.dp))

    if (isDialogOpen.value) {
        DatePickerAlert(
            checked = isDialogOpen,
            onClick = { registrationViewModel.setBirthDate(it) })
    }
}