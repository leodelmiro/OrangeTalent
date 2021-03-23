package br.com.leodelmiro.bytebank.modelo

import br.com.leodelmiro.bytebank.exception.FalhaAutenticacaoException
import br.com.leodelmiro.bytebank.exception.SaldoInsuficienteException

abstract class Conta(
    var titular: Cliente,
    val numero: Int
): Autenticavel by titular {
    var saldo = 0.0
        protected set

    companion object {
        var totalContas = 0
            private set
    }

    init {
        totalContas++
    }

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    abstract fun saca(valor: Double)

    fun transfere(valor: Double, destino: Conta, senha: Int) {
        if (saldo < valor) {
            throw SaldoInsuficienteException(mensagem = "O saldo é insuficiente, saldo atual: $saldo")
        }

        if (!autentica(senha)) {
            throw FalhaAutenticacaoException()
        }

        saldo -= valor
        destino.deposita(valor)
    }
}

class ContaCorrente(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {

    override fun saca(valor: Double) {
        val valorComTaxa = valor + 0.1
        if (this.saldo >= valorComTaxa) {
            this.saldo -= valorComTaxa
        }
    }

}

class ContaPoupanca(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        if (this.saldo >= valor) {
            this.saldo -= valor
        }
    }

}