package br.com.caelum.tdd.exercicio1;

public class DezOuVintePorcento implements RegraDeCalculo{

    public double calculo(Funcionario funcionario) {
        if (funcionario.getSalarioBase() > 3000.0) {
            return funcionario.getSalarioBase() * 0.8;
        } else {
            return funcionario.getSalarioBase() * 0.9;
        }
    }
}
