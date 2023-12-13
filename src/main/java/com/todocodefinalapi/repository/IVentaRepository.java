package com.todocodefinalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todocodefinalapi.model.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

}
