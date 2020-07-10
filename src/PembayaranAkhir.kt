import kotlin.math.roundToInt

class PembayaranAkhir(var nama: String = "") {


    fun cekDiskon() {
        if (Barang.totalHarga < 50000) {
            pembayaranAkhir()
        } else if (nama != "Non Member"){

            val sisa = Barang.totalHarga - (Barang.totalHarga * 0.095)
            Barang.totalHarga = sisa.roundToInt()
            println("-----------------------------")
            println(
                """Selamat! Karena total belanjaan $nama 
            |lebih besar dari Rp. 50000 maka mendapatkan  
            |potongan sebesar 9.5%""".trimMargin()
            )
            println("$nama cukup bayar Rp. $sisa")
            pembayaranAkhir()
        }
        else {

            val sisa = Barang.totalHarga - (Barang.totalHarga * 0.041)
            Barang.totalHarga = sisa.roundToInt()
            println("-----------------------------")
            println(
                """Selamat! Karena total belanjaan 
            |lebih besar dari Rp. 50000 maka mendapatkan  
            |potongan sebesar 4.1%""".trimMargin()
            )
            println("$nama cukup bayar Rp. $sisa")
            pembayaranAkhir()
        }
    }

    fun pembayaranAkhir() {
        try {
            println("-----------------------------")
            println("Checkout Pelanggan Member ${nama}")
            println("-----------------------------")
            println("Total Belanja : Rp. ${Barang.totalHarga}")
            print("Input uang cumtomer: Rp. ")
            val uangCostumer = readLine()!!.toInt()
            println("-----------------------------")
            val kembalian = uangCostumer % Barang.totalHarga
            if (kembalian == 0) {
                println("-TERIMA KASIH-")
            } else {
                println("-----------------------------")
                println("Kembalian: Rp. $kembalian")
                println("-----------------------------")
                println("-TERIMA KASIH-")
            }
        } catch (e: NumberFormatException) {
            println("Inputan jumlah salah ulangi kembali")
            println("")
            println("")
            pembayaranAkhir()
        }
    }
}