package com.example.shift_application.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shift_application.common.Constants
import com.example.shift_application.domain.usecase.validate.RegisterUserUseCase
import com.example.shift_application.domain.usecase.validate.ValidateNameUseCase
import com.example.shift_application.domain.usecase.validate.ValidatePasswordUseCase
import com.example.shift_application.domain.usecase.validate.ValidateSurnameUseCase
import com.example.shift_application.presentation.ui.state.RegistrationState
import com.example.shift_application.utils.DateConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val validateNameUseCase: ValidateNameUseCase,
    private val validateSurnameUseCase: ValidateSurnameUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {


    val registrationState: State<RegistrationState>
        get() = _registrationState


    private val _registrationState: MutableState<RegistrationState> = mutableStateOf(
        RegistrationState(
            name = Constants.EMPTY_STRING,
            surname = Constants.EMPTY_STRING,
            birthDate = Constants.EMPTY_STRING,
            password = Constants.EMPTY_STRING,
            confirmPassword = Constants.EMPTY_STRING
        )
    )

    fun registerUser() {
        viewModelScope.launch(Dispatchers.IO) {
            registerUserUseCase.execute(
                _registrationState.value.name,
                _registrationState.value.surname,
                _registrationState.value.birthDate!!
            )
        }
    }

    fun setName(name: String) {
        _registrationState.value =
            _registrationState.value.copy(
                name = name,
                nameError = validateNameUseCase.validateName(name).errorMessage
            )
        updateRegistrationAvailability()
    }

    fun setSurname(surname: String) {
        _registrationState.value = _registrationState.value.copy(
            surname = surname,
            surnameError = validateSurnameUseCase.validateSurname(surname).errorMessage
        )
        updateRegistrationAvailability()
    }

    fun setBirthDate(birthDate: Long?) {
        _registrationState.value =
            _registrationState.value.copy(
                birthDate = DateConverter.convertDateToString(
                    birthDate ?: 0
                )
            )
        updateRegistrationAvailability()
    }

    fun setPassword(password: String) {
        _registrationState.value = _registrationState.value.copy(
            password = password,
            passwordError = validatePasswordUseCase.validatePassword(password).errorMessage
        )
        updateRegistrationAvailability()

    }

    fun setConfirmPassword(confirmPassword: String) {
        _registrationState.value =
            _registrationState.value.copy(
                confirmPassword = confirmPassword,
                confirmPasswordError = validatePasswordUseCase
                    .validateConfirmPassword(
                        _registrationState.value.password,
                        confirmPassword
                    ).errorMessage
            )
        updateRegistrationAvailability()
    }


    private fun updateRegistrationAvailability() {
        val fields = listOf(
            _registrationState.value.name,
            _registrationState.value.surname,
            _registrationState.value.password,
            _registrationState.value.confirmPassword,
            _registrationState.value.birthDate
        )

        val errors = listOf(
            _registrationState.value.nameError,
            _registrationState.value.surnameError,
            _registrationState.value.passwordError,
            _registrationState.value.confirmPasswordError,
        )

        _registrationState.value = _registrationState.value.copy(
            registrationIsAvailable =
            fields.all { it != Constants.EMPTY_STRING } && errors.all { it == null }
        )
    }


}