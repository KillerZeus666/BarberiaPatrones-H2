package com.barberia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barberia.demo.model.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}
