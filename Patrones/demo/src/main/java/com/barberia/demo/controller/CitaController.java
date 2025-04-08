package com.barberia.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barberia.demo.model.Cita;
import com.barberia.demo.servicio.CitaService;
import com.barberia.demo.servicio.ClienteService;

@Controller
@RequestMapping("/citas")
public class CitaController {

    private final CitaService citaService;
    private final ClienteService clienteService;

    public CitaController(CitaService citaService, ClienteService clienteService) {
        this.citaService = citaService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("citas", citaService.listar()); // ✅ Usar la instancia correcta
        return "citas";
    }
    

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("clientes", clienteService.listar());
        return "formCita";
    }

    @PostMapping
    public String guardar(@ModelAttribute Cita cita) {
        Long clienteId = cita.getCliente().getId();
        cita.setCliente(clienteService.buscarPorId(clienteId));
        citaService.guardar(cita);
        return "redirect:/citas";
    }
    

}
