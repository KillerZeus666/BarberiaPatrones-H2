-- Insertar clientes
INSERT INTO cliente (id, nombre, correo, telefono) VALUES (1, 'Carlos Pérez', 'carlos@gmail.com', '1234567890');
INSERT INTO cliente (id, nombre, correo, telefono) VALUES (2, 'Laura Gómez', 'laura@gmail.com', '0987654321');

-- Insertar citas
INSERT INTO cita (id, fecha, hora, servicio, cliente_id) VALUES (1, '2025-04-07', '10:00', 'Corte de cabello', 1);
INSERT INTO cita (id, fecha, hora, servicio, cliente_id) VALUES (2, '2025-04-08', '15:30', 'Afeitado', 2);
