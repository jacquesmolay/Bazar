package com.todocodefinalapi.service;

import java.util.List;

import com.todocodefinalapi.model.Producto;

public interface IProductoService {
	
	public List<Producto> listProductos();
	
	public Producto findProducto(Long id_producto_buscar);
	
	public void saveProducto(Producto pro);
	
	public void deleteProducto(Long id_producto_eliminar);
	
	public void editProducto(Long id_producto, Producto pro);
	
	//restar cantidad de ventas
	public Producto stockDisponible(Producto stockProducto);
	

}
