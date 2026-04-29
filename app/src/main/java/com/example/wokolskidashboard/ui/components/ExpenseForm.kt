package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ExpenseForm(
    name: String,
    amount: String,
    isOptional: Boolean,
    category: String,
    onNameChange: (String) -> Unit,
    onAmountChange: (String) -> Unit,
    onOptionalChange: (Boolean) -> Unit,
    onCategoryChange: (String) -> Unit,
    onSave: () -> Unit
) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text("Wydatek", style = MaterialTheme.typography.titleMedium)

        Spacer(Modifier.height(4.dp))

        WokolskiTextField(
            value = name,
            onValueChange = onNameChange,
            label = "Cel wydatku",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(4.dp))

        WokolskiTextField(
            value = amount,
            onValueChange = onAmountChange,
            label = "Kwota (rub.)",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))


        Text(
            "Kategoria",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        val categories = listOf("Sklep", "Kamienica", "Wydatki osobiste")


        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            categories.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 2.dp)
                ) {
                    RadioButton(
                        selected = category == item,
                        onClick = { onCategoryChange(item) },

                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color(0xFF2E7D32)
                        )
                    )
                    Text(text = item)
                }
            }
        }

        Spacer(Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Wydatek zbyteczny")
            Switch(
                checked = isOptional,
                onCheckedChange = onOptionalChange,

                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFF2E7D32)
                )
            )
        }

        Spacer(Modifier.height(8.dp))

        WokolskiButton(
            onClick = onSave,
            text = "Zapisz wydatek",
            modifier = Modifier.fillMaxWidth()
        )
    }
}