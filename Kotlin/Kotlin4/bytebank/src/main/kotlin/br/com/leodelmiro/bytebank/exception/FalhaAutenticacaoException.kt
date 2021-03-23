package br.com.leodelmiro.bytebank.exception

class FalhaAutenticacaoException(
    mensagem: String = "Falha na autenticação"
) : Exception(mensagem)