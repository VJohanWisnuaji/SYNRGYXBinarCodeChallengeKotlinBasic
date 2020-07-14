import kotlin.math.roundToInt

class PembayaranAkhir(var nama: String = "") {
    internal fun cekDiskon() {
        if (Barang.totalHarga < 50000) {
            pembayaranAkhir()
        } else if (nama != "Non Member") {
            val sisa = Barang.totalHarga - (Barang.totalHarga * Barang.DISKON_MEMBER)
            Barang.totalHarga = sisa.roundToInt()
            println("-----------------------------")
            println(
                """Selamat! Karena total belanjaan $nama
            |lebih besar dari Rp. 50000 maka mendapatkan  
            |potongan sebesar 9.5%""".trimMargin()
            )
            println("$nama cukup bayar Rp. $sisa")
            pembayaranAkhir(nama)
        } else {
            val sisa = Barang.totalHarga - (Barang.totalHarga * Barang.DISKON_NONMEMBER)
            Barang.totalHarga = sisa.roundToInt()
            println("-----------------------------")
            println(
                """Selamat! Karena total belanjaan 
            |lebih besar dari Rp. 50000 maka mendapatkan  
            |potongan sebesar 4.1%""".trimMargin()
            )
            println("$nama cukup bayar Rp. $sisa.")
            pembayaranAkhir()
        }
    }

    fun pembayaranAkhir(nama: String) {
        try {
            println("-----------------------------")
            println("Checkout Pelanggan Member ${nama}")
            println("-----------------------------")
            println("Total Belanja : ${Barang.totalHarga.IDR()}")
            print("Input uang cumtomer: Rp. ")
            val uangCostumer = readLine()!!.toInt()
            println("-----------------------------")
            kembalian(uangCostumer)
            if (uangCostumer < Barang.totalHarga) {
                println("Uang Kurang")
                pembayaranAkhir()
            } else if (kembalian(uangCostumer) == 0) {
                println("-TERIMA KASIH-")
            } else {
                println("-----------------------------")
                println("Kembalian: ${kembalian(uangCostumer).IDR()}")
                println("-----------------------------")
                println("-TERIMA KASIH-")
            }
        } catch (e: NumberFormatException) {
            println("Inputan jumlah salah ulangi kembali")
            println("")
            println("")
            pembayaranAkhir(nama)
        }
    }

    fun pembayaranAkhir() {
        try {
            println("-----------------------------")
            println("Checkout Pelanggan ${nama}")
            println("-----------------------------")
            println("Total Belanja : ${Barang.totalHarga.IDR()}")
            print("Input uang cumtomer: Rp. ")
            val uangCostumer = readLine()!!.toInt()
            println("-----------------------------")
            if (uangCostumer < Barang.totalHarga) {
                println("Uang Kurang")
                pembayaranAkhir()
            } else if (kembalian(uangCostumer) == 0) {
                println("-TERIMA KASIH-")
            } else {
                println("-----------------------------")
                println("Kembalian: ${kembalian(uangCostumer).IDR()}")
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

    private fun kembalian(uangCostumer:Int):Int{
        val kembalian = uangCostumer - Barang.totalHarga
        return kembalian
    }
}