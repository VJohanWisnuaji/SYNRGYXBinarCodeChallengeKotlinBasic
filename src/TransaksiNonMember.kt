import java.lang.NumberFormatException

class TransaksiNonMember {

    fun transaksi() {
        try {
            println("-----------------------------")
            println("Checkout Pelanggan Non Member")
            println("-----------------------------")
            print("Input Nama Barang: ")
            val inputBarang = readLine()!!
            println("Input Harga Satuan Barang: ${Barang.listBarang.get(inputBarang)?.IDR()}")
            print("Input Jumlah Barang: ")
            val inputJumlah = readLine()!!.toInt()
            println("-----------------------------")
            Barang.jumlahPerItem.put(inputBarang, inputJumlah)
            val totalItem: Int = Barang.listBarang.get(inputBarang)!! * inputJumlah
            Barang.listTotalItem.put(inputBarang, totalItem)
            Barang.banyakItem.add(inputBarang)

            val ya = 'Y'
            val tidak = 'T'

            fun end() {
                println("Input Barang Lagi? $ya/$tidak :")
                val inputPilihan = readLine()!!
                when (inputPilihan) {
                    "Y" -> {
                        transaksi()
                    }
                    "T" -> {
                        checkout()
                    }

                    else -> {
                        println("Pilihan tidak ada silahkan pilih lagi")
                        end()
                    }
                }
            }
            end()
        } catch (e: KotlinNullPointerException) {
            println("Barang tidak terdaftar dalam katalog silahkan masukkan kembali")
            println("")
            println("")
            transaksi()
        } catch (e: NumberFormatException) {
            println("Inputan jumlah salah ulangi kembali")
            println("")
            println("")
            transaksi()
        }
    }

    fun checkout() {
        println("-----------------------------")
        println("Checkout Pelanggan Non Member")
        println("-----------------------------")
        var urutan = 1
        for (item in Barang.banyakItem){
            println("${urutan}. $item x ${Barang.jumlahPerItem.get(item)} : ${Barang.listTotalItem.get(item)?.IDR()}  ")
            Barang.totalHarga += Barang.listTotalItem.get(item)!!
            urutan++
        }
        println("-----------------------------")
        println("Total Belanja : Rp. ${Barang.totalHarga}")
        PembayaranAkhir("Non Member").cekDiskon()
    }
}