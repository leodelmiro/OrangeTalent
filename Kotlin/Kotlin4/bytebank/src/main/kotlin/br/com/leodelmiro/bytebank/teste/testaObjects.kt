package br.com.leodelmiro.bytebank.teste

import br.com.leodelmiro.bytebank.modelo.*

fun testaObjects() {
    val fran = object : Autenticavel {
        val nome: String = "Fran"
        val cpf: String = "111.111.111-11"
        val senha: Int = 1000

        override fun autentica(senha: Int) = this.senha == senha
    }

    val sistemaInterno = SistemaInterno()
    sistemaInterno.entra(fran, 1000)
    println("nome do cliente ${fran.nome}")

    val alex = Cliente(nome = "Alex", cpf = "", senha = 1)
    ContaPoupanca(alex, 1)
    ContaPoupanca(alex, 2)

    println("Número total de contas ${Conta.totalContas}")
}
