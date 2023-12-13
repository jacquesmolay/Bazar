package com.todocodefinalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todocodefinalapi.model.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
