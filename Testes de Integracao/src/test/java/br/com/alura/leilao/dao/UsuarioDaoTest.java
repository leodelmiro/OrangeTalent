package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.UsuarioBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsuarioDaoTest {

    private UsuarioDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(em);
        em.getTransaction().begin();
    }

    @After
    public void afterEach() {
        em.getTransaction().rollback();
    }

    @Test
    void deveriaEncontrarUsuarioCadastrado() {
        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678").criar();
        em.persist(usuario);

        Usuario usuarioEncontrado = this.dao.buscarPorUsername(usuario.getNome());
        assertNotNull(usuario);
    }

    @Test
    void naoDeveriaEncontrarUsuarioNaoCadastrado() {
        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678").criar();
        em.persist(usuario);

        Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername("beltrano"));
    }

    @Test
    void deveriaRemoverUsuario() {
        Usuario usuario = new UsuarioBuilder()
                .comNome("Fulano")
                .comEmail("fulano@email.com")
                .comSenha("12345678").criar();
        em.persist(usuario);

        dao.deletar(usuario);

        Assert.assertThrows(NoResultException.class, () -> this.dao.buscarPorUsername(usuario.getNome()));
    }

}
