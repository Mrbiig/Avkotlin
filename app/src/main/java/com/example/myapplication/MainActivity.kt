package com.example.myapplication


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        ProductRegistrationScreen()
                    }
                )
            }
        }
    }
}

@Composable
fun ProductRegistrationScreen() {
    var productName by remember { mutableStateOf("") }
    var productCategory by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }
    var showMessage by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text("Nome do Produto") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = productCategory,
            onValueChange = { productCategory = it },
            label = { Text("Categoria") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = productPrice,
            onValueChange = { productPrice = it },
            label = { Text("Preço") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,

        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = productQuantity,
            onValueChange = { productQuantity = it },
            label = { Text("Quantidade em Estoque") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,

        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (productName.isNotBlank() && productCategory.isNotBlank() &&
                    productPrice.isNotBlank() && productQuantity.isNotBlank()) {
                    // Adicionar o produto à lista (a lista será implementada posteriormente)
                    showMessage = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cadastrar")
        }

        if (showMessage) {
            Text(
                text = "Produto cadastrado com sucesso!",
                modifier = Modifier.padding(top = 16.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductRegistrationScreenPreview() {
    MyApplicationTheme {
        ProductRegistrationScreen()
    }
}