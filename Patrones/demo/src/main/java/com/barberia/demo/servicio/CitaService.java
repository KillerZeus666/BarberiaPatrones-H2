package com.barberia.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barberia.demo.model.Cita;
import com.barberia.demo.repository.CitaRepository;

@Service
public class CitaService {

    private final CitaRepository repo;

    @Autowired
    public CitaService(CitaRepository repo) {
        this.repo = repo;
    }

    public List<Cita> listar() {
        return repo.findAll();
    }

    public Cita guardar(Cita cita) {
        return repo.save(cita);
    }
}
