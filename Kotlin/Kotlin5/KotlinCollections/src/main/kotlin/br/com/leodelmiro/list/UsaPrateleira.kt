package br.com.leodelmiro.list

fun main() {
    val prateleira = Prateleira(genero = "Literatura", livros = listaDeLivros)

    val organizarPorAutor = prateleira.organizarPorAutor()

    val organizarPorAnoDePublicacao = prateleira.organizarPorAnoDePublicacao()

    organizarPorAutor.imprimeComMarcadores()
    organizarPorAnoDePublicacao.imprimeComMarcadores()
}