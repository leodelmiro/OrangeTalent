package br.com.leodelmiro.array

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val salarios = bigDecimalArrayOf("1500.55", "2000.0", "5200", "5000")
//    val salarios = Array<BigDecimal>(5) { BigDecimal.ZERO }
//    salarios[0] = "1500.55".toBigDecimal()
//    salarios[1] = "2000.0".toBigDecimal()

    println(salarios.contentToString())

    val aumento = "1.1".toBigDecimal()
    val salariosComAumento = salarios
        .map { salario -> calculaAumentoRelativo(salario, aumento) }
        .toTypedArray()

    println(salariosComAumento.contentToString())
    val gastoInicial = salariosComAumento.somatoria()
    println(gastoInicial)

    val meses = 6.toBigDecimal()

    val gastoTotal = salariosComAumento.fold(gastoInicial) { acumulador, salario ->
        acumulador + (salario * meses).setScale(2, RoundingMode.UP)
    }
    println(gastoTotal)

    val mediaMaioresSalarios = salariosComAumento
        .sorted()
        .takeLast(3)
        .toTypedArray()
        .media()
    println(mediaMaioresSalarios)

    val mediaMenoresSalarios = salariosComAumento
        .sorted()
        .take(3)
        .toTypedArray()
        .media()

    println(mediaMenoresSalarios)

}

private fun calculaAumentoRelativo(
    salario: BigDecimal,
    aumento: BigDecimal
): BigDecimal {
    return if (salario < "5000".toBigDecimal()) {
        salario + "500".toBigDecimal()
    } else {
        (salario * aumento).setScale(2, RoundingMode.UP)
    }
}

