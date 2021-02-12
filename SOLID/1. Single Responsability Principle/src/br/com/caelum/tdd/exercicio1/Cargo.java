package br.com.caelum.tdd.exercicio1;

public enum Cargo {
    DESENVOLVEDOR(new DezOuVintePorcento()),
    DBA(new QuinzeOuVinteCincoPorcento()),
    TESTER(new QuinzeOuVinteCincoPorcento());

    private RegraDeCalculo regraDeCalculo;

    Cargo(RegraDeCalculo regraDeCalculo) {
        this.regraDeCalculo = regraDeCalculo;
    }

    public RegraDeCalculo getRegraDeCalculo() {
        return regraDeCalculo;
    }

}
