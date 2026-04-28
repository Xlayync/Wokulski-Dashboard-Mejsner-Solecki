package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun IncomeForm(
    onAddIncome: (String, Double) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nazwa produktu") }
        )

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Kwota") }
        )

        Button(onClick = {
            val value = amount.toDoubleOrNull()

            if (name.isNotBlank() && value != null && value > 0) {
                onAddIncome(name, value)

                // 8. czyszczenie formularza
                name = ""
                amount = ""
            }
        }) {
            Text("Dodaj przychód")
        }
    }
}