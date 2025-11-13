package com.centroacademicoapi.repository;

import com.centroacademicoapi.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}