package com.todocodefinalapi.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todocodefinalapi.model.Producto;
import com.todocodefinalapi.model.Venta;
import com.todocodefinalapi.repository.IProductoRepository;
import com.todocodefinalapi.repository.IVentaRepository;

@Service
public class VentaService implements IVentaService {
	
	@Autowired
	private IVentaRepository vtaRepo;
	
	@Autowired
	private ProductoService proServ;

	@Override
	public List<Venta> listVentas() {
		return vtaRepo.findAll();
	}

	@Override
	public Venta findVenta(Long id_Venta_buscar) {
		
		Venta vta=vtaRepo.findById(id_Venta_buscar).orElse(null);
		return vta;
	}

	
	@Override
	public void saveVenta(Venta vta) {
		
		//lista que contiene productos de la venta
		List<Long>codigos=new ArrayList<Long>();
		List<Long>contado=new ArrayList<Long>();
		boolean repetido=false;
				
		Producto producto_buscar;
		
		//vta es la venta		
		int ventas=0;
		long producto_venta=0;		
			
		
		//recorro venta a grabar, con lista de productos
		
		for(int i=0;i<vta.getListaProductos().size();i++) {
		
		//almaceno la lista de codigos en otra lista	
		 codigos.add(vta.getListaProductos().get(i).getCodigo_producto());
						
		}
		
		//recorro lista codigos que tiene todos los productos de la venta
		for(int i=0;i<codigos.size();i++) {
			
			//el codigo lo guardo en contado
			contado.add(codigos.get(i));
			
			//sumo la venta
			ventas=ventas+1;
			//producto venta guardo el codigo del producto
			producto_venta=contado.get(0);
			//busco el producto
			producto_buscar=proServ.findProducto(producto_venta);
			//resto las ventas
			producto_buscar.setCantidad_disponible(producto_buscar.getCantidad_disponible()-ventas);
				
			//valido si despues del descuento el stock es mayor o igual a cero
				if (producto_buscar.getCantidad_disponible()>=0) {
					
					//si es asi hago el descuento y la modificacion
					proServ.editProducto(producto_buscar.getCodigo_producto(), producto_buscar);
					System.out.println(codigos);
					vtaRepo.save(vta);					
					
				}else {
					
					//si no, indico que no esxiste stock de ese producto
					System.out.println("Producto "+producto_buscar.getNombre()+" "+"sin stock");
				}
				
				//ventas es igual a cero y borro el unico objeto de la lista
				ventas=0;
				contado.remove(0);					
			
		}

	}

	@Override
	public void deleteVenta(Long id_venta_eliminar) {
		
		vtaRepo.deleteById(id_venta_eliminar);

	}

	@Override
	public void editVenta(Long codigo_venta, Venta vnta) {
		
		Venta vta=this.findVenta(codigo_venta);
		
		
		vta.setFecha_venta(vnta.getFecha_venta());
		vta.setTotal(vnta.getTotal());
		
		vta.setListaProductos(vnta.getListaProductos());
		
		vta.setUnCliente(vnta.getUnCliente());
		
		this.saveVenta(vta);

	}

	

}
