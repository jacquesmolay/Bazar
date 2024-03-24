package com.todocodefinalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.todocodefinalapi.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
	

}
