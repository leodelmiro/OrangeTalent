package br.com.alura.forum.config.validacao;

public class ErroDeFormulárioDTO {

    private String campo;
    private String erro;

    public ErroDeFormulárioDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
