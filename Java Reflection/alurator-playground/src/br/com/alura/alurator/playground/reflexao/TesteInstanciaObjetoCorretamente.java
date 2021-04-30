package br.com.alura.alurator.playground.reflexao;

import br.com.alura.alurator.playground.controle.SubControle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TesteInstanciaObjetoCorretamente {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Class<SubControle> subControleClasse1 = SubControle.class;

        Class<?> subControleClasse2 = Class.forName("br.com.alura.alurator.playground.controle.SubControle");

        Class<?> controleClasse1 = Class.forName("br.com.alura.alurator.playground.controle.Controle");

        try {
            controleClasse1.getConstructor().newInstance(); //somos obrigados a tratar exceções
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println(e.getTargetException());
        }

        controleClasse1.newInstance(); //nao avisa da exceção

//        Constructor<SubControle> construtorSubControle = subControleClasse1.getConstructor(); //só publicos
//        Constructor<SubControle> construtorComArgsSubControle = subControleClasse1.getDeclaredConstructor(String.class);
//
//        System.out.println(construtorSubControle);
//        System.out.println(construtorComArgsSubControle);
//
//        construtorComArgsSubControle.setAccessible(true);
//        Object subControle = construtorComArgsSubControle.newInstance("privado");
//
//        System.out.println(subControle);
    }
}
