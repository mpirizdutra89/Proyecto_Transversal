-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 25-05-2024 a las 21:25:17
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `universidadulp`
--
CREATE DATABASE IF NOT EXISTS `universidadulp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `universidadulp`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

DROP TABLE IF EXISTS `alumno`;
CREATE TABLE IF NOT EXISTS `alumno` (
  `idAlumno` int NOT NULL AUTO_INCREMENT,
  `dni` int NOT NULL,
  `apellido` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idAlumno`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`) VALUES
(8, 12345678, 'Gonzalez', 'Juan', '2000-01-15', 1),
(9, 23456789, 'Perez', 'Maria', '1999-02-20', 1),
(10, 34567890, 'Lopez', 'Carlos', '1998-03-25', 1),
(11, 45678901, 'Garcia', 'Ana', '2001-04-10', 1),
(12, 56789012, 'Sanchez', 'Luis', '2000-05-30', 1),
(13, 67890123, 'Diaz', 'Laura', '1999-06-15', 1),
(14, 78901234, 'Martinez', 'Jose', '1998-07-20', 1),
(15, 89012345, 'Fernandez', 'Elena', '2001-08-05', 1),
(16, 90123456, 'Rodriguez', 'Marta', '2000-09-10', 1),
(17, 12345098, 'Ramirez', 'Miguel', '1999-10-25', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
CREATE TABLE IF NOT EXISTS `inscripcion` (
  `idInscripto` int NOT NULL AUTO_INCREMENT,
  `idAlumno` int DEFAULT NULL,
  `idMateria` int DEFAULT NULL,
  `nota` int NOT NULL,
  PRIMARY KEY (`idInscripto`),
  KEY `idAlumno` (`idAlumno`),
  KEY `idMateria` (`idMateria`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`idInscripto`, `idAlumno`, `idMateria`, `nota`) VALUES
(11, 9, 2, 6),
(12, 9, 1, 7),
(13, 9, 9, 8),
(14, 9, 8, 9),
(16, 9, 10, 8),
(19, 9, 4, 6),
(20, 9, 6, 7),
(21, 10, 10, 7),
(22, 10, 9, 9),
(23, 10, 4, 7),
(24, 10, 7, 7),
(25, 10, 3, 8),
(26, 10, 1, 8),
(27, 10, 5, 8),
(28, 10, 2, 8),
(29, 10, 6, 9),
(30, 10, 8, 8),
(31, 11, 1, 7),
(32, 11, 3, 7),
(33, 11, 6, 9),
(34, 11, 2, 8),
(35, 11, 8, 8),
(36, 11, 4, 9),
(37, 11, 10, 8),
(38, 11, 7, 7),
(39, 11, 9, 9),
(40, 11, 5, 8),
(41, 12, 2, 8),
(42, 12, 3, 9),
(43, 12, 5, 7),
(44, 12, 1, 8),
(45, 12, 7, 8),
(46, 12, 6, 9),
(47, 12, 9, 9),
(48, 12, 4, 7),
(49, 12, 8, 8),
(50, 12, 10, 9),
(51, 13, 9, 8),
(52, 13, 7, 8),
(53, 13, 5, 6),
(54, 13, 4, 9),
(55, 13, 6, 6),
(56, 13, 1, 8),
(57, 13, 2, 8),
(58, 13, 3, 9),
(59, 13, 8, 7),
(60, 13, 10, 9),
(61, 14, 9, 7),
(62, 14, 6, 8),
(63, 14, 1, 7),
(64, 14, 7, 8),
(65, 14, 2, 9),
(66, 14, 4, 6),
(67, 14, 8, 6),
(68, 14, 10, 6),
(69, 14, 3, 8),
(70, 14, 5, 8),
(71, 15, 2, 8),
(72, 15, 9, 9),
(73, 15, 3, 7),
(74, 15, 1, 7),
(75, 15, 8, 9),
(76, 15, 10, 9),
(77, 15, 5, 9),
(78, 15, 4, 9),
(79, 15, 6, 9),
(80, 15, 7, 7),
(81, 16, 7, 7),
(82, 16, 9, 9),
(83, 16, 8, 7),
(84, 16, 10, 7),
(85, 16, 4, 7),
(86, 16, 6, 8),
(87, 16, 5, 6),
(88, 16, 1, 8),
(89, 16, 2, 7),
(90, 16, 3, 9),
(91, 17, 1, 6),
(92, 17, 10, 8),
(93, 17, 7, 8),
(94, 17, 6, 7),
(95, 17, 4, 8),
(96, 17, 8, 9),
(97, 17, 2, 8),
(98, 17, 5, 8),
(99, 17, 9, 8),
(100, 17, 3, 8),
(131, 9, 7, 0),
(132, 8, 5, 0),
(133, 8, 9, 0),
(134, 8, 10, 0),
(136, 8, 6, 0),
(137, 8, 7, 0),
(138, 8, 4, 0),
(139, 8, 3, 0),
(140, 8, 1, 0),
(141, 8, 2, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

DROP TABLE IF EXISTS `materia`;
CREATE TABLE IF NOT EXISTS `materia` (
  `idMateria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `año` int NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`idMateria`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`idMateria`, `nombre`, `año`, `estado`) VALUES
(1, 'Matemática I', 1, 1),
(2, 'Física I', 1, 1),
(3, 'Química I', 1, 1),
(4, 'Programación I', 1, 1),
(5, 'Historia', 2, 1),
(6, 'Geografía', 2, 1),
(7, 'Biología', 2, 1),
(8, 'Inglés', 1, 1),
(9, 'Literatura', 2, 1),
(10, 'Educación Física', 1, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`),
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
