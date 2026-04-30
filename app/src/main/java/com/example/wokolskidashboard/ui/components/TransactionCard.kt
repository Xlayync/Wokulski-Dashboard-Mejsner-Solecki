package com.example.wokolskidashboard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction

@Composable
fun TransactionCard(transaction: Transaction) {
    val bg = if (transaction.isExpense) Color(0xFFFFCDD2) else Color(0xFFC8E6C9)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(bg)
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(transaction.name, style = MaterialTheme.typography.bodyLarge)
            if (transaction.isExpense && transaction.isOptional) {
                Text(
                    " Wydatek zbyteczny",
                    color = Color(0xFF2E7D32)
                )
            }
            if(transaction.category != null) {
                Text(transaction.category, style = MaterialTheme.typography.bodySmall)
            }
        }
        Text("${transaction.amount} rub.", style = MaterialTheme.typography.bodyLarge)
    }
}
