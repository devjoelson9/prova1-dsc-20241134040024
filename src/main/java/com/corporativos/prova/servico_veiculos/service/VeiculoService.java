package com.corporativos.prova.servico_veiculos.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.corporativos.prova.servico_veiculos.dto.VeiculoRequestDTO;
import com.corporativos.prova.servico_veiculos.dto.VeiculoResponseDTO;
import com.corporativos.prova.servico_veiculos.model.Veiculo;
import com.corporativos.prova.servico_veiculos.repository.VeiculoRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public List<VeiculoResponseDTO> listar(){
        return veiculoRepository.findAll()
            .stream()
            .map(this::toResponseDTO)
            .toList();
    }

    public VeiculoResponseDTO buscarPorId(Long id){
        Veiculo veiculo = veiculoRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "veiculo não encontrado"));
        return toResponseDTO(veiculo);
    }

    public VeiculoResponseDTO criar(VeiculoRequestDTO dto){
        Veiculo veiculo = veiculoRepository.save(toEntity(dto));
        return toResponseDTO(veiculo);
    }

    public VeiculoResponseDTO atualizar(Long id, VeiculoRequestDTO dto){
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "veiculo não encontrado"));

        veiculo.setPlaca(dto.getPlaca());
        veiculo.setModelo(dto.getModelo());
        veiculo.setAnoFabricacao(dto.getAnoFabricacao());
        veiculo.setTipo(dto.getTipo());
        veiculo.setNomeProprietario(dto.getNomeProprietario());

        Veiculo veiculoAtualizado = veiculoRepository.save(veiculo);
        return toResponseDTO(veiculoAtualizado);
    }
    
    public void deletar(Long id){
        veiculoRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "veiculo não encontrado"));
        veiculoRepository.deleteById(id);
    }

    private Veiculo toEntity(VeiculoRequestDTO dto){
        return new Veiculo(null, dto.getPlaca(), dto.getModelo(), dto.getAnoFabricacao(), dto.getTipo(), dto.getNomeProprietario());
    }

    private VeiculoResponseDTO toResponseDTO(Veiculo veiculo){
        return new VeiculoResponseDTO(veiculo.getId(), veiculo.getPlaca(), veiculo.getModelo(), veiculo.getAnoFabricacao(), veiculo.getTipo(), veiculo.getNomeProprietario());
    }
}
