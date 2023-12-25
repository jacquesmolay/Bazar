package com.todocodefinalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodefinalapi.dto.DTOVentaProductos;
import com.todocodefinalapi.repository.IDTOVentaProductosRepository;

@Service
public class DTOVentaProductosService implements IDTOVentaProductosService{
	
	@Autowired
	private IDTOVentaProductosRepository dtoVentaProductorepo; 

	@Override
	public List<DTOVentaProductos> detalleInventario() {
		// TODO Auto-generated method stub
		
		List<DTOVentaProductos> listadoDetalle=dtoVentaProductorepo.detalleInventario();
		return listadoDetalle;
	}

}
