package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Resposta;

import java.time.LocalDateTime;

public class RespostaDTO {

    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;

    public RespostaDTO(Resposta resposta) {
        id = resposta.getId();
        mensagem = resposta.getMensagem();
        dataCriacao = resposta.getDataCriacao();
        nomeAutor = resposta.getAutor().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }
}
