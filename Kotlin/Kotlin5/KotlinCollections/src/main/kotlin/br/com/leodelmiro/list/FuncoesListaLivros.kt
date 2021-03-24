package br.com.leodelmiro.list


fun List<Livro?>.imprimeComMarcadores() {
    val textoFormado = this
        .filterNotNull()
        .joinToString(separator = "\n") {
        " - ${it.titulo} de ${it.autor}"
    }

    println("#### Lista de Livros #### \n$textoFormado")

}