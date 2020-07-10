class TransaksiMember(var nama: String) {
    
    fun transaksi() {
        println("-----------------------------")
        println("Checkout Pelanggan Member ${nama}")
        println("-----------------------------")
        print("Input Nama Barang: ")
        val inputBarang = readLine()!!
        println("Input Harga Satuan Barang: ${Barang.listBarang.get(inputBarang)}")
        print("Input Jumlah Barang: ")
        val inputJumlah = readLine()!!.toInt()
        println("-----------------------------")
        Barang.listTransaksi.put(inputBarang, inputJumlah)
        var totalItem: Int = Barang.listBarang.get(inputBarang)!! * inputJumlah
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

//
//        println(Barang.listTransaksi)
//        println(Barang.listTotalItem)

    }

    fun checkout(){
        println("-----------------------------")
        println("Checkout Pelanggan Member ${nama}")
        println("-----------------------------")
        
        Barang.banyakItem.forEachIndexed { index, s ->  }
    }
}