package com.todocodefinalapi.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long codigo_venta;		
	
	@Temporal(TemporalType.DATE)	
	private LocalDate fecha_venta;	
	
	private double total;	
	
	@OneToMany
	List<Producto>listaProductos;
	
	@OneToOne
	Cliente unCliente;
}
