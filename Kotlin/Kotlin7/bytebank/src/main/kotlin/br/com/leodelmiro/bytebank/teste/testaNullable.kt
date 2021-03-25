package br.com.leodelmiro.bytebank.teste

import br.com.leodelmiro.bytebank.modelo.Endereco

fun testaNullable() {
    var enderecoNulo: Endereco? = null
    var logradouroNovo: Endereco? = Endereco(logradouro = "Rua")

    println(enderecoNulo?.logradouro?.length)
    println(logradouroNovo?.logradouro?.length)

    enderecoNulo?.let { endereco: Endereco ->
        println(endereco.logradouro)
    }

    enderecoNulo?.let {
        val tamanhoComplemento: Int =
            it.complemento.length ?: throw IllegalStateException("Complemento não pode ser vazio")
        println(tamanhoComplemento)
    }
}
