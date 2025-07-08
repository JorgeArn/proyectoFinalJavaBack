-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 08-07-2025 a las 01:53:11
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ecommerce_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

DROP TABLE IF EXISTS `articulo`;
CREATE TABLE IF NOT EXISTS `articulo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `categoria` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`id`, `categoria`, `imagen`, `nombre`, `precio`) VALUES
(3, 'Cafeteras', 'http://localhost:8080/uploads/b5a80ab3-a750-4fd4-a6cf-97778f23ceed_anna_pid.jpg', 'Lelit Anna Pid', 1200000),
(4, 'Cafeteras', 'http://localhost:8080/uploads/73e93f6e-0bf9-4c2f-8336-86dbf26b9425_marax.jpg', 'Lelit MaraX', 2000000),
(5, 'Cafeteras', 'http://localhost:8080/uploads/4c3a8e10-f48f-4510-86cd-8012c6fbe002_bianca.jpg', 'Lelit Bianca', 4500000),
(6, 'Molinos', 'http://localhost:8080/uploads/dd499cc4-655c-496e-8b8a-7eeb88151c8f_molino_eureka75.jpg', 'Eureka Helios 75', 2100000),
(7, 'Molinos', 'http://localhost:8080/uploads/0a535468-5142-402e-b28e-37e73e447678_molino_eureka_mignon.jpg', 'Eureka Mignon', 1160000),
(8, 'Molinos', 'http://localhost:8080/uploads/fd1aaee4-137c-4e27-b9c3-653bf1e982ae_molino_manual.jpg', 'Molino Manual', 400000),
(9, 'Barista Tools', 'http://localhost:8080/uploads/93673ddb-4d51-49f7-945a-0e0b9b8d161f_balanza.jpg', 'Balanza Digital', 100000),
(10, 'Accesorios', 'http://localhost:8080/uploads/5dc2ed99-ecf8-458d-80d3-8afd8e047afd_portafiltro_58mm.jpeg', 'Portafiltro Sin Fondo', 80000),
(11, 'Accesorios', 'http://localhost:8080/uploads/c5885a11-b8a0-4e17-9430-d66f74241de5_portafiltro_doble_boquilla.jpg', 'Portafiltro Doble Boquilla', 85000),
(12, 'Accesorios', 'http://localhost:8080/uploads/3d8af311-7f4f-4e2a-bc45-e41bdb709052_tamper_madera.jpg', 'Tamper', 52000),
(13, 'Accesorios', 'http://localhost:8080/uploads/2a5bbf30-d9d3-427f-bf92-62eff6c60ab9_puqpress-tamper.jpg', 'Tamper Automático', 200000),
(14, 'Accesorios', 'http://localhost:8080/uploads/8c92328b-df47-4019-b61e-33d31c55ac74_wdt.jpg', 'Distribuidor Wdt', 30000),
(15, 'Accesorios', 'http://localhost:8080/uploads/588a8410-58d3-44cd-86b8-8f5aaa62369b_puckscreen.jpg', 'Puck Screen', 15000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_articulo`
--

DROP TABLE IF EXISTS `pedido_articulo`;
CREATE TABLE IF NOT EXISTS `pedido_articulo` (
  `pedido_id` bigint NOT NULL,
  `articulo_id` bigint NOT NULL,
  KEY `FKkax26138toihkiww2akkpk73i` (`articulo_id`),
  KEY `FK1gq0scwvbghp998v6ddxs17oj` (`pedido_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedido_articulo`
--
ALTER TABLE `pedido_articulo`
  ADD CONSTRAINT `FK1gq0scwvbghp998v6ddxs17oj` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
  ADD CONSTRAINT `FKkax26138toihkiww2akkpk73i` FOREIGN KEY (`articulo_id`) REFERENCES `articulo` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
