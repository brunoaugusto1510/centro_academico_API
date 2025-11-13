package com.centroacademicoapi.controller;

import com.centroacademicoapi.model.Aluno;
import com.centroacademicoapi.model.Matricula;
import com.centroacademicoapi.service.AlunoService;
import com.centroacademicoapi.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller // Note que NÃO é RestController
public class WebController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private MatriculaService matriculaService;

    // Página Inicial (Lista de Alunos)
    @GetMapping("/sistema/alunos")
    public String listarAlunos(Model model) {
        List<Aluno> lista = alunoService.listarTodos();
        // "addAttribute" manda dados do Java para o HTML
        model.addAttribute("alunos", lista);
        return "alunos"; // Vai procurar o arquivo alunos.html
    }

    // Página de Boletim de um Aluno
    @GetMapping("/sistema/aluno/{id}/boletim")
    public String verBoletim(@PathVariable Long id, Model model) {
        // Busca o aluno para mostrar o nome dele na tela
        Aluno aluno = alunoService.buscarPorId(id).orElse(null);

        // Busca as matrículas dele
        List<Matricula> matriculas = matriculaService.buscarPorAluno(id);

        model.addAttribute("aluno", aluno);
        model.addAttribute("matriculas", matriculas);

        return "boletim"; // Vai procurar o arquivo boletim.html
    }
}