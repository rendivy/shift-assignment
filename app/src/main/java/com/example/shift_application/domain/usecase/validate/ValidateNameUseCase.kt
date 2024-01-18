package com.example.shift_application.domain.usecase.validate

import com.example.shift_application.domain.core.ValidationResult

class ValidateNameUseCase {

    fun validateName(name: String): ValidationResult {
        return if (name.length < 3 && name.isNotBlank()) {
            ValidationResult(false, "Имя должно содержать не менее 3-х символов")
        }
        else {
            ValidationResult(true)
        }
    }

}