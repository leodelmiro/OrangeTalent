package br.com.caelum.leilao.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LeilaoTest {

    @Test
    public void deveReceberUmLance() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        assertEquals(0, leilao.getLances().size());

        leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));

        assertEquals(1, leilao.getLances().size());
        assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
    }

    @Test
    public void deveReceberVariosLances() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
        leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 3000));

        assertEquals(2, leilao.getLances().size());
        assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
        assertEquals(3000.0, leilao.getLances().get(1).getValor(), 0.00001);
    }

    @Test
    public void deveLancarIllegalArgumentExceptionSeValorForMenorQueZero() {
        assertThrows(IllegalArgumentException.class, () -> {
           new Lance(new Usuario("Joao"), -300 );
        });
    }

    @Test
    public void deveLancarIllegalArgumentExceptionSeValorForIgualA0Zero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Lance(new Usuario("Joao"), 0 );
        });
    }


    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");

        leilao.propoe(new Lance(steveJobs, 2000.0));
        leilao.propoe(new Lance(steveJobs, 3000.0));

        assertEquals(1, leilao.getLances().size());
        assertEquals(2000.0, leilao.getLances().get(0).getValor(), 0.00001);
    }

    @Test
    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");
        Usuario billGates = new Usuario("Bill Gates");

        leilao.propoe(new Lance(steveJobs, 2000.0));
        leilao.propoe(new Lance(billGates, 3000.0));
        leilao.propoe(new Lance(steveJobs, 4000.0));
        leilao.propoe(new Lance(billGates, 5000.0));
        leilao.propoe(new Lance(steveJobs, 6000.0));
        leilao.propoe(new Lance(billGates, 7000.0));
        leilao.propoe(new Lance(steveJobs, 8000.0));
        leilao.propoe(new Lance(billGates, 9000.0));
        leilao.propoe(new Lance(steveJobs, 10000.0));
        leilao.propoe(new Lance(billGates, 11000.0));

        // deve ser ignorado
        leilao.propoe(new Lance(steveJobs, 12000.0));

        assertEquals(10, leilao.getLances().size());
        assertEquals(11000.0, leilao.getLances().get(leilao.getLances().size() - 1).getValor(), 0.00001);
    }

    @Test
    public void deveDobrarLanceDoUsuarioSePropoeForAtendido() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");
        Usuario billGates = new Usuario("Bill Gates");

        leilao.propoe(new Lance(steveJobs, 2000.0));
        leilao.propoe(new Lance(billGates, 3000.0));
        leilao.dobraLance(steveJobs);

        assertEquals(3, leilao.getLances().size());
        assertEquals(4000.0, leilao.getLances().get(leilao.getLances().size() - 1).getValor(), 0.00001);
    }

    @Test
    public void naoDeveDobrarLanceDoUsuarioSeUsuarioTiver5Lances() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");
        Usuario billGates = new Usuario("Bill Gates");

        leilao.propoe(new Lance(steveJobs, 2000.0));
        leilao.propoe(new Lance(billGates, 3000.0));
        leilao.propoe(new Lance(steveJobs, 4000.0));
        leilao.propoe(new Lance(billGates, 5000.0));
        leilao.propoe(new Lance(steveJobs, 6000.0));
        leilao.propoe(new Lance(billGates, 7000.0));
        leilao.propoe(new Lance(steveJobs, 8000.0));
        leilao.propoe(new Lance(billGates, 9000.0));
        leilao.propoe(new Lance(steveJobs, 10000.0));
        leilao.propoe(new Lance(billGates, 11000.0));

        // deve ser ignorado
        leilao.dobraLance(steveJobs);

        assertEquals(10, leilao.getLances().size());
        assertEquals(11000.0, leilao.getLances().get(leilao.getLances().size() - 1).getValor(), 0.00001);
    }

    @Test
    public void naoDeveDobrarLanceDoUsuarioSeUltimoLanceForDoUsuario() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");

        leilao.propoe(new Lance(steveJobs, 2000.0));

        // deve ser ignorado
        leilao.dobraLance(steveJobs);

        assertEquals(1, leilao.getLances().size());
        assertEquals(2000, leilao.getLances().get(leilao.getLances().size() - 1).getValor(), 0.00001);
    }
}
