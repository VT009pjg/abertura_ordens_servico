package br.com.ordensservico.aberturaordensservico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ordensservico.aberturaordensservico.dto.EquipamentoRequest;
import br.com.ordensservico.aberturaordensservico.model.Equipamento;
import br.com.ordensservico.aberturaordensservico.model.Setor;
import br.com.ordensservico.aberturaordensservico.repository.EquipamentoRepository;
import br.com.ordensservico.aberturaordensservico.repository.SetorRepository;

@Service 
public class EquipamentoService {
   
    
    private final EquipamentoRepository equipamentoRepository;
    private final SetorRepository setorRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository, SetorRepository setorRepository) {
        this.equipamentoRepository = equipamentoRepository;
        this.setorRepository = setorRepository;
    }

    public Optional<Equipamento> cadastrar(EquipamentoRequest equipamento) {
        Optional<Setor> setorEncontrado = setorRepository.findById(equipamento.getSetorId());

        if (setorEncontrado.isEmpty()) {
            return Optional.empty();
        }

        Equipamento equipamentoModel = new Equipamento();

        equipamentoModel.setNome(equipamento.getNome());
        equipamentoModel.setSetor(setorEncontrado.get());
        equipamentoModel.setNumeroPatrimonio(equipamento.getNumeroPatrimonio());
        
        return Optional.of(equipamentoRepository.save(equipamentoModel));
    }

    public List<Equipamento> listar() {
        return equipamentoRepository.findAll();
    }

    public Optional<Equipamento> buscarPorId(Integer id) {
        return equipamentoRepository.findById(id);
    }

    public class alunoService {
    }

    public Optional<Equipamento> atualizar(
            Integer id, EquipamentoRequest novosDados) {

        Optional<Equipamento> equipamentoEncontrado = equipamentoRepository.findById(id);

        if (equipamentoEncontrado.isEmpty()) {
            return Optional.empty();

        }

        Equipamento equipamento = equipamentoEncontrado.get();

        equipamento.setNome(novosDados.getNome());
        equipamento.setNumeroPatrimonio(novosDados.getNumeroPatrimonio());
        return Optional.of(equipamentoRepository.save(equipamento));
    }

    public boolean excluir(Integer id) {

        if (!equipamentoRepository.existsById(id)) {
            return false;
        }

        equipamentoRepository.deleteById(id);
        return true;
    }
} 

