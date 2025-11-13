package com.centroacademicoapi.service;

import com.centroacademicoapi.model.Disciplina;
import com.centroacademicoapi.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listarTodas() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarPorId(Long id) {
        return disciplinaRepository.findById(id);
    }

    public Disciplina salvar(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizar(Long id, Disciplina disciplinaAtualizada) {
        if (disciplinaRepository.existsById(id)) {
            disciplinaAtualizada.setId(id);
            return disciplinaRepository.save(disciplinaAtualizada);
        }
        return null; // Ou lançar exceção
    }

    public void deletar(Long id) {
        disciplinaRepository.deleteById(id);
    }
}