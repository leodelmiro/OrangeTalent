package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.Controle;
import br.com.alura.alurator.playground.controle.SubControle;

public class TesteInstanciaObjeto {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<Controle> controleClasse1 = Controle.class;

        SubControle controle = new SubControle();
        Class<? extends Controle> controleClasse2 = controle.getClass();

        Class<?> controleClasse3 = Class.forName("br.com.alura.alurator.playground.controle.Controle");

        Controle objetoControle = controleClasse1.newInstance();

        Object outroObjetoControle = controleClasse3.newInstance();

        System.out.println(objetoControle instanceof Controle);

        System.out.println(outroObjetoControle instanceof Controle);
    }
}
