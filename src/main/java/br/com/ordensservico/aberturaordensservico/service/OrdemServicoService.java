package br.com.ordensservico.aberturaordensservico.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ordensservico.aberturaordensservico.dto.OrdemServicoRequest;
import br.com.ordensservico.aberturaordensservico.model.Equipamento;
import br.com.ordensservico.aberturaordensservico.model.OrdemServico;
import br.com.ordensservico.aberturaordensservico.repository.EquipamentoRepository;
import br.com.ordensservico.aberturaordensservico.repository.OrdemServicoRepository;

@Service 
public class OrdemServicoService {
    
    private final EquipamentoRepository equipamentoRepository;
    private final OrdemServicoRepository ordemServicoRepository;

    public OrdemServicoService(EquipamentoRepository equipamentoRepository, OrdemServicoRepository ordemServicoRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.ordemServicoRepository = ordemServicoRepository;
    }

    public Optional<OrdemServico> cadastrar(OrdemServicoRequest dto) {
        if (dto.getEquipamentoId() == null) {
            return Optional.empty();
        }

        Optional<Equipamento> equipamentoEncontrado = equipamentoRepository.findById(dto.getEquipamentoId());

        if (equipamentoEncontrado.isEmpty()) {
            return Optional.empty();
        }

        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setDescricao(dto.getDescricao());
        ordemServico.setEquipamento(equipamentoEncontrado.get());
        ordemServico.setDataAbertura(LocalDateTime.now());
        
        return Optional.of(ordemServicoRepository.save(ordemServico));
    }

    public Iterable<OrdemServico> listar() {
        return ordemServicoRepository.findAll();
    }

    public Optional<OrdemServico> buscarPorId(Integer id) {
        return ordemServicoRepository.findById(id);
    }
}