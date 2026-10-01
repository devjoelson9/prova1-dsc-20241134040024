package com.corporativos.prova.servico_veiculos.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class VeiculoExecptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(VeiculoNaoEncontradoException.class)
    public String VeiculoExecptionHandler(VeiculoNaoEncontradoException ex) {
        return ex.getMessage();
    }
}
