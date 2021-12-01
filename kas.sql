-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2021 at 06:46 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kas`
--

-- --------------------------------------------------------

--
-- Table structure for table `kas_in`
--

CREATE TABLE `kas_in` (
  `id` int(9) NOT NULL,
  `kode` varchar(9) NOT NULL,
  `tanggal` varchar(16) NOT NULL,
  `keterangan` varchar(128) NOT NULL,
  `jumlah` int(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kas_in`
--

INSERT INTO `kas_in` (`id`, `kode`, `tanggal`, `keterangan`, `jumlah`) VALUES
(1, 'kn001', '2021-11-25', 'Haris bayar kas', 40000),
(2, 'kn002', '2021-11-25', 'Sumbangan Dosen', 30000),
(4, 'kn003', '2021-11-25', 'Sumbangan Mahasiswa', 50000),
(5, 'kn004', '2021-11-25', 'Sumbangan Alumnus', 100000),
(8, 'kn005', '2021-11-26', 'Pembagian dana kegiatan dari BEM', 1000),
(9, 'kn006', '2021-11-28', 'Yuda bayar uang kas *dipaksa dulu', 2000),
(10, 'kn007', '2021-11-28', 'Sumbangan warga sekitar kampus', 3000),
(11, 'kn008', '2021-11-28', 'Sarip kena denda, matakuliah Pak Awid', 8000);

-- --------------------------------------------------------

--
-- Table structure for table `kas_out`
--

CREATE TABLE `kas_out` (
  `id` int(9) NOT NULL,
  `kode` varchar(9) NOT NULL,
  `tanggal` varchar(16) NOT NULL,
  `keterangan` varchar(128) NOT NULL,
  `jumlah` int(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kas_out`
--

INSERT INTO `kas_out` (`id`, `kode`, `tanggal`, `keterangan`, `jumlah`) VALUES
(2, 'ko002', '2021-11-26', 'Ketua kelas pinjam uang untuk jajan', 4000),
(6, 'ko004', '2021-11-27', 'Beli iphone kw100', 1000),
(7, 'ko005', '2021-11-27', 'Beli akuarium kelas', 50000),
(8, 'ko006', '2021-11-27', 'Beli projector', 10000),
(9, 'ko007', '2021-11-28', 'Beli uang monopoli praktek makul kwu', 1000),
(10, 'ko008', '2021-11-28', 'Iuran uang keamanan', 5000),
(11, 'ko008', '2021-11-28', 'Iuran Kurban 2022', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(6) NOT NULL,
  `username` varchar(9) NOT NULL,
  `password` varchar(16) NOT NULL,
  `role` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `role`) VALUES
(1, 'alifia', '12345', 'admin'),
(2, 'farhan', '12345', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kas_in`
--
ALTER TABLE `kas_in`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kas_out`
--
ALTER TABLE `kas_out`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kas_in`
--
ALTER TABLE `kas_in`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `kas_out`
--
ALTER TABLE `kas_out`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
