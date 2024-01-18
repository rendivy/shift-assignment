package com.example.shift_application.domain.core

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)