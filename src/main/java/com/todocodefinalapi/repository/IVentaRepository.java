package com.todocodefinalapi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.todocodefinalapi.model.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {
@Query("Select vent from Venta vent Where vent.fecha_venta=:venta_fecha")
//tuve que gregar param para que lo tomara
List<Venta> cierreDia(@Param("venta_fecha") LocalDate venta_fecha);
}
