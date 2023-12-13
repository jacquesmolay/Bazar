package com.todocodefinalapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todocodefinalapi.model.Producto;
import com.todocodefinalapi.service.ProductoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService proServ;
	
	@GetMapping("/listar_productos")
	public List<Producto> showProducts(){
		
		return proServ.listProductos();
		
	}
	
	
	@GetMapping("/listar_product/{id_buscar_producto}")
	public Producto showProduct(@PathVariable Long id_buscar_producto ) {
		
		return proServ.findProducto(id_buscar_producto);
	}
	
	@PostMapping("/crear_producto")
	public String saveProducto(@RequestBody Producto prod) {
		
		proServ.saveProducto(prod);
		return "Producto Grabado con Exito";
		
	}
	
	@PutMapping("/update_producto/{id_producto_editar}")
	public String editProducto(@PathVariable Long id_producto_editar,@RequestBody Producto pro ) {
				
		proServ.editProducto(id_producto_editar,pro );
		
		
		return "Producto Modificado";
		
	}
	
	@DeleteMapping("/eliminar_producto/{id_producto_eliminar}")
	public String deleteProducto(@PathVariable Long id_producto_eliminar) {
		
		proServ.deleteProducto(id_producto_eliminar);
		return "producto eliminado";
		
	}
	
	

}
