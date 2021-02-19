package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AvaliadorTest {

    private Avaliador leiloeiro;
    private Usuario joao;
    private Usuario jose;
    private Usuario maria;

    @BeforeEach
    public void criaAvaliador() {
        this.leiloeiro = new Avaliador();
        this.joao = new Usuario("João");
        this.jose = new Usuario("José");
        this.maria = new Usuario("Maria");
    }

    @Test
    public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
        assertThrows(RuntimeException.class, () -> {
            Leilao leilao = new CriadorDeLeilao()
                    .para("Playstation 3 Novo")
                    .constroi();

            leiloeiro.avalia(leilao);
        });
    }

    @Test
    public void deveEntenderLancesDeModoCrescente() {
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(jose, 400.0));
        leilao.propoe(new Lance(maria, 250.0));

        leiloeiro.avalia(leilao);

        double maiorEsperado = 400.0;
        double menorEsperado = 250.0;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEntenderLancesDeModoRandomico() {
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 200));
        leilao.propoe(new Lance(jose, 450));
        leilao.propoe(new Lance(maria, 120));

        leiloeiro.avalia(leilao);

        double maiorEsperado = 450;
        double menorEsperado = 120;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEntenderLancesDeModoDecrescente() {
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 400));
        leilao.propoe(new Lance(jose, 300));
        leilao.propoe(new Lance(maria, 200));

        leiloeiro.avalia(leilao);

        double maiorEsperado = 400;
        double menorEsperado = 200;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveCalcularAMedia() {
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria, 300.0));
        leilao.propoe(new Lance(joao, 400.0));
        leilao.propoe(new Lance(jose, 500.0));

        leiloeiro.avalia(leilao);

        assertEquals(400, leiloeiro.getValorMedio(), 0.0001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                .lance(joao, 100.0)
                .lance(maria, 200.0)
                .lance(joao, 300.0)
                .lance(maria, 400.0)
                .constroi();

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());
        assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
        assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
        assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));

        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(2, maiores.size());
        assertEquals(200.0, maiores.get(0).getValor(), 0.00001);
        assertEquals(100.0, maiores.get(1).getValor(), 0.00001);
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance() {
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 1000.0));

        leiloeiro.avalia(leilao);

        assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
    }


}


