package com.corporativos.prova.servico_veiculos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
public class VeiculoResponseDTO {
    private Long id;
    private String placa;
    private String modelo;
    private int anoFabricacao;
    private String tipo;
    private String nomeProprietario;
}
