fun testaLacos() {
    var i = 0
    while (i < 5) {
        val titular = "Alex $i"
        val numeroConta = 1000 + 1
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
        i++
    }

    for (i in 1..5) {
        val titular = "Alex $i"
        val numeroConta = 1000 + 1
        var saldo = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
    }
}