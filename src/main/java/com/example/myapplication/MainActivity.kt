import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.util.*
import kotlin.random.Random as Random1

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    var showDialog by remember { mutableStateOf(false) }
                    var typedText by remember { mutableStateOf("") }

                    Text("Merhaba, bu bir yazıdır!", modifier = Modifier.padding(16.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = {
                            showDialog = true
                            // Butona tıklandığında typedText'i sıfırla
                            typedText = ""
                        }) {
                            Text("Oyunu Başlat")
                        }

                        if (showDialog) {
                            AlertDialog(
                                onDismissRequest = { showDialog = false },
                                title = { Text("Yeni Pencere") },
                                text = {
                                    // TextField ile yazı yazma
                                    TextField(
                                        value = typedText,
                                        onValueChange = { typedText = it },
                                        label = { Text("Yazıyı girin") },
                                        keyboardOptions = KeyboardOptions.Default.copy(
                                            imeAction = ImeAction.Done
                                        ),
                                        keyboardActions = KeyboardActions(
                                            onDone = {
                                                // Yazıyı ekrana çıkart
                                                showToast("Yazı: $typedText")
                                                showDialog = false
                                            }
                                        )
                                    )
                                },
                                confirmButton = {
                                    // "Tamam" butonu
                                    Button(onClick = {
                                        showToast("Yazı: $typedText")
                                        showDialog = false
                                    }) {
                                        Text("Tamam")
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    fun main() {
        println("Adam Asmaca Oyununa Hoş Geldiniz!")

        val words = arrayOf("kotlin", "android", "java", "python", "openai", "gpt")
        val random = Random1
        val selectedWord = words[random.nextInt(words.size)]
        var guessedWord = CharArray(selectedWord.length) { '*' }

        var incorrectAttempts = 0
        val maxAttempts = 6

        val scanner = Scanner(System.`in`)

        while (incorrectAttempts < maxAttempts) {
            println("\nKelime: ${guessedWord.joinToString(" ")}")
            print("Tahmininiz: ")
            val guess = scanner.next()[0]

            if (selectedWord.contains(guess)) {
                println("Doğru tahmin!")
                for (i in selectedWord.indices) {
                    if (selectedWord[i] == guess) {
                        guessedWord[i] = guess
                    }
                }
            } else {
                println("Yanlış tahmin. Kalan hakkınız: ${maxAttempts - incorrectAttempts - 1}")
                incorrectAttempts++
            }

            if (guessedWord.joinToString("") == selectedWord) {
                println("\nTebrikler, kelimeyi buldunuz: $selectedWord")
                break
            }
        }

        if (incorrectAttempts == maxAttempts) {
            println("\nÜzgünüm, hakkınız doldu. Doğru kelime: $selectedWord")
        }
    }

    private fun showToast(message: String) {
        // Toast mesajı gösterme işlemi (Bu kısmı kendi uygulama mantığınıza göre ayarlamalısınız)
        // Örnek olarak, Toast.makeText(this, message, Toast.LENGTH_SHORT).show() kullanılabilir.
        // Ancak, bu örnekte direkt olarak kullanılmıştır.
        println("Toast: $message")
    }
}
