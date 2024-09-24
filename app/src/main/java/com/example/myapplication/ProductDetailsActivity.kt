package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class ProductDetailsActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Receber os dados do Intent
        val productName = intent.getStringExtra("productName") ?: "Produto desconhecido"
        val productCategory = intent.getStringExtra("productCategory") ?: "Categoria desconhecida"
        val productPrice = intent.getDoubleExtra("productPrice", 0.0)
        val productQuantity = intent.getIntExtra("productQuantity", 0)

        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        ProductDetailsScreen(
                            productName = productName,
                            productCategory = productCategory,
                            productPrice = productPrice,
                            productQuantity = productQuantity
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun ProductDetailsScreen(
    productName: String,
    productCategory: String,
    productPrice: Double,
    productQuantity: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Nome: $productName")
        Text(text = "Categoria: $productCategory")
        Text(text = "Preço: R$ $productPrice")
        Text(text = "Quantidade em Estoque: $productQuantity unidades")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Lógica para voltar à lista de produtos */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}