fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = ContaCorrente("João", 1002)
    var contaMaria = contaJoao
    contaMaria.titular = "Maria"
    contaJoao.titular = "João"

    println("titular conta joão: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")
}
