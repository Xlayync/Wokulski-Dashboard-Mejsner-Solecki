package com.example.wokolskidashboard.ui
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wokolskidashboard.model.Transaction
import com.example.wokolskidashboard.ui.components.IncomeForm
import com.example.wokolskidashboard.ui.components.TransactionCard

@Composable
fun MainScreen() {

    val transactions = remember { mutableStateListOf<Transaction>() }

    val balance = transactions.sumOf {
        if (it.isExpense) -it.amount else it.amount
    }

    var isExpenseMode by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        // 🔹 SALDO (bardziej "card look")
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Saldo",
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = "%.2f rubli".format(balance),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 🔹 WYBÓR TRYBU
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text("Zysk")

                Switch(
                    checked = isExpenseMode,
                    onCheckedChange = {
                        isExpenseMode = false // nadal blokada
                    }
                )

                Text("Koszt (wkrótce)")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 🔹 FORMULARZ
        Text(
            text = "Dodaj transakcję",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        IncomeForm { name, amount ->
            transactions.add(
                Transaction(
                    name = name,
                    amount = amount,
                    isExpense = false
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        // 🔥 LISTA TRANSAKCJI
        Text(
            text = "Historia",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(transactions.size) { index ->
                val transaction = transactions[index]
                TransactionCard(transaction)
            }
        }
    }
}