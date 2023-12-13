package com.todocodefinalapi.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodefinalapi.model.Cliente;
import com.todocodefinalapi.model.Producto;
import com.todocodefinalapi.model.Venta;
import com.todocodefinalapi.repository.IVentaRepository;

@Service
public class VentaService implements IVentaService {
	
	@Autowired
	private IVentaRepository vtaRepo;

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
		
		vtaRepo.save(vta);

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
