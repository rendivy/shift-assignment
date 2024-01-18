package com.example.shift_application.domain.usecase.validate

import com.example.shift_application.domain.core.ValidationResult

class ValidateSurnameUseCase {

    fun validateSurname(surname: String): ValidationResult {
        return if (surname.length < 3 && surname.isNotBlank()) {
            ValidationResult(false, "Фамилия должна содержать не менее 3-х символов")
        } else {
            ValidationResult(true)
        }
    }
}