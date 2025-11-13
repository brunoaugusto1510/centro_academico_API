package com.clienteapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clienteapi.model.Cliente;
import com.clienteapi.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> ListarTodos() {
		return clienteRepository.findAll();
	}
	
	public Cliente salvar(com.clienteapi.model.Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void deletar (Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Cliente atualizar(Long id, Cliente cliente) {
		if (clienteRepository.existsById(id)) {
			cliente.setId(id);
			return clienteRepository.save(cliente);
		} else {
			throw new RuntimeException("Cliente não encontrado.");
		}
	}
	
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}
}
