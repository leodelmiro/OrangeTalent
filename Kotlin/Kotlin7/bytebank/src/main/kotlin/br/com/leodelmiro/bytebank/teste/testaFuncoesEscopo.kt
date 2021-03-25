package br.com.leodelmiro.bytebank.teste

import br.com.leodelmiro.bytebank.modelo.Endereco


fun testaFuncoesEscopo() {
    //    val endereco = Endereco(logradouro = "Rua teste", numero = 1234)
//    val enderecoEmMaisculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println(enderecoEmMaisculo)

    run {
        println("execução do run sem extensão")
    }

    val endereco = Endereco()
        .also {
            println("Criando endereço")
        }
        .apply {
            logradouro = "Rua teste"
            numero = 1234
        }

    with(endereco) {
        "$logradouro, $numero".toUpperCase()
    }.let(::println)

    listOf(
        Endereco(complemento = "casa"),
        Endereco(),
        Endereco(complemento = "Complemento")
    ).filter { endereco ->
        endereco.complemento.isNotEmpty()
    }.let(::println)
}
