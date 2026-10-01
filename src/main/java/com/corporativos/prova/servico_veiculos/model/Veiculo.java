package com.corporativos.prova.servico_veiculos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "veiculos")
@AllArgsConstructor 
@NoArgsConstructor 
@Data 
public class Veiculo {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String placa;
    private String modelo;
    private int anoFabricacao;
    private String tipo;
    private String nomeProprietario;
}
