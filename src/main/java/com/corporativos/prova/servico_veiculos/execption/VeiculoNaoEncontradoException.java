package com.corporativos.prova.servico_veiculos.execption;

public class VeiculoNaoEncontradoException extends RuntimeException{
    public VeiculoNaoEncontradoException(Long id) {
        super("Veiculo não encontrado: " + id);
    }
}
