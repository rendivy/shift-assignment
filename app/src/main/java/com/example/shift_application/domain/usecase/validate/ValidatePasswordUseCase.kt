package com.example.shift_application.domain.usecase.validate

import com.example.shift_application.domain.core.ValidationResult

class ValidatePasswordUseCase {
    fun validatePassword(password: String): ValidationResult {
        return if (password.length < 8 && password.isNotBlank()) {
            ValidationResult(false, "Пароль должен содержать не менее 8-ми символов")
        } else {
            ValidationResult(true)
        }
    }

    fun validateConfirmPassword(password: String, confirmPassword: String): ValidationResult {
        return if (password != confirmPassword) {
            ValidationResult(false, "Пароли не совпадают")
        } else {
            ValidationResult(true)
        }
    }
}