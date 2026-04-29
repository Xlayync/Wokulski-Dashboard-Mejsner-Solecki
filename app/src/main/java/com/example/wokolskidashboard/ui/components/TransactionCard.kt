package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun TransactionCard(transaction: Transaction) {

    val color = if (transaction.isExpense) Color.Red else Color(0xFF2E7D32)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // 🔹 NAZWA
            Text(
                text = transaction.name,
                style = MaterialTheme.typography.bodyLarge
            )

            // 🔹 KWOTA + TYP
            Column(horizontalAlignment = Alignment.End) {

                Text(
                    text = if (transaction.isExpense) "-%.2f".format(transaction.amount)
                    else "+%.2f".format(transaction.amount),
                    color = color,
                    style = MaterialTheme.typography.bodyLarge
                )

                Text(
                    text = if (transaction.isExpense) "Wydatek" else "Zysk",
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.Gray
                )
            }
        }
    }
}
