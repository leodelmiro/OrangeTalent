package br.com.leodelmiro.array

fun main() {
    val serie: IntRange = 1.rangeTo(10);
    for (s in serie) {
        print("$s ")
    }

    println()

    val numerosPares = 0..100 step 2
    for (numeroPar in numerosPares) {
        print("$numeroPar ")
    }

    println()

    val numerosParesReverso = 100 downTo 0 step 2
    numerosParesReverso.forEach{
        print("$it ")
    }

    println()

    val intervalo = 1500.0..5000.0
    val salario = 4000.0
    if (salario in intervalo) {
        println("Está dentro do intervalo")
    } else {
        println("Não está dentro do intervalo")
    }

    val alfabeto = 'a'..'z'
    val letra = 'K'
    if (letra in alfabeto) {
        println("Está dentro do intervalo")
    }
}