package br.com.leodelmiro.bytebank.teste

import br.com.leodelmiro.bytebank.exception.SaldoInsuficienteException

fun funcao1() {
    println("início funcao1")
    try {
        funcao2()
    } catch (e: SaldoInsuficienteException) {
        println("SaldoInsuficienteException foi pega")
        println(e.message)
        println(e.stackTrace)
        println(e.cause)
        e.printStackTrace()
    }
    println("fim funcao1")
}

fun funcao2() {
    println("início funcao2")
    for (i in 1..5) {
        println(i)
        throw SaldoInsuficienteException()
    }
    println("fim funcao2")
}



