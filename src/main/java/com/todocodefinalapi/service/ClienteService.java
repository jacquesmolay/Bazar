package com.todocodefinalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodefinalapi.model.Cliente;
import com.todocodefinalapi.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	private IClienteRepository cliRepo;

	@Override
	public List<Cliente> listClientes() {
		// TODO Auto-generated method stub
		return cliRepo.findAll();
	}

	@Override
	public Cliente findCliente(Long id_cliente_buscar) {
		
		Cliente cli=cliRepo.findById(id_cliente_buscar).orElse(null);
		return cli;
	}

	@Override
	public void saveCliente(Cliente cli) {
		
		cliRepo.save(cli);

	}

	@Override
	public void deleteCliente(Long id_cliente_eliminar) {
		
		cliRepo.deleteById(id_cliente_eliminar);

	}

	@Override
	public void editCliente(Long id_cliente_modificar,Cliente clint) {
		
		Cliente cli=this.findCliente(id_cliente_modificar);
		
		cli.setNombre(clint.getNombre());
		cli.setApellido(clint.getApellido());
		cli.setDni(clint.getDni());
		
		this.saveCliente(cli);

	}

}
