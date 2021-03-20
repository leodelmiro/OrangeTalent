fun main() {
    println("Bem vindo ao Bytebank")

    val contaAlex = Conta(titular = "Alex",numero = 1000)
    contaAlex.deposita(200.0)

    val contaFran = Conta(numero = 1001, titular = "Fran")
    contaAlex.deposita(300.0)

    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

//    println("depositando na conta do Alex")
//    contaAlex.deposita(50.0)
//    println(contaAlex.saldo)
//
//    println("depositando na conta do Fran")
//    contaFran.deposita(70.0)
//    println(contaFran.saldo)
//
//    println("sacando na conta do Alex")
//    contaAlex.saca(250.0)
//    println(contaAlex.saldo)
//
//    println("sacando na conta do Fran")
//    contaFran.saca(100.0)
//    println(contaFran.saldo)
//
//    println("saque em excesso na conta do Alex")
//    contaAlex.saca(100.0)
//    println(contaAlex.saldo)
//
//    println("saque em excesso na conta da Fran")
//    contaFran.saca(500.0)
//    println(contaFran.saldo)
//
//    println("Transferência da conta da Fran para o Alex")
//    if (contaFran.transfere(100.0, contaAlex)) {
//        println("Transferência sucedida")
//    } else {
//        println("Transferência falha")
//    }
//
//    println(contaAlex.saldo)
//    println(contaFran.saldo)
}


class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set

//    constructor(titular: String, numero: Int) {
//        this.titular = titular
//        this.numero = numero
//    }

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (this.saldo >= valor) {
            this.saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }

}

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta("João", 1002)
    var contaMaria = contaJoao
    contaMaria.titular = "Maria"
    contaJoao.titular = "João"

    println("titular conta joão: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")
}

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

fun testaCondicoes(saldo: Double) {
    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0) {
        println("conta é neutra")
    } else {
        println("conta é negativa")
    }

    when {
        saldo > 0.0 -> println("conta é positiva")
        saldo == 0.0 -> println("conta é neutra")
        else -> println("conta é negativa")
    }
}