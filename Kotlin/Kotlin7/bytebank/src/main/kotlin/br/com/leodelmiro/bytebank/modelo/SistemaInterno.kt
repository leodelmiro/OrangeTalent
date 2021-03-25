package br.com.leodelmiro.bytebank.modelo

class SistemaInterno {

    fun entra(admin: Autenticavel, senha: Int, autenticado: () -> Unit = {}) {
        if (admin.autentica(senha)) {
            println("Bem vindo ao Bytebank")
        } else {
            println("Falha na autenticação")
        }
    }

    fun entraReceiver(admin: Autenticavel, senha: Int, autenticado: SistemaInterno.() -> Unit = {}) {
        if (admin.autentica(senha)) {
            println("Bem vindo ao Bytebank")
            this.autenticado()
        } else {
            println("Falha na autenticação")
        }
    }

    fun pagamento() {
        println("Realizando pagamento")
    }

}