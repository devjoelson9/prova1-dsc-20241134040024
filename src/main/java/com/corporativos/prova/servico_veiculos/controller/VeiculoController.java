package com.corporativos.prova.servico_veiculos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corporativos.prova.servico_veiculos.dto.VeiculoRequestDTO;
import com.corporativos.prova.servico_veiculos.dto.VeiculoResponseDTO;
import com.corporativos.prova.servico_veiculos.service.VeiculoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/veiculos")
@RequiredArgsConstructor 
public class VeiculoController {
    private final VeiculoService veiculoService;

    @GetMapping 
    public ResponseEntity<List<VeiculoResponseDTO>> listarVeiculos(){
        return ResponseEntity.ok().body(veiculoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> buscarPorId(@Valid @PathVariable Long id){
        VeiculoResponseDTO veiculo = veiculoService.buscarPorId(id);
        return ResponseEntity.ok().body(veiculo);
    }

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> salvar(@Valid @RequestBody VeiculoRequestDTO dto){
        var veiculo = veiculoService.criar(dto);
        var uri = URI.create("/veiculos/" + veiculo.getId());
        return ResponseEntity.created(uri).body(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> atualizar(@PathVariable Long id,@Valid @RequestBody VeiculoRequestDTO veiculo){
        VeiculoResponseDTO atualizado = veiculoService.atualizar(id, veiculo);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        veiculoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
