package com.example.shift_application.presentation.ui.screen.datepicker

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.shift_application.presentation.ui.theme.UbuntuRegular
import java.time.LocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerAlert(checked: MutableState<Boolean>, onClick: (Long?) -> Unit) {
    val datePickerState = remember {
        DatePickerState(
            yearRange = 1950..2022,
            initialSelectedDateMillis = LocalDateTime.now().second.toLong(),
            initialDisplayedMonthMillis = null,
            initialDisplayMode = DisplayMode.Picker,

        )
    }
    if (checked.value) {
        DatePickerDialog(
            colors = DatePickerDefaults.colors(
                currentYearContentColor = Color.White,
                containerColor = Color.White
            ),
            onDismissRequest = {
                checked.value = false
            },
            confirmButton = {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        modifier = Modifier
                            .align(Alignment.Center),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black
                        ),
                        onClick = {
                            checked.value = false
                            onClick(datePickerState.selectedDateMillis)
                        }) {
                        Text(
                            text = "Подтвердить",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = UbuntuRegular,
                                color = Color.White
                            )
                        )
                    }
                }
            }
        )
        {
            DatePicker(
                state = datePickerState,
                colors = DatePickerDefaults.colors(
                    titleContentColor = Color.Black,
                    headlineContentColor = Color.Black,
                    weekdayContentColor = Color.Black,
                    subheadContentColor = Color.Black,
                    yearContentColor = Color.Black,
                    currentYearContentColor = Color.White,
                    selectedYearContentColor = Color.White,
                    selectedYearContainerColor = Color.Black,
                    dayContentColor = Color.Black,
                    disabledDayContentColor = Color.Black,
                    selectedDayContainerColor = Color.Black,
                    disabledSelectedDayContainerColor = Color.Black,
                    todayContentColor = Color.Black,
                    todayDateBorderColor = Color.Black,
                    dayInSelectionRangeContentColor = Color.Black,
                    dayInSelectionRangeContainerColor = Color.Black
                )
            )
        }
    }
}