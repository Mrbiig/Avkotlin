package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavController


class EstatisticasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EstatisticasScreen( navController)
        }
    }
}

@Composable
fun EstatisticasScreen(navController: Any) {
    // Cálculo das estatísticas
    val valorTotalEstoque = Estoque.calcularValorTotalEstoque()
    val quantidadeTotalProdutos = Estoque.getProdutos().sumOf { it.quantityInStock }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Estatísticas do Estoque", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Valor Total do Estoque: R$ ${valorTotalEstoque.format(2)}")
        Text(text = "Quantidade Total de Produtos: $quantidadeTotalProdutos")

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para voltar
        Button(onClick = { /* Navegar de volta para a tela anterior */ }) {
            Text("Voltar")
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "listaProdutos") {
        composable("listaProdutos") { ListaProdutosScreen(navController) }
        composable("estatisticas") { EstatisticasActivity() } // Aqui você pode adicionar a navegação
    }
}
