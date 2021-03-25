import br.com.leodelmiro.bytebank.modelo.Cliente
import br.com.leodelmiro.bytebank.modelo.ContaPoupanca
import br.com.leodelmiro.bytebank.modelo.Endereco
import br.com.leodelmiro.bytebank.teste.testaHOF

fun main() {
    testaHOF()
}

fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12
    println("taxa mensal $taxaMensal")

    val contaPoupanca = ContaPoupanca(Cliente(nome = "Alex", cpf = "111.111.111-11", senha = 1234), 1000)

    contaPoupanca.run {
        deposita(2000.0)
        saldo * taxaMensal
    }.let(::println)

    val rendimentoAnual = run {
        var saldo = contaPoupanca.saldo
        repeat(12) { indice ->
            saldo += saldo * taxaMensal
        }

        saldo
    }

    println(rendimentoAnual)
}

fun testaWith() {
    with(Endereco()) {
        logradouro = "Rua teste"
        numero = 1234
        bairro = "Testável"
        cidade = "Teste"
        estado = "SP"
        cep = "12345-000"
        complemento = "Complemento"
        completo()
    }.let { enderecoCompleto ->
        println(enderecoCompleto)
    }
}











