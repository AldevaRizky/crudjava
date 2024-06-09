-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 09, 2024 at 01:10 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crudjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblbarang`
--

CREATE TABLE `tblbarang` (
  `idCamera` int NOT NULL,
  `namaCamera` varchar(255) NOT NULL,
  `typeCamera` varchar(255) NOT NULL,
  `stokCamera` int NOT NULL,
  `hargaCamera` int NOT NULL,
  `isActive` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tblbarang`
--

INSERT INTO `tblbarang` (`idCamera`, `namaCamera`, `typeCamera`, `stokCamera`, `hargaCamera`, `isActive`) VALUES
(1, 'Canon EOS R5', 'Mirrorless', 10, 45000000, 1),
(2, 'Nikon D850', 'DSLR', 8, 35000000, 1),
(3, 'Sony A7 III', 'Mirrorless', 15, 30000000, 1),
(4, 'Fujifilm X-T4', 'Mirrorless', 12, 25000000, 1),
(5, 'Panasonic Lumix GH5', 'Mirrorless', 5, 20000000, 1),
(6, 'Canon EOS 90D', 'DSLR', 9, 20000000, 1),
(7, 'Nikon Z6', 'Mirrorless', 11, 25000000, 1),
(8, 'Sony A6600', 'Mirrorless', 7, 18000000, 1),
(9, 'Olympus OM-D E-M1 Mark III', 'Mirrorless', 6, 30000000, 1),
(10, 'Canon EOS M50', 'Mirrorless', 14, 15000000, 1),
(11, 'Sony A7C', 'Mirrorless', 12, 35000000, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblbarang`
--
ALTER TABLE `tblbarang`
  ADD PRIMARY KEY (`idCamera`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tblbarang`
--
ALTER TABLE `tblbarang`
  MODIFY `idCamera` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
