package com.centroacademicoapi.service;

import com.centroacademicoapi.model.Aluno;
import com.centroacademicoapi.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // 1. Listar todos os alunos
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    // 2. Buscar um aluno específico pelo ID (para ver detalhes, notas, etc.)
    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    // 3. Salvar (matricular) um novo aluno
    public Aluno salvar(Aluno aluno) {
        // Aqui você poderia colocar uma regra, ex: verificar se o RA já existe
        return alunoRepository.save(aluno);
    }

    // 4. Atualizar dados do aluno
    public Aluno atualizar(Long id, Aluno alunoAtualizado) {
        if (alunoRepository.existsById(id)) {
            alunoAtualizado.setId(id); // Garante que o ID é o mesmo do banco
            return alunoRepository.save(alunoAtualizado);
        } else {
            throw new RuntimeException("Aluno não encontrado com o ID: " + id);
        }
    }

    // 5. Deletar (cancelar matrícula)
    public void deletar(Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Não foi possível deletar. Aluno não encontrado.");
        }
    }
}