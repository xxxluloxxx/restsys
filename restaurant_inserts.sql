-- Inserts para la tabla general (parámetros del sistema)
INSERT INTO general (parametro, valor, descripcion) VALUES
('nombre_empresa', 'Restaurante El Buen Sabor', 'Nombre del restaurante'),
('ruc', '20123456789', 'RUC del restaurante'),
('direccion', 'Av. Principal 123, Lima', 'Dirección del restaurante'),
('telefono', '+51 123-4567', 'Teléfono principal'),
('email', 'contacto@elbuensabor.com', 'Email de contacto'),
('horario_apertura', '08:00', 'Hora de apertura'),
('horario_cierre', '22:00', 'Hora de cierre'),
('impresora_ticket', 'EPSON-TM-T20', 'Impresora para tickets'),
('impresora_cocina', 'EPSON-TM-T20-COCINA', 'Impresora para órdenes de cocina'),
('iva', '18', 'Porcentaje de IVA'),
('moneda', 'PEN', 'Moneda del sistema'),
('redondeo', '0.01', 'Redondeo para cálculos'),
('logo_url', 'https://elbuensabor.com/logo.png', 'URL del logo'),
('facebook_url', 'https://facebook.com/elbuensabor', 'URL de Facebook'),
('instagram_url', 'https://instagram.com/elbuensabor', 'URL de Instagram'),
('whatsapp', '+51 987-654321', 'WhatsApp de contacto'),
('delivery', 'true', 'Si ofrece servicio de delivery'),
('delivery_minimo', '30.00', 'Monto mínimo para delivery'),
('delivery_costo', '5.00', 'Costo de delivery'),
('reservas_online', 'true', 'Si acepta reservas online'),
('max_personas_reserva', '20', 'Máximo de personas por reserva'),
('tiempo_anticipacion_reserva', '24', 'Horas de anticipación para reservas'),
('politica_cancelacion', '24 horas antes', 'Política de cancelación'),
('metodos_pago', 'efectivo,tarjeta,yape,plin', 'Métodos de pago aceptados'),
('politica_propina', '10', 'Porcentaje sugerido de propina'),
('tiempo_espera_pedido', '20', 'Tiempo estimado de espera en minutos'),
('politica_consumo_minimo', 'true', 'Si tiene consumo mínimo'),
('consumo_minimo', '20.00', 'Monto de consumo mínimo'),
('politica_estacionamiento', 'Gratis para clientes', 'Política de estacionamiento'),
('capacidad_maxima', '100', 'Capacidad máxima del restaurante');

-- Inserts para la tabla roles
INSERT INTO roles (nombre, descripcion, estado) VALUES
('Administrador', 'Acceso total al sistema', true),
('Mesero', 'Gestión de pedidos y mesas', true),
('Cajero', 'Gestión de pagos y facturación', true),
('Cocinero', 'Gestión de órdenes de cocina', true),
('Supervisor', 'Supervisión de operaciones', true),
('Gerente', 'Gestión administrativa', true),
('Recepcionista', 'Gestión de reservas y recepción', true),
('Barman', 'Gestión de bebidas y bar', true),
('Limpieza', 'Gestión de limpieza y mantenimiento', true),
('Delivery', 'Gestión de entregas a domicilio', true),
('Auxiliar', 'Apoyo general en operaciones', true),
('Contador', 'Gestión contable y financiera', true),
('Marketing', 'Gestión de marketing y promociones', true),
('Soporte', 'Soporte técnico del sistema', true),
('Auditor', 'Auditoría de operaciones', true);

-- Inserts para la tabla permisos
INSERT INTO permisos (nombre, descripcion, estado) VALUES
('ver_mesas', 'Ver listado de mesas', true),
('gestionar_mesas', 'Gestionar mesas', true),
('ver_pedidos', 'Ver listado de pedidos', true),
('gestionar_pedidos', 'Gestionar pedidos', true),
('ver_productos', 'Ver listado de productos', true),
('gestionar_productos', 'Gestionar productos', true),
('ver_reservas', 'Ver listado de reservas', true),
('gestionar_reservas', 'Gestionar reservas', true),
('ver_reportes', 'Ver reportes', true),
('gestionar_usuarios', 'Gestionar usuarios', true),
('gestionar_roles', 'Gestionar roles y permisos', true),
('gestionar_configuracion', 'Gestionar configuración del sistema', true),
('ver_estadisticas', 'Ver estadísticas y métricas', true),
('gestionar_pagos', 'Gestionar pagos y facturación', true),
('gestionar_inventario', 'Gestionar inventario', true),
('gestionar_cocina', 'Gestionar órdenes de cocina', true),
('gestionar_bar', 'Gestionar bar y bebidas', true),
('gestionar_delivery', 'Gestionar entregas a domicilio', true),
('gestionar_promociones', 'Gestionar promociones y descuentos', true),
('gestionar_facturacion', 'Gestionar facturación electrónica', true),
('gestionar_proveedores', 'Gestionar proveedores', true),
('gestionar_empleados', 'Gestionar empleados', true),
('gestionar_horarios', 'Gestionar horarios de trabajo', true),
('gestionar_salarios', 'Gestionar salarios y remuneraciones', true),
('gestionar_mantenimiento', 'Gestionar mantenimiento del local', true),
('gestionar_publicidad', 'Gestionar publicidad y marketing', true),
('gestionar_quejas', 'Gestionar quejas y reclamos', true),
('gestionar_encuestas', 'Gestionar encuestas de satisfacción', true),
('gestionar_auditoria', 'Gestionar auditoría y registros', true),
('gestionar_backup', 'Gestionar respaldo de datos', true);

-- Inserts para la tabla administradores
INSERT INTO administradores (tipo_documento, numero_documento, nombre, apellido, email, password, estado, ultimo_acceso) VALUES
('DNI', '12345678', 'Juan', 'Pérez', 'juan.perez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '23456789', 'María', 'García', 'maria.garcia@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '34567890', 'Carlos', 'López', 'carlos.lopez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '45678901', 'Ana', 'Martínez', 'ana.martinez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '56789012', 'Pedro', 'Sánchez', 'pedro.sanchez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '67890123', 'Laura', 'Rodríguez', 'laura.rodriguez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '78901234', 'Roberto', 'Fernández', 'roberto.fernandez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '89012345', 'Carmen', 'González', 'carmen.gonzalez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '90123456', 'José', 'Ramírez', 'jose.ramirez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '01234567', 'Isabel', 'Torres', 'isabel.torres@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '12345670', 'Miguel', 'Ruiz', 'miguel.ruiz@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '23456701', 'Sofia', 'Díaz', 'sofia.diaz@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '34567012', 'David', 'Moreno', 'david.moreno@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '45670123', 'Elena', 'Jiménez', 'elena.jimenez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP),
('DNI', '56701234', 'Francisco', 'Paredes', 'francisco.paredes@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP);

-- Inserts para la tabla usuarios
INSERT INTO usuarios (tipo_documento, numero_documento, nombre, apellido, email, password, estado, ultimo_acceso, rol_id) VALUES
('DNI', '12345671', 'Luis', 'Hernández', 'luis.hernandez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '23456702', 'Ana', 'Castro', 'ana.castro@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '34567013', 'Roberto', 'Vargas', 'roberto.vargas@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '45670124', 'María', 'Silva', 'maria.silva@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '56701235', 'Carlos', 'Rojas', 'carlos.rojas@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '67890126', 'Laura', 'Mendoza', 'laura.mendoza@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '78901237', 'Pedro', 'Flores', 'pedro.flores@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '89012348', 'Carmen', 'Espinoza', 'carmen.espinoza@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '90123459', 'José', 'Valdez', 'jose.valdez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '01234560', 'Isabel', 'Ramos', 'isabel.ramos@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '12345661', 'Miguel', 'Gutiérrez', 'miguel.gutierrez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '23456712', 'Sofia', 'Cortez', 'sofia.cortez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '34567023', 'David', 'Núñez', 'david.nunez@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '45670134', 'Elena', 'Molina', 'elena.molina@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2),
('DNI', '56701245', 'Francisco', 'Herrera', 'francisco.herrera@elbuensabor.com', '$2a$10$abcdefghijklmnopqrstuv', true, CURRENT_TIMESTAMP, 2);

-- Inserts para la tabla roles_permisos
INSERT INTO roles_permisos (rol_id, permiso_id) VALUES
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8), (1, 9), (1, 10),
(1, 11), (1, 12), (1, 13), (1, 14), (1, 15), (1, 16), (1, 17), (1, 18), (1, 19), (1, 20),
(1, 21), (1, 22), (1, 23), (1, 24), (1, 25), (1, 26), (1, 27), (1, 28), (1, 29), (1, 30),
(2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (2, 7), (2, 8),
(3, 3), (3, 4), (3, 5), (3, 6), (3, 14), (3, 20),
(4, 3), (4, 4), (4, 5), (4, 6), (4, 16),
(5, 1), (5, 2), (5, 3), (5, 4), (5, 5), (5, 6), (5, 7), (5, 8), (5, 9), (5, 10),
(5, 11), (5, 12), (5, 13), (5, 14), (5, 15), (5, 16), (5, 17), (5, 18), (5, 19), (5, 20),
(5, 21), (5, 22), (5, 23), (5, 24), (5, 25), (5, 26), (5, 27), (5, 28), (5, 29), (5, 30);

-- Inserts para la tabla mesas
INSERT INTO mesas (numero_mesa, capacidad, estado, ubicacion, created_at, updated_at) VALUES
(1, 4, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 6, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 2, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 8, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 4, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 6, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 2, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 4, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, 6, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 4, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(11, 8, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(12, 2, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(13, 4, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(14, 6, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(15, 4, 'disponible', 'Sala Principal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Inserts para la tabla meseros
INSERT INTO meseros (usuario_id, estado, created_at, updated_at) VALUES
(1, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(11, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(12, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(13, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(14, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(15, 'activo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Inserts para la tabla categorias
INSERT INTO categorias (nombre, descripcion, created_at, updated_at) VALUES
('Entradas', 'Platos para comenzar', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Sopas', 'Sopas y cremas', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Platos Principales', 'Platos principales del menú', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Postres', 'Postres y dulces', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Bebidas', 'Bebidas y refrescos', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Cócteles', 'Bebidas alcohólicas', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Ensaladas', 'Ensaladas frescas', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Pizzas', 'Pizzas y pastas', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Hamburguesas', 'Hamburguesas y sandwiches', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Mariscos', 'Platos de mariscos', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Parrillas', 'Carnes a la parrilla', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Pescados', 'Platos de pescado', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Pastas', 'Platos de pasta', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Arroces', 'Platos de arroz', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Vegetariano', 'Platos vegetarianos', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Inserts para la tabla productos
INSERT INTO productos (id_categoria, nombre, descripcion, precio, imagen_url, disponible, created_at, updated_at) VALUES
(1, 'Carpaccio de Res', 'Finas láminas de res con rúcula y parmesano', 25.00, 'carpaccio.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Bruschettas', 'Pan tostado con tomate y albahaca', 15.00, 'bruschettas.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 'Calamares Fritos', 'Calamares empanados con salsa alioli', 20.00, 'calamares.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Sopa de Cebolla', 'Sopa de cebolla gratinada', 18.00, 'sopa_cebolla.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Crema de Espárragos', 'Crema de espárragos verdes', 16.00, 'crema_esparragos.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Sopa de Mariscos', 'Sopa de mariscos del día', 22.00, 'sopa_mariscos.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Lomo Saltado', 'Plato típico peruano', 35.00, 'lomo_saltado.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Pescado a la Veracruzana', 'Pescado en salsa de tomate y aceitunas', 30.00, 'pescado_veracruzana.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Risotto de Hongos', 'Risotto con hongos silvestres', 28.00, 'risotto.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Tiramisú', 'Postre italiano clásico', 12.00, 'tiramisu.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Crème Brûlée', 'Postre francés de vainilla', 10.00, 'creme_brulee.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Cheesecake', 'Tarta de queso con frutos rojos', 14.00, 'cheesecake.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'Limonada', 'Limonada fresca natural', 8.00, 'limonada.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'Jugo de Naranja', 'Jugo de naranja natural', 7.00, 'jugo_naranja.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'Café Americano', 'Café americano caliente', 6.00, 'cafe_americano.jpg', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Inserts para la tabla pedidos
INSERT INTO pedidos (id_mesa, id_mesero, estado, fecha_pedido, total, observaciones, created_at, updated_at) VALUES
(1, 1, 'completado', CURRENT_TIMESTAMP, 85.00, 'Sin cebolla', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 2, 'en_proceso', CURRENT_TIMESTAMP, 120.00, 'Bien cocido', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 3, 'pendiente', CURRENT_TIMESTAMP, 65.00, 'Sin sal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 4, 'completado', CURRENT_TIMESTAMP, 150.00, 'Extra salsa', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 5, 'en_proceso', CURRENT_TIMESTAMP, 95.00, 'Sin hielo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 6, 'pendiente', CURRENT_TIMESTAMP, 75.00, 'Bien hecho', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 7, 'completado', CURRENT_TIMESTAMP, 110.00, 'Extra queso', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 8, 'en_proceso', CURRENT_TIMESTAMP, 130.00, 'Sin gluten', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, 9, 'pendiente', CURRENT_TIMESTAMP, 90.00, 'Extra picante', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 10, 'completado', CURRENT_TIMESTAMP, 140.00, 'Sin azúcar', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(11, 11, 'en_proceso', CURRENT_TIMESTAMP, 100.00, 'Extra servilletas', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(12, 12, 'pendiente', CURRENT_TIMESTAMP, 80.00, 'Sin hielo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(13, 13, 'completado', CURRENT_TIMESTAMP, 160.00, 'Extra salsa', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(14, 14, 'en_proceso', CURRENT_TIMESTAMP, 115.00, 'Bien cocido', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(15, 15, 'pendiente', CURRENT_TIMESTAMP, 70.00, 'Sin sal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Inserts para la tabla detalles_pedido
INSERT INTO detalles_pedido (id_pedido, id_producto, cantidad, precio_unitario, subtotal, observaciones, created_at, updated_at) VALUES
(1, 1, 2, 25.00, 50.00, 'Sin cebolla', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 5, 1, 18.00, 18.00, 'Bien caliente', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 10, 1, 12.00, 12.00, 'Extra crema', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1, 13, 1, 8.00, 8.00, 'Sin hielo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 2, 3, 15.00, 45.00, 'Extra aceite', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 6, 2, 16.00, 32.00, 'Bien caliente', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 11, 2, 10.00, 20.00, 'Extra chocolate', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 14, 3, 7.00, 21.00, 'Sin azúcar', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 3, 2, 20.00, 40.00, 'Bien dorado', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 7, 1, 35.00, 35.00, 'Bien cocido', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 12, 1, 14.00, 14.00, 'Extra frutos', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 15, 1, 6.00, 6.00, 'Bien caliente', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 4, 4, 22.00, 88.00, 'Extra mariscos', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 8, 2, 30.00, 60.00, 'Bien hecho', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 13, 1, 8.00, 8.00, 'Sin hielo', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Inserts para la tabla reservas
INSERT INTO reservas (id_mesa, nombre_cliente, telefono, fecha_reserva, hora_reserva, numero_personas, estado, observaciones, created_at, updated_at) VALUES
(1, 'Juan Pérez', '123456789', CURRENT_DATE, '12:00:00', 4, 'confirmada', 'Mesa junto a la ventana', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'María García', '234567890', CURRENT_DATE, '13:00:00', 6, 'pendiente', 'Celebración de cumpleaños', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Carlos López', '345678901', CURRENT_DATE, '14:00:00', 2, 'confirmada', 'Sin cebolla', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Ana Martínez', '456789012', CURRENT_DATE, '15:00:00', 8, 'cancelada', 'Cancelada por el cliente', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'Pedro Sánchez', '567890123', CURRENT_DATE, '16:00:00', 4, 'confirmada', 'Mesa junto al bar', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 'Laura Rodríguez', '678901234', CURRENT_DATE, '17:00:00', 6, 'pendiente', 'Vista al jardín', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 'Roberto Fernández', '789012345', CURRENT_DATE, '18:00:00', 2, 'confirmada', 'Sin sal', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 'Carmen González', '890123456', CURRENT_DATE, '19:00:00', 4, 'confirmada', 'Mesa junto a la entrada', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, 'José Ramírez', '901234567', CURRENT_DATE, '20:00:00', 6, 'pendiente', 'Extra servilletas', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 'Isabel Torres', '012345678', CURRENT_DATE, '21:00:00', 4, 'confirmada', 'Sin gluten', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(11, 'Miguel Ruiz', '123456789', CURRENT_DATE, '22:00:00', 8, 'confirmada', 'Celebración especial', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(12, 'Sofia Díaz', '234567890', CURRENT_DATE, '23:00:00', 2, 'pendiente', 'Sin azúcar', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(13, 'David Moreno', '345678901', CURRENT_DATE, '12:30:00', 4, 'confirmada', 'Mesa junto a la cocina', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(14, 'Elena Jiménez', '456789012', CURRENT_DATE, '13:30:00', 6, 'confirmada', 'Vista al jardín', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(15, 'Francisco Paredes', '567890123', CURRENT_DATE, '14:30:00', 4, 'pendiente', 'Mesa junto al bar', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP); 