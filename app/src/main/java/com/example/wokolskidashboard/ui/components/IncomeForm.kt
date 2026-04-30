package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IncomeForm(
    onAddIncome: (String, Double) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    var nameError by remember { mutableStateOf("") }
    var amountError by remember { mutableStateOf("") }

    Column {

        // 🔹 NAZWA
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                nameError = ""
            },
            label = { Text("Nazwa produktu") },
            isError = nameError.isNotEmpty(),
            supportingText = {
                Text(
                    text = if (nameError.isNotEmpty()) nameError else " ",
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 🔹 KWOTA
        OutlinedTextField(
            value = amount,
            onValueChange = {
                amount = it
                amountError = ""
            },
            label = { Text("Kwota") },
            isError = amountError.isNotEmpty(),
            supportingText = {
                Text(
                    text = if (amountError.isNotEmpty()) amountError else " ",
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 🔹 BUTTON
        Button(
            onClick = {
                val value: Double? = amount.toDoubleOrNull()

                var isValid = true

                if (name.isBlank()) {
                    nameError = "Podaj nazwę"
                    isValid = false
                }

                if (value == null) {
                    amountError = "Podaj poprawną liczbę"
                    isValid = false
                } else if (value <= 0) {
                    amountError = "Musi być > 0"
                    isValid = false
                }

                if (isValid && value != null) {
                    onAddIncome(name, value)

                    name = ""
                    amount = ""
                }
            }
        ) {
            Text("Dodaj przychód")
        }
    }
}