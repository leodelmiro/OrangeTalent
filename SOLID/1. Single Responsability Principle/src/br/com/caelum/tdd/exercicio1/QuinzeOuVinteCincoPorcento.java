package br.com.caelum.tdd.exercicio1;

public class QuinzeOuVinteCincoPorcento implements RegraDeCalculo{

    public double calculo(Funcionario funcionario) {
        if (funcionario.getSalarioBase() > 2000.0) {
            return funcionario.getSalarioBase() * 0.75;
        } else {
            return funcionario.getSalarioBase() * 0.85;
        }
    }
}
