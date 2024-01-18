package com.example.shift_application.presentation


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shift_application.common.Constants
import com.example.shift_application.domain.repository.RegistrationRepository
import com.example.shift_application.presentation.ui.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: RegistrationRepository) :
    ViewModel() {

    val homeState: MutableState<HomeState>
        get() = _homeState

    private val _homeState: MutableState<HomeState> = mutableStateOf(
        HomeState(
            name = Constants.EMPTY_STRING,
            surname = Constants.EMPTY_STRING,
            birthDate = Constants.EMPTY_STRING,
        )
    )

    fun logout(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.logout()
        }
    }

    fun getUserInformation() {
        viewModelScope.launch(Dispatchers.IO) {
            val userInformation = repository.getUserInformation()
            _homeState.value = _homeState.value.copy(
                name = userInformation.name,
                surname = userInformation.surname,
                birthDate = userInformation.birthDate
            )
        }

    }

}