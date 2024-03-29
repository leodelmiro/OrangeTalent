package br.com.leodelmiro.list

data class Prateleira(
    val genero: String,
    val livros: List<Livro>
) {
    fun organizarPorAutor(): List<Livro> {
        return livros.sortedBy { it.autor }
    }

    fun organizarPorAnoDePublicacao(): List<Livro> {
        return livros.sortedBy { it.anoPublicacao }
    }
}