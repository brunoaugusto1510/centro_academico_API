package com.clienteapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clienteapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
