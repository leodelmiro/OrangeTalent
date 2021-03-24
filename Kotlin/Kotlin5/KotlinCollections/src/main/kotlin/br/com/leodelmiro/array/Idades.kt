package br.com.leodelmiro.array

fun main() {
    val idades = intArrayOf(10,12,18,33,40,67)
    val maiorIdade = idades.maxOrNull()
    // val maiorIdade = idades.max() MAX deprecated
    println("Maior idade: $maiorIdade")

    val menorIdade = idades.minOrNull()
    // val menorIdade = idades.min() MIN deprecated
    println("Menor idade: $menorIdade")

    val media = idades.average()
    println("Idade média: $media")

    val todosMaiores = idades.all { it >= 18 }
    println("Todos maiores? $todosMaiores")

    val existeMaior = idades.any { it >= 18 }
    println("Algum aluxo é maior de idade? $existeMaior")

    val maiores = idades.filter {  it >= 18 }
    println("Maiores:  $maiores")

    val busca = idades.find {  it >= 18 }
    println("Maiores:  $busca")
}