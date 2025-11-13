package com.centroacademicoapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String professor;
    private int semestre;

    // Uma Disciplina pode ter vários alunos matriculados
    @OneToMany(mappedBy = "disciplina")
    private List<Matricula> matriculas;


    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

//    public List<Matricula> getMatriculas() {
//        return matriculas;
//    }
//
//    public void setMatriculas(List<Matricula> matriculas) {
//        this.matriculas = matriculas;
//    }


    public Disciplina() {

    }
}