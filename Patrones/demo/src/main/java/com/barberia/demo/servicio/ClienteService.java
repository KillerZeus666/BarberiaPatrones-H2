package com.barberia.demo.servicio;


import com.barberia.demo.model.Cliente;
import com.barberia.demo.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente guardar(Cliente cliente) {
        return repo.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }
}
