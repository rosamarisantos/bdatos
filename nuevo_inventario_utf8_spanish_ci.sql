-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: db
-- Tiempo de generación: 03-06-2019 a las 11:37:06
-- Versión del servidor: 5.6.44
-- Versión de PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestion_inventario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `username` varchar(12) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`username`, `password`, `email`, `telefono`) VALUES
('juangu', 'secreto123', 'juangu@ies.es', 555123456),
('Pepe', 'secreto123', 'pepe@gmail.com', 934545454);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora`
--

CREATE TABLE `bitacora` (
  `id` int(11) NOT NULL,
  `usuario` varchar(12) CHARACTER SET latin1 DEFAULT NULL,
  `ip` varchar(15) CHARACTER SET latin1 DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `hora` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `bitacora`
--

INSERT INTO `bitacora` (`id`, `usuario`, `ip`, `fecha`, `hora`) VALUES
(3, 'Coco', '234.54.54.05', '2019-06-01 10:52:02', '2019-06-01 00:00:00'),
(4, 'Coco', '234.54.54.05', '2019-06-01 10:52:16', '2019-06-01 00:00:00'),
(5, 'Toto', '234.54.54.05', '2019-06-01 10:52:43', '2019-06-01 00:00:00'),
(6, 'Toto', '234.54.54.05', '2019-06-01 10:52:56', '2019-06-01 00:00:00'),
(7, 'Toto', '234.54.54.05', '2019-06-01 10:53:07', '2019-06-01 00:00:00'),
(8, 'Toto', '234.54.54.05', '2019-06-01 10:53:17', '2019-06-01 00:00:00'),
(9, 'Popo', '234.54.54.05', '2019-06-01 10:53:36', '2019-06-01 00:00:00'),
(10, 'Popo', '234.54.54.05', '2019-06-01 10:53:55', '2019-06-01 00:00:00'),
(19, 'Lolo', '123.34.43.23', '2019-06-01 11:24:33', '2019-06-01 11:24:33'),
(20, 'Lolo', '123.34.43.23', '2019-06-01 11:24:43', '2019-06-01 11:24:43');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `nombre` varchar(40) NOT NULL,
  `descripcion` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`nombre`, `descripcion`) VALUES
('Audio Foto Video', 'Todo lo multimedia'),
('Cables', 'Cables y accesorios de enganche'),
('Componentes', 'Todo tipo piezas '),
('dd  ll', 'ffffff'),
('dd/ll', 'ffffff'),
('Impresoras Comsumibles', 'Todo para imprimir'),
('IoT', 'Internet de las cosas'),
('Ordenadores', 'Todos los programables '),
('Perifericos', 'Todo lo de fuera'),
('Redes', 'Todo para conexion internet '),
('Smartphones Telefona', 'Todos los m viles'),
('Tablets Ebooks', 'Tables y libros electronicos'),
('Televisores', 'Aparatos de TV');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `marca` varchar(40) NOT NULL,
  `modelo` varchar(40) NOT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `tipo` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `marca`, `modelo`, `descripcion`, `tipo`) VALUES
(7, 'Disco sd', 'QWT', 'Eww', 'SAD', 'Discos Duros'),
(8, 'Memoria', 'QWT', 'Eww', 'BANI', 'Memoria RAM'),
(10, 'Xeon', 'AMAZON', 'Eww', 'UO67', 'Servidores'),
(11, 'Regleta red', 'QWT', 'Eww', 'CAS', 'Regletas'),
(12, 'Ordenador', 'Lenovo', 'EG67', 'YUTU', 'Portatil'),
(13, 'Disco sata', 'QWT', 'Eww', 'SAD', 'Discos Duros'),
(14, 'Conector rj45', 'QWT', 'Eww', 'SAD', 'Regletas'),
(15, 'Conector henbra rj45', 'QWT', 'Eww', 'SAD', 'Regletas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

CREATE TABLE `stock` (
  `id` int(11) NOT NULL,
  `ubicacion` varchar(40) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `stock`
--

INSERT INTO `stock` (`id`, `ubicacion`, `id_producto`, `cantidad`) VALUES
(7, 'RotondaG', 7, 30),
(8, 'RotondaH', 8, 80),
(9, 'RotondaD', 10, 30),
(10, 'RotondaE', 11, 50),
(11, 'RotondaF', 12, 40),
(12, 'RotondaA', 13, 40),
(13, 'RotondaB', 14, 40),
(14, 'RotondaC', 15, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo`
--

CREATE TABLE `tipo` (
  `nombre` varchar(40) NOT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `categoria` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tipo`
--

INSERT INTO `tipo` (`nombre`, `descripcion`, `categoria`) VALUES
('borra', 'nnn', 'Componentes'),
('borra2', 'nnn', 'Componentes'),
('borra3', 'nnn', 'Componentes'),
('Discos Duros', '250GB SSD', 'Componentes'),
('Memoria RAM', '2 x 8GB', 'Componentes'),
('Portatil', 'Apple', 'Ordenadores'),
('Regletas', '34cm', 'Redes'),
('Servidores', 'Con xeon', 'Ordenadores'),
('Ventiladores', 'De esquina superior', 'Componentes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ubicacion`
--

CREATE TABLE `ubicacion` (
  `nombre` varchar(40) NOT NULL,
  `sector` varchar(40) NOT NULL,
  `color` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ubicacion`
--

INSERT INTO `ubicacion` (`nombre`, `sector`, `color`) VALUES
('RotondaA', 'A', 'Azul'),
('RotondaB', 'B', 'Verde'),
('RotondaC', 'C', 'Carmin'),
('RotondaD', 'D', 'Amarillo'),
('RotondaE', 'E', 'Rojo'),
('RotondaF', 'F', 'Morado'),
('RotondaG', 'G', 'Gris'),
('RotondaH', 'H', 'Naranja');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `username` varchar(12) CHARACTER SET latin1 NOT NULL,
  `passwd` varchar(25) CHARACTER SET latin1 NOT NULL,
  `email` varchar(100) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`username`, `passwd`, `email`) VALUES
('Coco', 'cccc', 'coco@gmail.com'),
('Lolo', 'llll', 'lolo@gmail.com'),
('Popo', 'pppp', 'popo@gmail.com'),
('Toto', 'tttt', 'toto@gmail.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`username`);

--
-- Indices de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario` (`usuario`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tipo` (`tipo`);

--
-- Indices de la tabla `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ubicacion` (`ubicacion`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `categoria` (`categoria`);

--
-- Indices de la tabla `ubicacion`
--
ALTER TABLE `ubicacion`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `stock`
--
ALTER TABLE `stock`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD CONSTRAINT `bitacora_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`username`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`tipo`) REFERENCES `tipo` (`nombre`);

--
-- Filtros para la tabla `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`ubicacion`) REFERENCES `ubicacion` (`nombre`),
  ADD CONSTRAINT `stock_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `tipo`
--
ALTER TABLE `tipo`
  ADD CONSTRAINT `tipo_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`nombre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
