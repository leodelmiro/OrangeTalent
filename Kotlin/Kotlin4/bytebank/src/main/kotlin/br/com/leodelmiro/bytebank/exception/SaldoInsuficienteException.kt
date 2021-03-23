package br.com.leodelmiro.bytebank.exception

class SaldoInsuficienteException(mensagem: String = "O saldo é insuficiente") : Exception(mensagem)