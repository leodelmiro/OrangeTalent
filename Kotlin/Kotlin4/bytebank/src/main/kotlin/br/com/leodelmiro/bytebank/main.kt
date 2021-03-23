import br.com.leodelmiro.bytebank.exception.SaldoInsuficienteException
import br.com.leodelmiro.bytebank.modelo.Endereco
import java.lang.IllegalStateException

fun main() {
    var enderecoNulo: Endereco? = null
    var logradouroNovo: Endereco? = Endereco(logradouro = "Rua")

    println(enderecoNulo?.logradouro?.length)
    println(logradouroNovo?.logradouro?.length)

    enderecoNulo?.let { endereco: Endereco ->
        println(endereco.logradouro)
    }

    enderecoNulo?.let {
        val tamanhoComplemento: Int = it.complemento.length ?: throw IllegalStateException("Complemento não pode ser vazio")
        println(tamanhoComplemento)
    }
}











