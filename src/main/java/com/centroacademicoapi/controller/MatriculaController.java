package com.centroacademicoapi.controller;

import com.centroacademicoapi.model.Matricula;
import com.centroacademicoapi.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public List<Matricula> listar() {
        return matriculaService.listarTodas();
    }

    // Exemplo de chamada: POST /matriculas?idAluno=1&idDisciplina=5
    @PostMapping
    public Matricula criarMatricula(@RequestParam Long idAluno, @RequestParam Long idDisciplina) {
        return matriculaService.matricular(idAluno, idDisciplina);
    }

    // Exemplo: PUT /matriculas/1/nota?nota=8.5
    @PutMapping("/{id}/nota")
    public Matricula lancarNota(@PathVariable Long id, @RequestParam Double nota) {
        return matriculaService.atualizarNota(id, nota);
    }

    // Exemplo: PUT /matriculas/1/faltas?faltas=2
    @PutMapping("/{id}/faltas")
    public Matricula lancarFaltas(@PathVariable Long id, @RequestParam int faltas) {
        return matriculaService.atualizarFaltas(id, faltas);
    }
}