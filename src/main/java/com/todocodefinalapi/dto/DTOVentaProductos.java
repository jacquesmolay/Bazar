package com.todocodefinalapi.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DTOVentaProductos {
	
	@Id
	private Long codigo_producto;
	private String nombre;
	private Long codigo_venta;
	@Temporal(TemporalType.DATE)	
	private LocalDate fecha_venta;	
	

}
