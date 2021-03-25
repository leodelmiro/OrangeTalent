package br.com.leodelmiro.bytebank.teste

import br.com.leodelmiro.bytebank.modelo.Endereco

fun testaAny() {
    val endereco = Endereco(
        logradouro = "Rua",
        numero = 30,
        bairro = "Bairro",
        cidade = "Cidade",
        estado = "SP",
        cep = "12345-000",
        complemento = "Casa"
    )

    val endereco2 = Endereco(
        logradouro = "Rua",
        numero = 30,
        bairro = "Bairro",
        cidade = "Cidade",
        estado = "SP",
        cep = "12345-000",
        complemento = "Casa"
    )

    imprime(endereco)
    imprime(endereco == endereco2)
}

fun imprime(valor: Any): Any{
    println(valor)
    return valor
}