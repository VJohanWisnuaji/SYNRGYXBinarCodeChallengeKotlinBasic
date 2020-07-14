class Barang {
    companion object {
        var listBarang =
            mapOf(
                "Kisbray 3in1" to 12000,
                "BangBang" to 3000,
                "Pepsident" to 6000,
                "Bemoli" to 20000,
                "TinderJoy" to 30000
            )
        var banyakItem = mutableListOf<String>()
        var jumlahPerItem = mutableMapOf<String, Int>()
        var listTotalItem = mutableMapOf<String, Int>()
        var totalHarga = 0
        const val DISKON_MEMBER = 0.095
        const val DISKON_NONMEMBER = 0.041
    }
}