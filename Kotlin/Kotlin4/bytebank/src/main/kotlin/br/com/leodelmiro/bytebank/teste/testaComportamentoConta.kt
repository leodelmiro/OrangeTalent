import br.com.leodelmiro.bytebank.exception.FalhaAutenticacaoException
import br.com.leodelmiro.bytebank.exception.SaldoInsuficienteException
import br.com.leodelmiro.bytebank.modelo.Cliente
import br.com.leodelmiro.bytebank.modelo.ContaCorrente
import br.com.leodelmiro.bytebank.modelo.ContaPoupanca

fun testaComportamentosConta() {

    val alex = Cliente(nome = "Alex", cpf = "", senha = 1)

    val contaAlex = ContaCorrente(titular = alex, numero = 1000)
    contaAlex.deposita(200.0)

    val fran = Cliente(nome = "Fran", cpf = "", senha = 2)

    val contaFran = ContaPoupanca(numero = 1001, titular = fran)
    contaAlex.deposita(300.0)

    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println("depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println(contaAlex.saldo)

    println("depositando na conta do Fran")
    contaFran.deposita(70.0)
    println(contaFran.saldo)

    println("sacando na conta do Alex")
    contaAlex.saca(250.0)
    println(contaAlex.saldo)

    println("sacando na conta do Fran")
    contaFran.saca(100.0)
    println(contaFran.saldo)

    println("saque em excesso na conta do Alex")
    contaAlex.saca(100.0)
    println(contaAlex.saldo)

    println("saque em excesso na conta da Fran")
    contaFran.saca(500.0)
    println(contaFran.saldo)

    println("Transferência da conta da Fran para o Alex")

    try {
        contaFran.transfere(50.0, contaAlex, 3)
        println("Transferencia sucedida")
    }
    catch (e: SaldoInsuficienteException) {
        println("Falha na transferencia")
        println(e.message)
    } catch (e: FalhaAutenticacaoException) {
        println("Falha na transferencia")
        println("Falha na autenticação")
        e.printStackTrace()
    } catch (e: Exception) {
        println("Erro desconhecido")
        e.printStackTrace()
    }

    println(contaAlex.saldo)
    println(contaFran.saldo)
}
