import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.myapplication.Estoque
import com.example.myapplication.Product

@Composable
fun CadastroProdutoScreen() {
    val context = LocalContext.current
    val nomeProduto = remember { mutableStateOf("") }
    val categoria = remember { mutableStateOf("") }
    val preco = remember { mutableStateOf("") }
    val quantidade = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        // Campo para Nome do Produto
        TextField(
            value = nomeProduto.value,
            onValueChange = { nomeProduto.value = it },
            label = { Text("Nome do Produto") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo para Categoria
        TextField(
            value = categoria.value,
            onValueChange = { categoria.value = it },
            label = { Text("Categoria") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo para Preço
        TextField(
            value = preco.value,
            onValueChange = { preco.value = it },
            label = { Text("Preço") },
            modifier = Modifier.fillMaxWidth()
        )

        // Campo para Quantidade
        TextField(
            value = quantidade.value,
            onValueChange = { quantidade.value = it },
            label = { Text("Quantidade em Estoque") },
            modifier = Modifier.fillMaxWidth()
        )

        // Botão de Cadastro
        Button(onClick = {
            val precoValor = preco.value.toDoubleOrNull()
            val quantidadeValor = quantidade.value.toIntOrNull()

            // Validações
            if (nomeProduto.value.isBlank() || categoria.value.isBlank() || precoValor == null || quantidadeValor == null) {
                Toast.makeText(context, "Todos os campos devem ser preenchidos!", Toast.LENGTH_SHORT).show()
                return@Button
            }

            if (precoValor < 0) {
                Toast.makeText(context, "O preço não pode ser menor que 0!", Toast.LENGTH_SHORT).show()
                return@Button
            }

            if (quantidadeValor < 1) {
                Toast.makeText(context, "A quantidade deve ser pelo menos 1!", Toast.LENGTH_SHORT).show()
                return@Button
            }

            // Adiciona o produto à lista
            Estoque.adicionarProduto(Product(nomeProduto.value, categoria.value, precoValor, quantidadeValor))
            // Limpa os campos após o cadastro
            nomeProduto.value = ""
            categoria.value = ""
            preco.value = ""
            quantidade.value = ""

            Toast.makeText(context, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
        }) {
            Text("Cadastrar")
        }
    }
}