package com.centroacademicoapi.controller;

import com.centroacademicoapi.model.Aluno;
import com.centroacademicoapi.model.Matricula;
import com.centroacademicoapi.service.AlunoService;
import com.centroacademicoapi.service.MatriculaService;
import com.centroacademicoapi.service.DisciplinaService;
import com.centroacademicoapi.model.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@Hidden
@Controller
public class WebController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private DisciplinaService disciplinaService;

    // Página Inicial (Lista de Alunos)
    @GetMapping("/sistema/alunos")
    public String listarAlunos(Model model) {
        List<Aluno> lista = alunoService.listarTodos();
        model.addAttribute("alunos", lista);
        return "index_aluno";
    }

    // Mostra o formulário de novo aluno
    @GetMapping("/sistema/alunos/novo")
    public String exibirFormularioAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "novo_aluno"; // Nome do novo arquivo HTML
    }

    // Salva o novo aluno
    @PostMapping("/sistema/alunos/novo")
    public String salvarAluno(@ModelAttribute Aluno aluno) {
        alunoService.salvar(aluno); // Reutiliza o método 'salvar' do service
        return "redirect:/sistema/alunos"; // Redireciona para a lista
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

    // Mostra o formulário de edição para uma matrícula específica
    @GetMapping("/sistema/matricula/{id}/editar")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Matricula matricula = matriculaService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));

        model.addAttribute("matricula", matricula);
        return "editar_matricula"; // Nome do novo arquivo HTML
    }

    // Recebe os dados do formulário e salva
    @PostMapping("/sistema/matricula/salvar")
    public String salvarEdicao(@RequestParam Long idMatricula,
                               @RequestParam Long idAluno,
                               @RequestParam double nota,
                               @RequestParam int faltas) {

        matriculaService.salvarEdicao(idMatricula, nota, faltas);

        // Redireciona de volta para o boletim do aluno correto
        return "redirect:/sistema/aluno/" + idAluno + "/boletim";
    }

    @GetMapping("/sistema/disciplinas")
    public String listarDisciplinas(Model model) {
        model.addAttribute("disciplinas", disciplinaService.listarTodas());
        return "disciplinas"; // Novo arquivo HTML: disciplinas.html
    }

    @GetMapping("/sistema/disciplinas/nova")
    public String exibirFormularioDisciplina(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "nova_disciplina"; // Novo arquivo HTML: nova_disciplina.html
    }

    @PostMapping("/sistema/disciplinas/nova")
    public String salvarDisciplina(@ModelAttribute Disciplina disciplina) {
        disciplinaService.salvar(disciplina);
        return "redirect:/sistema/disciplinas";
    }
    
 // Mostra a tela para escolher a disciplina
    @GetMapping("/sistema/aluno/{id}/matricular")
    public String exibirFormularioMatricula(@PathVariable Long id, Model model) {
        // 1. Pega o aluno (para saber quem estamos matriculando)
        Aluno aluno = alunoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        
        // 2. Pega TODAS as disciplinas (para o dropdown)
        List<Disciplina> disciplinas = disciplinaService.listarTodas();

        model.addAttribute("aluno", aluno);
        model.addAttribute("disciplinas", disciplinas);
        
        return "matricular_aluno"; // Nome do novo arquivo HTML
    }

    // Salva a nova matrícula
    @PostMapping("/sistema/matricular")
    public String salvarMatricula(@RequestParam Long idAluno, @RequestParam Long idDisciplina) {
        
        // 1. Reutiliza o serviço que já tínhamos (ele cuida da lógica)
        matriculaService.matricular(idAluno, idDisciplina);
        
        // 2. Redireciona de volta para o boletim do aluno
        return "redirect:/sistema/aluno/" + idAluno + "/boletim";
    }

}