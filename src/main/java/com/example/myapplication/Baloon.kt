import java.util.*

class BalonPatlatmaOyunu(private val balonSayisi: Int) {
    private val random = Random()
    private val balonlar = CharArray(balonSayisi) { 'O' }
    private var patlatilanBalonlar = 0
    private val scanner = Scanner(System.`in`)

    init {
        Arrays.fill(balonlar, 'O')
    }

    fun oyunuBaslat() {
        println("Balon Patlatma Oyununa Hoş Geldiniz!")

        while (patlatilanBalonlar < balonSayisi) {
            println("\nBalonlar: ${balonlar.joinToString(" ")}")
            print("Hangi balonu patlatmak istersiniz? (0-${balonSayisi - 1}): ")

            try {
                val secilenBalon = scanner.nextInt()
                patlatBalon(secilenBalon)
            } catch (e: InputMismatchException) {
                println("Geçersiz giriş. Lütfen bir sayı girin.")
                scanner.next() // Hatalı girişi temizle
            }
        }

        println("\nTebrikler, tüm balonları patlattınız!")
    }

    private fun patlatBalon(index: Int) {
        if (index < 0 || index >= balonSayisi) {
            println("Geçersiz balon numarası. Lütfen geçerli bir numara girin.")
        } else if (balonlar[index] == 'O') {
            println("Balon patlatıldı!")
            balonlar[index] = 'X'
            patlatilanBalonlar++
        } else {
            println("Bu balon zaten patlatıldı. Lütfen başka bir balon seçin.")
        }
    }
}

fun main() {
    val balonSayisi = 5
    val balonPatlatmaOyunu = BalonPatlatmaOyunu(balonSayisi)
    balonPatlatmaOyunu.oyunuBaslat()
}