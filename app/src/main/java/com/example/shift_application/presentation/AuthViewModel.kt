package com.example.shift_application.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shift_application.domain.usecase.IsUserLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val isUserLoginUseCase: IsUserLoginUseCase,
    private val ioDispatcher: CoroutineDispatcher
) :
    ViewModel() {

    init {
        checkIfLoggedIn()
    }

    val authState: StateFlow<Boolean>
        get() = _authState

    private var _authState: MutableStateFlow<Boolean> = MutableStateFlow(false)

    private fun checkIfLoggedIn() {
        viewModelScope.launch(ioDispatcher) {
            _authState.value = isUserLoginUseCase.execute()
        }
    }

}