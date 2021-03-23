import br.com.leodelmiro.bytebank.modelo.Cliente
import br.com.leodelmiro.bytebank.modelo.ContaCorrente

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val joao = Cliente(nome = "João", cpf = "", senha = 1)
    val contaJoao = ContaCorrente(joao, 1002)
    var contaMaria = contaJoao
    contaMaria.titular.nome = "Maria"
    contaJoao.titular.nome = "João"

    println("titular conta joão: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")
}
