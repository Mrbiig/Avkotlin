package com.example.myapplication

import android.content.Intent
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme


object SampleData {
    val productList = listOf(
        Product("Produto A", "Categoria 1", 10.0, 10),
        Product("Produto B", "Categoria 2", 20.0, 5),
        Product("Produto C", "Categoria 3", 30.0, 15)
    )
}

class ProductListActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        ProductListScreen(productList = SampleData.productList) // Passando a lista de produtos
                    }
                )
            }
        }
    }
}

@Composable
fun ProductListScreen(productList: List<Product>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // items espera uma lista de Product
        items(productList) { product ->
            ProductItem(product = product, onDetailsClick = {
                // Ação para abrir tela de detalhes
            })
        }
    }
}

@Composable
fun ProductItem(product: Product, onDetailsClick: () -> Unit) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "${product.name} (${product.quantityInStock} unidades)")
        Button(onClick = {

            val intent = Intent(context, ProductDetailsActivity::class.java).apply {
                putExtra("productName", product.name)
                putExtra("productCategory", product.category)
                putExtra("productPrice", product.price)
                putExtra("productQuantity", product.quantityInStock)
            }
            context.startActivity(intent)
        }) {
            Text("Detalhes")
        }
    }
}