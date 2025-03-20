package br.com.ibm.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.ibm.diceroller.ui.theme.DiceRollerTheme
import br.com.ibm.diceroller.R

// Definição da classe principal
class MainActivity : ComponentActivity() {
    // Método onCreate()
    override fun onCreate(savedInstanceState: Bundle?) {
        // Chamando super.onCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
        // Configurando o conteúdo da tela
        setContent {
            // Aplicando o tema do aplicativo
            DiceRollerTheme {
                // Chamando a função DiceRollerApp()
                DiceRollerApp()
            }
        }
    }
}

// Definindo a tela do app
// Essa função organiza o layout do aplicativo
@Preview
@Composable
// Criando a função DiceRollerApp(), que será responsável por desenhar a tela do app
// Aqui dentro, vamos definir o que será mostrado na tela
fun DiceRollerApp() {
    // Chamando DiceWithButtonAndImage()
    DiceWithButtonAndImage(
        // Ajustando o tamanho e a posição
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

// Define a interface do usuário
// Essa função é a que realmente mostra os elementos na tela e faz o dado mudar ao apertar o botão
@Composable // indica que a função está criando algo visual no app
// Criando uma função que será responsável por mostrar o dado e o botão na tela
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // Variável de estado para armazenar o número sorteado
    var result by remember { mutableStateOf(1) }

    // Escolhendo a imagem do dado
    // Determina qual imagem será exibida com base no número sorteado
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    // Criando a interface do usuário
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Exibindo a imagem do botão
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )

        // Criando um espaço entre a imagem e o botão
        Spacer(modifier = Modifier.height(16.dp))

        // Criando o botão
        Button(onClick = { result = (1..6).random() }) {
            Text(stringResource(R.string.roll))
        }
    }
}
