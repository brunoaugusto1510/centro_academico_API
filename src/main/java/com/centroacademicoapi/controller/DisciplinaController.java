package com.centroacademicoapi.controller;

import com.centroacademicoapi.model.Disciplina;
import com.centroacademicoapi.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public List<Disciplina> listar() {
        return disciplinaService.listarTodas();
    }

    @PostMapping
    public Disciplina criar(@RequestBody Disciplina disciplina) {
        return disciplinaService.salvar(disciplina);
    }

    @GetMapping("/{id}")
    public Optional<Disciplina> buscar(@PathVariable Long id) {
        return disciplinaService.buscarPorId(id);
    }
}