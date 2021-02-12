package br.com.alura.solid;

public class NotaFiscalDao implements AcaoAposGerarNota {

    public void executa(NotaFiscal nf) {
        System.out.println("salva nf no banco");
    }
}
