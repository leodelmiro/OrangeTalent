package br.com.leodelmiro.bytebank.modelo

interface Autenticavel {

    fun autentica(senha: Int): Boolean
}