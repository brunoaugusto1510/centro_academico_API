package com.clienteapi.controller;
import com.clienteapi.model.Cliente;
import com.clienteapi.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Tag(name = "Clientes", description = "Operações básicas com clientes")


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@Operation(summary = "Lista todos os clientes")
	@GetMapping
	public List<Cliente> listarTodos() {
		return clienteService.ListarTodos();
	}
	
	@Operation(summary = "Cadastra um novo cliente")
	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@Operation(summary = "Atualiza um cliente pelo ID")
	@PutMapping("/{id}")
	public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		return clienteService.atualizar(id, cliente);
	}
	
	@Operation(summary = "Exclui um cliente pelo ID")
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		clienteService.deletar(id);
	}
	
	@Operation(summary = "Busca um cliente pelo ID")
	@GetMapping("/{id}")
	public Optional<Cliente> findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}
}
