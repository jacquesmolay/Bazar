package com.todocodefinalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodefinalapi.dto.DTOVentaProductos;
import com.todocodefinalapi.service.DTOVentaProductosService;

@RestController
@RequestMapping("/stock")
public class DTOVentaProductoController {
	
	@Autowired
	private DTOVentaProductosService DTOVentaProductosRepo;
	
	@GetMapping("/detalle_stock")
	public List<DTOVentaProductos> detalleStockProductos() {
		
		return DTOVentaProductosRepo.detalleInventario();
	}
	

}
