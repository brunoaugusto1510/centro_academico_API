package com.centroacademicoapi.repository;

import com.centroacademicoapi.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    // busca matrículas onde o campo 'aluno.id' é igual ao parâmetro
    List<Matricula> findByAlunoId(Long alunoId);
}