package com.corporativos.prova.servico_veiculos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
public class VeiculoRequestDTO {
    @NotBlank 
    private String placa;
    @NotBlank 
    private String modelo;
    @NotBlank
    private int anoFabricacao;
    @NotBlank 
    private String tipo;
    @NotBlank 
    private String nomeProprietario; 
}
