package com.centroacademicoapi.service;

import com.centroacademicoapi.model.Aluno;
import com.centroacademicoapi.model.Disciplina;
import com.centroacademicoapi.model.Matricula;
import com.centroacademicoapi.repository.AlunoRepository;
import com.centroacademicoapi.repository.DisciplinaRepository;
import com.centroacademicoapi.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

//     Cria a matrícula buscando Aluno e Disciplina pelos IDs
    public Matricula matricular(Long idAluno, Long idDisciplina) {
        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado!"));

        Disciplina disciplina = disciplinaRepository.findById(idDisciplina)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada!"));

        Matricula novaMatricula = new Matricula();
        novaMatricula.setAluno(aluno);
        novaMatricula.setDisciplina(disciplina);
        novaMatricula.setNota(0.0);
        novaMatricula.setFaltas(0);

        return matriculaRepository.save(novaMatricula);
    }

    // Atualizar Nota
    public Matricula atualizarNota(Long idMatricula, Double novaNota) {
        Matricula matricula = matriculaRepository.findById(idMatricula)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));

        matricula.setNota(novaNota);
        return matriculaRepository.save(matricula);
    }

    // Atualizar Faltas
    public Matricula atualizarFaltas(Long idMatricula, int novasFaltas) {
        Matricula matricula = matriculaRepository.findById(idMatricula)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));

        matricula.setFaltas(novasFaltas);
        return matriculaRepository.save(matricula);
    }

    public List<Matricula> listarTodas() {
        return matriculaRepository.findAll();
    }
}