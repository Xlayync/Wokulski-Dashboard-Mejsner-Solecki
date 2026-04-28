package com.example.wokolskidashboard.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BalanceHeader(balance: Double) {
    Text(
        text = "Saldo: %.2f rubli".format(balance),
        style = MaterialTheme.typography.headlineMedium
    )
}