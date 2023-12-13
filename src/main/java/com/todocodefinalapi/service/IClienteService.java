package com.todocodefinalapi.service;

import java.util.List;

import com.todocodefinalapi.model.Cliente;

public interface IClienteService {
	
	public List<Cliente> listClientes();
	
	public Cliente findCliente(Long id_cliente_buscar);
	
	public void saveCliente(Cliente cli);
	
	public void deleteCliente(Long id_cliente_eliminar);
	
	public void editCliente(Long id_cliente_modificar,Cliente cli);
	
	

}
