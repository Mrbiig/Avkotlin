package com.example.myapplication

data class Product(
    val name: String,
    val category: String,
    val price: Double,
    val quantityInStock: Int
)

object Estoque {
    private val produtos = mutableListOf<Product>()

    fun adicionarProduto(produto: Product) {
        produtos.add(produto)
    }

    fun calcularValorTotalEstoque(): Double {
        return produtos.sumOf { it.price * it.quantityInStock }
    }

    fun getProdutos(): List<Product> {
        return produtos
    }
}