package com.centroacademicoapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String ra; // Registro Acadêmico ou Matrícula

    // Um Aluno pode ter várias matrículas (uma para cada disciplina)
    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculas;

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

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

//    public List<Matricula> getMatriculas() {
//        return matriculas;
//    }
//
//    public void setMatriculas(List<Matricula> matriculas) {
//        this.matriculas = matriculas;
//    }

    public Aluno() {

    }
}