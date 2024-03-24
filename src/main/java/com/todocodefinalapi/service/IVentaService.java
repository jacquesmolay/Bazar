package com.todocodefinalapi.service;

import java.time.LocalDate;
import java.util.List;

import com.todocodefinalapi.model.Cliente;
import com.todocodefinalapi.model.Producto;
import com.todocodefinalapi.model.Venta;

public interface IVentaService {
	
	public List<Venta>listVentas();
	
	public Venta findVenta(Long id_Venta_buscar);
	
	public void saveVenta(Venta vta);
	
	public void deleteVenta(Long id_venta_eliminar);
	
	public void editVenta(Long codigo_venta, Venta vta);
	
	
	
	

	

}
