package com.todocodefinalapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


import com.todocodefinalapi.model.Venta;
import com.todocodefinalapi.service.VentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	private VentaService vtaServ;
	
	@GetMapping("/listar_ventas")
	public List<Venta> showVenta(){
		
		return vtaServ.listVentas();
		
	}
	
	@GetMapping("/listar_venta/{id_venta_buscar}")
	public Venta showventa(@PathVariable Long id_venta_buscar) {
		
		return vtaServ.findVenta(id_venta_buscar);
	}
	
	@PostMapping("/crear_venta")
	public String saveVenta(@RequestBody Venta vta) {
		
		vtaServ.saveVenta(vta);
		
		return "Venta Guardada Correctamente";
	}
	
	@PutMapping("/update_venta/{id_codigo_venta_editar}")
	public String editVenta(@PathVariable Long id_codigo_venta_editar,@RequestBody Venta vta){
		
		
		vtaServ.editVenta(id_codigo_venta_editar,vta);
		
		return "Venta Editada Correctamente";
		
	}	
	
	
	@DeleteMapping("/eliminar_venta/{id_venta_buscar}")
	public String borrarVenta(@PathVariable Long id_venta_buscar) {
		
		vtaServ.deleteVenta(id_venta_buscar);
		
		return "Venta Eliminada";
	}

}
