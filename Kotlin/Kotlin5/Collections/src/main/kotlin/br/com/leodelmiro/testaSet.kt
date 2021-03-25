package br.com.leodelmiro

fun testaSet() {
    //    val assistiramCursoAndroid = listOf("Alex", "Fran", "Gui", "Maria")
    val assistiramCursoAndroid: Set<String> = setOf("Alex", "Fran", "Gui", "Maria")
//    val assistiramCursoKotlin = listOf("Alex", "Paulo", "Maria")
    val assistiramCursoKotlin: Set<String> = setOf("Alex", "Paulo", "Maria")
//    val assistiramAmbos = assistiramCursoAndroid + assistiramCursoKotlin

    val assistiramAmbos = mutableSetOf<String>()
    assistiramAmbos.addAll(assistiramCursoAndroid)
    assistiramAmbos.addAll(assistiramCursoKotlin)
    assistiramAmbos.add("Ana")
    assistiramAmbos.add("Ana")
//    println(assistiramAmbos.distinct())
    println(assistiramAmbos)

    println(assistiramCursoKotlin + assistiramCursoAndroid)
    println(assistiramCursoKotlin union assistiramCursoAndroid)

    println(assistiramCursoAndroid - assistiramCursoKotlin)
//    println(assistiramCursoKotlin subtract assistiramCursoKotlin)
    println(assistiramCursoAndroid subtract assistiramCursoKotlin)

    println(assistiramCursoAndroid intersect assistiramCursoKotlin)

    val assistiramList = assistiramAmbos.toMutableList()
    assistiramList.add("Alex")
    println(assistiramList)
    println(assistiramList.toSet())
}
