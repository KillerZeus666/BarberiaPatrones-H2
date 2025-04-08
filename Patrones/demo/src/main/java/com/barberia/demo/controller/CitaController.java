package com.barberia.demo.controller;

import com.barberia.demo.model.Cita;
import com.barberia.demo.servicio.CitaService;
import com.barberia.demo.servicio.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;
    private final ClienteService clienteService;

    public CitaController(CitaService citaService, ClienteService clienteService) {
        this.citaService = citaService;
        this.clienteService = clienteService;
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("clientes", clienteService.listar());
        return "formCita";
    }

    @PostMapping
    public String guardar(@ModelAttribute Cita cita) {
        citaService.guardar(cita);
        return "redirect:/clientes";
    }
}
