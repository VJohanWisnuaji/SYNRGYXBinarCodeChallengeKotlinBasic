import kotlin.math.roundToInt

class PembayaranAkhir(var nama: String = "") {

    fun cekDiskon() {
        if (Barang.totalHarga < 50000) {
            pembayaranAkhir()
        } else {
            var sisa = Barang.totalHarga - (Barang.totalHarga * 0.095)
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
    }

    fun pembayaranAkhir() {
        println("-----------------------------")
        println("Checkout Pelanggan Member ${nama}")
        println("-----------------------------")
        println("Total Belanja : Rp. ${Barang.totalHarga}")
        print("Input uang cumtomer: Rp. ")
        var uangCostumer = readLine()!!.toInt()
        println("-----------------------------")
        var kembalian = uangCostumer % Barang.totalHarga
        if (kembalian == 0) {
            println("-TERIMA KASIH-")
        } else {
            println("-----------------------------")
            println("Kembalian: Rp. $kembalian")
            println("-----------------------------")
            println("-TERIMA KASIH-")
        }
    }
}