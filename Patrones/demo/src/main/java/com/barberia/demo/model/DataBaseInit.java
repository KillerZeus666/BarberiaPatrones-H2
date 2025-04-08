package com.barberia.demo.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.barberia.demo.repository.CitaRepository;
import com.barberia.demo.repository.ClienteRepository;

@Component
public class DataBaseInit implements CommandLineRunner {

    private final ClienteRepository clienteRepository;
    private final CitaRepository citaRepository;

    public DataBaseInit(ClienteRepository clienteRepository, CitaRepository citaRepository) {
        this.clienteRepository = clienteRepository;
        this.citaRepository = citaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (clienteRepository.count() == 0 && citaRepository.count() == 0) {
            List<String> nombres = Arrays.asList(
                "Katheryn", "Sofía", "Mateo", "Valentina", "Juan", "Isabella",
                "Andrés", "Camila", "Luis", "Daniela", "Santiago", "Mariana",
                "Carlos", "Laura", "Julián", "Lucía", "Miguel", "Sara", "Tomás", "Ana"
            );

            List<String> correos = Arrays.asList(
                "katheryn@gmail.com", "sofia@gmail.com", "mateo@hotmail.com", "valen@outlook.com",
                "juanp@gmail.com", "isabella@gmail.com", "andres@yahoo.com", "camila@gmail.com",
                "luis@gmail.com", "daniela@hotmail.com", "santi@hotmail.com", "mariana@gmail.com",
                "carlos@gmail.com", "laura@hotmail.com", "julian@correo.com", "lucia@gmail.com",
                "miguel@gmail.com", "sara@outlook.com", "tomas@yahoo.com", "ana@gmail.com"
            );

            List<String> servicios = Arrays.asList(
                "Corte de cabello", "Tinte", "Barba", "Peinado", "Tratamiento capilar",
                "Alisado", "Diseño de cejas", "Depilación", "Manicure", "Pedicure",
                "Masaje relajante", "Masaje facial", "Corte + Barba", "Tinte y Corte",
                "Corte infantil", "Cepillado", "Hidratación capilar", "Plancha", "Rizos", "Peinado elegante"
            );

            for (int i = 0; i < 20; i++) {
                Cliente cliente = new Cliente(nombres.get(i), correos.get(i));
                clienteRepository.save(cliente);

                Cita cita = new Cita();
                cita.setFechaHora(LocalDateTime.now().plusDays(i).withHour(9 + (i % 6)));
                cita.setServicio(servicios.get(i));
                cita.setCliente(cliente);
                citaRepository.save(cita);
            }

            System.out.println("✅ 20 clientes y 20 citas precargados con nombres y correos reales.");
        } else {
            System.out.println("ℹ️ Ya existen datos en la base. No se cargaron nuevos.");
        }
    }
}
