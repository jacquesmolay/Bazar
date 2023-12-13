package com.todocodefinalapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodefinalapi.model.Cliente;
import com.todocodefinalapi.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService cliServ;
	
	@GetMapping("/listar_cliente")
	public List<Cliente>showClients(){
		
		return cliServ.listClientes();
	}
	
	
	@GetMapping("/listar_client/{id_cliente_buscar}")
	public Cliente showCliente(@PathVariable Long id_cliente_buscar) {
		
		return cliServ.findCliente(id_cliente_buscar);
		
	}
	
	
	@PostMapping("/crear_cliente")
	public String saveClient(@RequestBody Cliente cli) {
		
		cliServ.saveCliente(cli);
		
		return "Cliente Creado exitosamente";
		
	}
	
	@PutMapping("/update_cliente/{id_cliente_modificar}")
	public String updateCliente(@PathVariable Long id_cliente_modificar,@RequestBody Cliente cli) {
		
		cliServ.editCliente(id_cliente_modificar, cli);
		
		return "Cliente Editado exitosamente";
	}
	
	
	@DeleteMapping("/eliminar_cliente/{id_cliente_eliminar}")
	public String deleteClient(@PathVariable Long id_cliente_eliminar) {
		
		cliServ.deleteCliente(id_cliente_eliminar);
		
		return "Cliente Eliminado Correctamente";
		
	}

}
