package com.example.shift_application.presentation.ui.state

data class RegistrationState(
    val name: String,
    val nameError: String? = null,
    val surname: String,
    val surnameError: String? = null,
    val birthDate: String? = null,
    val password: String,
    val passwordError: String? = null,
    val confirmPassword: String,
    val confirmPasswordError: String? = null,
    val registrationIsAvailable: Boolean = false
)