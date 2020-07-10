fun main() {
    println("-----------------------------")
    println("Selamat Datang Di Synrgy Mart")
    println("-----------------------------")
    println("1. Login Kasir")
    println("0. Keluar")
    print("Masukkan pilihan: ")
    val input1 = readLine()!!

    when (input1) {
        "1" -> {
            loginKasir()
        }
        "0" -> {
            println("---------------------")
            println("     Terimakasih")
            println("---------------------")
        }
        else -> {
            println("Pilihan tidak ada silahkan kembali lagi")
            main()
        }
    }
}

fun loginKasir() {
    println("-----------------------------")
    println("Selamat Datang Di Synrgy Mart")
    println("-----------------------------")
    println("+Login Kasir+")
    print("Username : ")
    val inputUsername = readLine()!!
    print("Password : ")
    val inputPassword = readLine()!!

    if (inputUsername != Kasir().nama || inputPassword != Kasir().password) {
        println(
            """Username atau password yang anda masukkan salah 
        |silahkan masukkan kembali username dan password""".trimMargin()
        )
        loginKasir()
    } else {
        loginKasir2()
    }
}

fun loginKasir2() {
    println("-----------------------------")
    println("Selamat Datang ${Kasir().nama}")
    println("-----------------------------")
    println("1. Checkout Pelanggan")
    println("0. Keluar")
    print("Masukkan pilihan: ")
    val input1 = readLine()!!

    when (input1) {
        "1" -> {
            checkoutPelanggan()
        }
        "0" -> {
            println("---------------------")
            println("     Terimakasih")
            println("---------------------")
        }
        else -> {
            println("Pilihan tidak ada silahkan kembali lagi")
            loginKasir2()
        }
    }
}

fun checkoutPelanggan() {
    println("-----------------------------")
    println("Checkout Pelanggan")
    println("-----------------------------")
    println("1. Pelanggan Member")
    println("2. Pelanggan Non-Member")
    print("Masukkan pilihan: ")
    val input1 = readLine()!!

    when (input1) {
        "1" -> {
            checkoutPelangganMember()
        }
        "2" -> {

        }
        else -> {
            println("Pilihan tidak ada silahkan kembali lagi")
            checkoutPelanggan()
        }
    }
}

fun checkoutPelangganMember() {
    println("-----------------------------")
    println("Checkout Pelanggan Member")
    println("-----------------------------")
    print("Input Nama Member: ")
    val input1 = readLine()!!

    var memberList = Member().namaMember

    if (memberList.indexOf(input1) < 0){
        println("Member tidak terdaftar silahkan pilih kembali")
        checkoutPelanggan()
    } else{
        TransaksiMember(input1).transaksi()
    }

}