package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;


public class TesteJPQLMovimentacaoDeUmaCategoria {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        String sql = "select m from Movimentacao m join m.categorias c  where c = :pCategoria";

        Categoria categoria = new Categoria();
        categoria.setId(2L);

        TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
        query.setParameter("pCategoria", categoria);

        List<Movimentacao> movimentacoes = query.getResultList();
        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Descri��o: " + movimentacao.getDescricao());
            System.out.println("Valor: " + movimentacao.getValor());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
        }
    }
}
