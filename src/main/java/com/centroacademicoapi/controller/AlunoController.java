package com.centroacademicoapi.controller;

import com.centroacademicoapi.model.Aluno;
import com.centroacademicoapi.model.Matricula; // Importe Matricula
import com.centroacademicoapi.repository.AlunoRepository;
import com.centroacademicoapi.service.MatriculaService; // Importe o Service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private MatriculaService matriculaService; 

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @GetMapping("/{id}/boletim")
    public List<Matricula> verBoletim(@PathVariable Long id) {
        // Retorna apenas as matrículas daquele aluno específico
        return matriculaService.buscarPorAluno(id);
    }
}