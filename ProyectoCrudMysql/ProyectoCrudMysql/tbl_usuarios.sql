-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-11-2022 a las 06:51:55
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_basepruebas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuarios`
--

CREATE TABLE `tbl_usuarios` (
  `IdUsuario` int(11) NOT NULL,
  `Nombre` varchar(15) NOT NULL,
  `Apellido1` varchar(15) NOT NULL,
  `Apellido2` varchar(15) DEFAULT NULL,
  `FechaNacimiento` date NOT NULL,
  `Email` varchar(60) NOT NULL,
  `Usuario` varchar(15) NOT NULL,
  `Pass` varchar(16) NOT NULL,
  `FechaCreacion` datetime NOT NULL,
  `Estado` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tbl_usuarios`
--

INSERT INTO `tbl_usuarios` (`IdUsuario`, `Nombre`, `Apellido1`, `Apellido2`, `FechaNacimiento`, `Email`, `Usuario`, `Pass`, `FechaCreacion`, `Estado`) VALUES
(37, 'Carlos', 'Mantilla', 'Aragon', '2005-11-24', 'kbhfbhdf@hfdh.com', 'CARMARA', '123456', '2022-05-15 14:26:32', 1),
(39, 'Lorena', 'Viveros', 'Caicedo', '1980-02-19', 'njcfdjbd@bdhbd.com', 'LOVICA', '1234', '2022-11-10 22:39:09', 1),
(40, 'Mrcela', 'Torres', 'Granja', '2000-11-10', 'mjdudff@fdhjdfd.com', 'MARCETO', '45845', '2022-11-10 23:27:10', 1),
(41, 'Stephany', 'Smit', 'Forero', '1990-04-28', 'jdjfddhfhd@djndj.com', 'STEPHASM', '78952', '2022-11-10 23:29:05', 1),
(42, 'Jose Tulio', 'Martinez', 'Salazar', '1972-05-16', 'fhbhfgg@bvhd.com', 'JOSETS', '45214', '2022-11-10 23:36:23', 1),
(43, 'Hector', 'Suarez', 'Cordoba', '1967-10-20', 'dhhgfd@juddfd.com', 'HECTSUA', '421233', '2022-11-10 23:46:17', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD PRIMARY KEY (`IdUsuario`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Usuario` (`Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  MODIFY `IdUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
