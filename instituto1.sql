-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-12-2020 a las 12:50:48
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `instituto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `cod_alumno` varchar(2) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre_alumno` varchar(15) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `apellidos_alumno` varchar(30) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `grupo` varchar(1) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`cod_alumno`, `nombre_alumno`, `apellidos_alumno`, `fecha_nacimiento`, `grupo`) VALUES
('01', 'Iñigo', 'Álvarez Hernández', '2000-06-21', 'A'),
('02', 'Alejandro', 'Berdasco Paredes', '1999-11-15', 'A'),
('03', 'Juan Luis', 'Blanco Sánchez', '2000-04-26', 'A'),
('04', 'Yohan', 'Chacón Sánchez', '2000-07-14', 'A'),
('05', 'Assier', 'Estrada García', '1986-06-04', 'B'),
('06', 'Pablo', 'Fernández Fernández', '2001-10-03', 'A'),
('07', 'Jorge', 'Fernández Grana', '1999-12-28', 'A'),
('08', 'Raul', 'Fernández Guerra', '2001-07-13', 'A'),
('09', 'Iván', 'Fernández Trabanco', '2001-04-25', 'A'),
('10', 'Diego', 'Garabaya Rodríguez', '2001-09-05', 'A'),
('11', 'Ignacio Sergio', 'García Fernández', '1996-03-19', 'B'),
('12', 'Jairo', 'González Fernández', '2001-11-27', 'A'),
('13', 'Alejandra', 'González Ramos', '1978-02-19', 'A'),
('14', 'Sergio', 'Guede Rodríguez', '2001-09-03', 'A'),
('15', 'Alejandro', 'Gutiérrez García', '1999-06-10', 'A'),
('16', 'David', 'Iglesias Rodríguez', '1999-03-24', 'A'),
('17', 'Francisco Kotei', 'Kotei López', '2000-04-17', 'A'),
('18', 'Soraya', 'López López', '2001-11-23', 'A'),
('19', 'Tania', 'López Rodríguez', '2000-08-16', 'B'),
('20', 'Leonardo', 'Loredo Vázquez', '2001-04-18', 'B'),
('21', 'Borja', 'Martín Estrada', '2000-05-26', 'B'),
('22', 'Manuel', 'Martinez Carrera', '2001-11-20', 'B'),
('23', 'Alejandro', 'Merino Díaz', '2001-04-13', 'B'),
('24', 'Alberto', 'Muñiz Meizoso', '2001-06-16', 'B'),
('25', 'Pablo', 'Navarro Díaz', '1998-07-22', 'B'),
('26', 'Sabrina Maria', 'Nogueira Martinez', '1988-02-07', 'B'),
('27', 'Iyan', 'Rodríguez García', '1999-05-21', 'A'),
('28', 'Javier', 'Rodríguez Navascués', '2000-05-09', 'A'),
('29', 'Aroa', 'Rodriguez del Valle', '2000-09-01', 'A'),
('30', 'David', 'Sala Suarez', '2000-09-02', 'B'),
('31', 'Cesar', 'Sanchez Conde', '2000-09-03', 'B'),
('32', 'Pablo', 'Santos Gomez', '2000-09-04', 'B'),
('33', 'Daniel', 'Sofronic Klaus', '2000-09-05', 'A'),
('34', 'Ignacio', 'Suárez Alijostes', '2000-09-05', 'B'),
('35', 'Alejandro', 'Suárez Saenz', '2000-09-06', 'B'),
('36', 'Elias', 'Villanueva Granados', '2000-09-07', 'B');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno-modulo`
--

CREATE TABLE `alumno_modulo` (
  `cod_alumno` varchar(2) COLLATE utf8_spanish2_ci NOT NULL,
  `cod_modulo` varchar(4) COLLATE utf8_spanish2_ci NOT NULL,
  `nota` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `alumno-modulo`
--

INSERT INTO `alumno_modulo` (`cod_alumno`, `cod_modulo`, `nota`) VALUES
('01', '0492', NULL),
('01', '0529', NULL),
('02', '0486', NULL),
('02', '0488', NULL),
('02', '0489', NULL),
('02', '0490', NULL),
('02', '0491', NULL),
('02', '0492', NULL),
('02', '0500', NULL),
('02', '0529', NULL),
('03', '0488', NULL),
('03', '0489', NULL),
('03', '0490', NULL),
('03', '0491', NULL),
('03', '0492', NULL),
('03', '0500', NULL),
('03', '0529', NULL),
('04', '0486', NULL),
('04', '0488', NULL),
('04', '0489', NULL),
('04', '0490', NULL),
('04', '0491', NULL),
('04', '0492', NULL),
('04', '0500', NULL),
('04', '0529', NULL),
('05', '0486', NULL),
('05', '0488', NULL),
('05', '0489', NULL),
('05', '0490', NULL),
('05', '0491', NULL),
('05', '0492', NULL),
('05', '0500', NULL),
('05', '0529', NULL),
('06', '0486', NULL),
('06', '0488', NULL),
('06', '0489', NULL),
('06', '0490', NULL),
('06', '0491', NULL),
('06', '0492', NULL),
('06', '0500', NULL),
('06', '0529', NULL),
('07', '0486', NULL),
('07', '0488', NULL),
('07', '0489', NULL),
('07', '0490', NULL),
('07', '0491', NULL),
('07', '0492', NULL),
('07', '0500', NULL),
('07', '0529', NULL),
('08', '0486', NULL),
('08', '0488', NULL),
('08', '0489', NULL),
('08', '0490', NULL),
('08', '0491', NULL),
('08', '0492', NULL),
('08', '0500', NULL),
('08', '0529', NULL),
('09', '0486', NULL),
('09', '0488', NULL),
('09', '0489', NULL),
('09', '0490', NULL),
('09', '0491', NULL),
('09', '0492', NULL),
('09', '0500', NULL),
('09', '0529', NULL),
('10', '0486', NULL),
('10', '0488', NULL),
('10', '0489', NULL),
('10', '0490', NULL),
('10', '0491', NULL),
('10', '0492', NULL),
('10', '0500', NULL),
('10', '0529', NULL),
('11', '0486', NULL),
('11', '0488', NULL),
('11', '0489', NULL),
('11', '0490', NULL),
('11', '0491', NULL),
('11', '0492', NULL),
('11', '0500', NULL),
('11', '0529', NULL),
('12', '0492', NULL),
('12', '0529', NULL),
('13', '0486', NULL),
('13', '0488', NULL),
('13', '0489', NULL),
('13', '0490', NULL),
('13', '0491', NULL),
('13', '0492', NULL),
('13', '0500', NULL),
('13', '0529', NULL),
('14', '0492', NULL),
('17', '0492', NULL),
('21', '0492', NULL),
('26', '0486', NULL),
('26', '0489', NULL),
('26', '0490', NULL),
('29', '0492', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciclo`
--

CREATE TABLE `ciclo` (
  `cod_ciclo` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(5) COLLATE utf8_spanish2_ci NOT NULL,
  `grado` varchar(10) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `ciclo`
--

INSERT INTO `ciclo` (`cod_ciclo`, `nombre`, `grado`) VALUES
('IFC-302.2V', 'DAM', 'superior'),
('IFC-303.2V', 'DAWdi', 'superior');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo`
--

CREATE TABLE `modulo` (
  `cod_modulo` varchar(4) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre_modulo` varchar(30) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `cod_ciclo` varchar(10) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `curso` varchar(1) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `cod_profesor` varchar(2) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `modulo`
--

INSERT INTO `modulo` (`cod_modulo`, `nombre_modulo`, `cod_ciclo`, `curso`, `cod_profesor`) VALUES
('0486', 'Acceso a datos', 'IFC-302.2V', '2', '02'),
('0488', 'Desarrollo de interfaces', 'IFC-302.2V', '2', '01'),
('0489', 'Programación mult y disp movil', 'IFC-302.2V', '2', '03'),
('0490', 'Servicios y procesos', 'IFC-302.2V', '2', '04'),
('0491', 'Sistemas de gestión empresaria', 'IFC-302.2V', '2', '05'),
('0492', 'Proyecto DAM', 'IFC-302.2V', '2', '01'),
('0500', 'Empresa e iniciativa emprended', 'IFC-302.2V', '2', '06'),
('0529', 'Formación en centros de trabaj', 'IFC-302.2V', '2', '01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `cod_profesor` varchar(2) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre_profesor` varchar(15) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `ciudad` varchar(15) COLLATE utf8_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`cod_profesor`, `nombre_profesor`, `ciudad`) VALUES
('01', 'Mercedes', 'Avilés'),
('02', 'Dionisio', 'Gijón'),
('03', 'Noelia', 'Gijón'),
('04', 'Asunción', 'Oviedo'),
('05', 'Juan Diego', 'León'),
('06', 'Alberto', 'Avilés'),
('07', 'Guillermo', 'Avilés');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`cod_alumno`);

--
-- Indices de la tabla `alumno-modulo`
--
ALTER TABLE `alumno_modulo`
  ADD PRIMARY KEY (`cod_alumno`,`cod_modulo`),
  ADD KEY `cod_alumno` (`cod_alumno`),
  ADD KEY `cod_modulo` (`cod_modulo`);

--
-- Indices de la tabla `ciclo`
--
ALTER TABLE `ciclo`
  ADD PRIMARY KEY (`cod_ciclo`);

--
-- Indices de la tabla `modulo`
--
ALTER TABLE `modulo`
  ADD PRIMARY KEY (`cod_modulo`),
  ADD KEY `cod_profesor` (`cod_profesor`),
  ADD KEY `cod_ciclo` (`cod_ciclo`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`cod_profesor`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumno-modulo`
--
ALTER TABLE `alumno_modulo`
  ADD CONSTRAINT `alumno-modulo_ibfk_1` FOREIGN KEY (`cod_modulo`) REFERENCES `modulo` (`cod_modulo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `alumno-modulo_ibfk_2` FOREIGN KEY (`cod_alumno`) REFERENCES `alumno` (`cod_alumno`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `modulo`
--
ALTER TABLE `modulo`
  ADD CONSTRAINT `modulo_ibfk_1` FOREIGN KEY (`cod_profesor`) REFERENCES `profesor` (`cod_profesor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `modulo_ibfk_2` FOREIGN KEY (`cod_ciclo`) REFERENCES `ciclo` (`cod_ciclo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
