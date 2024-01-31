package com.example.myapplication

import java.util.*

class HaritaKapmacaOyunu(private val haritaBoyutu: Int) {
    private val random = Random()
    private var oyuncuKonumu = random.nextInt(haritaBoyutu)
    private var hedefKonumu = random.nextInt(haritaBoyutu)
    private var adimSayisi = 0

    init {
        println("Harita Kapmaca Oyununa Hoş Geldiniz!")
        println("Harita Boyutu: $haritaBoyutu")
        println("Hedef Konumu: $hedefKonumu\n")
    }

    fun oyunuBaslat() {
        while (oyuncuKonumu != hedefKonumu) {
            adimSayisi++
            println("Adım $adimSayisi - Oyuncu Konumu: $oyuncuKonumu")

            print("Hangi yöne gitmek istersiniz? (sol / sağ): ")
            val hareketYonu = readLine()

            if (hareketYonu == "sol") {
                if (oyuncuKonumu > 0) {
                    oyuncuKonumu--
                } else {
                    println("Harita sınırına ulaştınız. Başka bir yöne gidin.")
                }
            } else if (hareketYonu == "sağ") {
                if (oyuncuKonumu < haritaBoyutu - 1) {
                    oyuncuKonumu++
                } else {
                    println("Harita sınırına ulaştınız. Başka bir yöne gidin.")
                }
            } else {
                println("Geçersiz bir yönde hareket girdiniz. Lütfen 'sol' veya 'sağ' seçin.")
            }
        }

        println("\nTebrikler, hedefi buldunuz! Toplam adım sayısı: $adimSayisi")
    }


fun main() {
    val haritaBoyutu = 10
    val haritaKapmacaOyunu = HaritaKapmacaOyunu(haritaBoyutu)
    haritaKapmacaOyunu.oyunuBaslat()
}
}