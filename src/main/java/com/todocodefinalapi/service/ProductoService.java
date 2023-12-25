package com.todocodefinalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodefinalapi.model.Producto;
import com.todocodefinalapi.repository.IProductoRepository;

@Service
public class ProductoService implements IProductoService {
	
	@Autowired
	private IProductoRepository prodRepo;

	@Override
	public List<Producto> listProductos() {
		
		return prodRepo.findAll();
	}

	@Override
	public Producto findProducto(Long id_producto_buscar) {
		
		Producto prod=prodRepo.findById(id_producto_buscar).orElse(null);
		return prod;
	}

	@Override
	public void saveProducto(Producto pro) {

		prodRepo.save(pro);

	}

	@Override
	public void deleteProducto(Long id_producto_eliminar) {

		prodRepo.deleteById(id_producto_eliminar);

	}

	@Override
	public void editProducto(Long id_producto, Producto pro) {
		
		Producto prod=this.findProducto(id_producto);
		
		prod.setNombre(pro.getNombre());
		prod.setMarca(pro.getMarca());		
		prod.setCosto(pro.getCosto());
		prod.setCantidad_disponible(pro.getCantidad_disponible());
		
		this.saveProducto(prod);
		

	}

	@Override
	public Producto stockDisponible(Producto stockProducto) {
		
		return null;
	}

}
