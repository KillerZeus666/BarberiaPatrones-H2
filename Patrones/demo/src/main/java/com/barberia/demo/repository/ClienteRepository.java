package com.barberia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barberia.demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
