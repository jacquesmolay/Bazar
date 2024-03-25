package com.todocodefinalapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todocodefinalapi.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
@Query("Select pro from Producto pro Where pro.cantidad_disponible<=5")
List<Producto> alertaStock();
	
}
