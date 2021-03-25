package br.com.leodelmiro.bytebank.teste

fun testaFuncaoAnonima() {
    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(a, b): Int {
        return a + b
    }
    println(minhaFuncaoAnonima(20, 10))

    val calculaBonificaoAnonima: (salario: Double) -> Double = fun(salario): Double {
        if (salario > 1000.0) {
            return salario + 50
        }
        return salario + 100.0 //poderia também ser return@lambda
    }
    println(calculaBonificaoAnonima(1100.0))
}

fun testaFuncaoLambda() {
    val minhaFuncaoLambda: (Int, Int) -> Int = { a, b ->
        a + b
    }
    println(minhaFuncaoLambda(15, 20))

    val calculaBonificao: (salario: Double) -> Double = lambda@{ salario ->
        if (salario > 1000.0) {
            return@lambda salario + 50
        }
        salario + 100.0 //poderia também ser return@lambda
    }

    println(calculaBonificao(500.0))
}

fun testaTipoFuncaoClasse() {
    val minhaFuncaoClasses: (Int, Int) -> Int = Soma()
    println(minhaFuncaoClasses(15, 20))
}

fun testaTipoFuncaoReferencia() {
    val minhaFuncao: (Int, Int) -> Int = ::soma
    println(minhaFuncao(5, 10))
}

fun soma(a: Int, b: Int): Int {
    return a + b
}

class Soma : (Int, Int) -> Int {
    override fun invoke(a: Int, b: Int): Int = a + b

}

