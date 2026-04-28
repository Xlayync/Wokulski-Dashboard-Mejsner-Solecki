package com.example.wokolskidashboard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.BalanceHeader
import com.example.wokolskidashboard.ui.components.IncomeForm

@Composable
fun MainScreen() {

    val transactions = remember { mutableStateListOf<Transaction>() }

    val balance = transactions.sumOf {
        if (it.isExpense) -it.amount else it.amount
    }

    Column(modifier = Modifier.padding(16.dp)) {

        BalanceHeader(balance)

        Spacer(modifier = Modifier.height(16.dp))

        IncomeForm { name, amount ->
            transactions.add(
                Transaction(name, amount, false)
            )
        }
    }
}