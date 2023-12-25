package com.todocodefinalapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.todocodefinalapi.dto.DTOVentaProductos;

//creo query nativa de sql
public interface IDTOVentaProductosRepository extends JpaRepository<DTOVentaProductos, Long> {
@Query(value="SELECT "
			+ "producto.codigo_producto, "
			+ "producto.nombre, "
			+ "venta.codigo_venta, "
			+ "venta.fecha_venta "
		+ "FROM "
			+ "producto,"
			+ "venta,"
			+ "venta_lista_productos "
		+ "WHERE "
			+ "venta.codigo_venta=venta_lista_productos.venta_codigo_venta AND "
			+ "producto.codigo_producto = venta_lista_productos.lista_productos_codigo_producto;",nativeQuery=true)
			List<DTOVentaProductos> detalleInventario();

//	se define el metedo detalleInventario para ser agregado a la interface y service DTO
	
}
