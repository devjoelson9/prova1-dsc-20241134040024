package com.corporativos.prova.servico_veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corporativos.prova.servico_veiculos.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
    
}
