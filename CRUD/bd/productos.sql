-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 25-11-2020 a las 23:15:40
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `productos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `producto_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `precio` float NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `clave` varchar(5) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`producto_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`producto_id`, `nombre`, `precio`, `tipo`, `clave`, `cantidad`) VALUES
(1, 'Coca-Cola', 12.5, 'Bebida', 'CC', 50),
(2, 'Doritos 95 gr', 15, 'Botana', 'DR', 70),
(10, 'Agua', 12.5, 'Bebida', 'AG', 78),
(11, 'Yogurth', 12.5, 'Bebida', 'YG', 24),
(13, 'Café', 15, 'Bbida', 'CF', 100);


INSERT INTO `producto` (`producto_id`, `nombre`, `precio`, `tipo`, `clave`, `cantidad`) VALUES
(1, 'Bola chicle', 12.5, 'Dulceria', 'BC', 50),
(2, 'Coffes', 15, 'Dulceria', 'CF', 70),
(10, 'Bombo', 12.5, 'Ducleria', 'BB', 78),
(11, 'Clip', 12.5, 'Bebida', 'CP', 24),
(13, 'Papa Salsa', 15, 'Comestibles', 'PS', 30);




/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
