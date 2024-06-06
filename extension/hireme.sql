-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2024 at 03:22 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hireme`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(10) NOT NULL,
  `nama_admin` varchar(20) NOT NULL,
  `password_admin` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama_admin`, `password_admin`) VALUES
('ADM001', 'admin1', '12345'),
('ADM002', 'admin2', '67890');

-- --------------------------------------------------------

--
-- Table structure for table `notifikasi`
--

CREATE TABLE `notifikasi` (
  `notifikasi_status` varchar(20) NOT NULL,
  `rekomendasi` varchar(50) NOT NULL,
  `kode_proyek` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pekerja`
--

CREATE TABLE `pekerja` (
  `id_pekerja` varchar(10) NOT NULL,
  `namalengkap_pekerja` varchar(50) NOT NULL,
  `alamat_pekerja` varchar(50) NOT NULL,
  `notelp_pekerja` varchar(20) NOT NULL,
  `email_pekerja` varchar(20) NOT NULL,
  `username_pekerja` varchar(20) NOT NULL,
  `password_pekerja` varchar(5) NOT NULL,
  `id_admin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pekerja`
--

INSERT INTO `pekerja` (`id_pekerja`, `namalengkap_pekerja`, `alamat_pekerja`, `notelp_pekerja`, `email_pekerja`, `username_pekerja`, `password_pekerja`, `id_admin`) VALUES
('PKJ001', 'Muhammad', 'Jimbaran, Badung', '089123456789', 'muhammad@email.com', 'Muhammad', '12345', 'ADM001'),
('PKJ002', 'Putu Gede Andi', 'Jimbaran, Bali', '08123456789', 'andi@email.com', 'Putu Made', '12345', 'ADM002');

-- --------------------------------------------------------

--
-- Table structure for table `pekerjaan`
--

CREATE TABLE `pekerjaan` (
  `id_pekerjaan` varchar(10) NOT NULL,
  `nama_pekerjaan` varchar(20) NOT NULL,
  `deskripsi_pekerjaan` varchar(50) NOT NULL,
  `kategori_pekerjaan` varchar(20) NOT NULL,
  `biaya_pekerjaan` varchar(20) NOT NULL,
  `id_pekerja` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pekerjaan`
--

INSERT INTO `pekerjaan` (`id_pekerjaan`, `nama_pekerjaan`, `deskripsi_pekerjaan`, `kategori_pekerjaan`, `biaya_pekerjaan`, `id_pekerja`) VALUES
('PJ001', 'Service AC', 'Memperbaiki AC yang rusak', 'Elektronik', '200.000', 'PKJ001'),
('PJ002', 'Service HP', 'Memperbaiki HP yang rusak', 'Elektronik', '250.000', 'PKJ002');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id_pengguna` varchar(10) NOT NULL,
  `username_pengguna` varchar(20) NOT NULL,
  `email_pengguna` varchar(20) NOT NULL,
  `notelp_pengguna` varchar(20) NOT NULL,
  `password_pengguna` varchar(20) NOT NULL,
  `kategori_pengguna` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id_pengguna`, `username_pengguna`, `email_pengguna`, `notelp_pengguna`, `password_pengguna`, `kategori_pengguna`) VALUES
('PN001', 'budi', 'budi123@email.com', '087654123789', '12345', 'Reguler'),
('PN002', 'putri', 'putri24@email.com', '085123456789', '12345', 'Premium'),
('PN956', 'dajay123', 'dajay123@email.com', '0592515251241', '12345', 'Reguler');

-- --------------------------------------------------------

--
-- Table structure for table `proyek`
--

CREATE TABLE `proyek` (
  `kode_proyek` varchar(10) NOT NULL,
  `judul_proyek` varchar(50) NOT NULL,
  `deskripsi_proyek` varchar(100) NOT NULL,
  `tanggal_proyek` date NOT NULL,
  `biaya_proyek` varchar(20) NOT NULL,
  `id_pekerjaan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `proyek`
--

INSERT INTO `proyek` (`kode_proyek`, `judul_proyek`, `deskripsi_proyek`, `tanggal_proyek`, `biaya_proyek`, `id_pekerjaan`) VALUES
('KP001', 'Service AC', 'Memperbaiki AC yang rusak', '2023-12-18', '200.000', 'PJ001');

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `id_report` varchar(10) NOT NULL,
  `deskripsi_report` varchar(100) NOT NULL,
  `tanggal_report` date NOT NULL,
  `jam_report` varchar(10) NOT NULL,
  `id_pengguna` varchar(10) NOT NULL,
  `id_pekerja` varchar(10) NOT NULL,
  `id_admin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `judul_review` varchar(20) NOT NULL,
  `deskripsi_review` int(100) NOT NULL,
  `waktu_review` varchar(20) NOT NULL,
  `id_pengguna` varchar(10) NOT NULL,
  `kode_proyek` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `kode_transaksi` varchar(10) NOT NULL,
  `metode_transaksi` varchar(20) NOT NULL,
  `waktu_transaksi` varchar(20) NOT NULL,
  `id_pengguna` varchar(10) NOT NULL,
  `kode_proyek` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `notifikasi`
--
ALTER TABLE `notifikasi`
  ADD KEY `kode_proyek` (`kode_proyek`);

--
-- Indexes for table `pekerja`
--
ALTER TABLE `pekerja`
  ADD PRIMARY KEY (`id_pekerja`),
  ADD KEY `id_admin` (`id_admin`);

--
-- Indexes for table `pekerjaan`
--
ALTER TABLE `pekerjaan`
  ADD PRIMARY KEY (`id_pekerjaan`),
  ADD KEY `id_pekerja` (`id_pekerja`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Indexes for table `proyek`
--
ALTER TABLE `proyek`
  ADD PRIMARY KEY (`kode_proyek`),
  ADD KEY `id_pekerjaan` (`id_pekerjaan`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`id_report`),
  ADD KEY `id_pengguna` (`id_pengguna`,`id_pekerja`,`id_admin`),
  ADD KEY `id_pekerja` (`id_pekerja`),
  ADD KEY `id_admin` (`id_admin`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD KEY `id_pengguna` (`id_pengguna`,`kode_proyek`),
  ADD KEY `kode_proyek` (`kode_proyek`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD KEY `id_pengguna` (`id_pengguna`,`kode_proyek`),
  ADD KEY `kode_proyek` (`kode_proyek`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `notifikasi`
--
ALTER TABLE `notifikasi`
  ADD CONSTRAINT `notifikasi_ibfk_1` FOREIGN KEY (`kode_proyek`) REFERENCES `proyek` (`kode_proyek`);

--
-- Constraints for table `pekerja`
--
ALTER TABLE `pekerja`
  ADD CONSTRAINT `pekerja_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`);

--
-- Constraints for table `pekerjaan`
--
ALTER TABLE `pekerjaan`
  ADD CONSTRAINT `pekerjaan_ibfk_1` FOREIGN KEY (`id_pekerja`) REFERENCES `pekerja` (`id_pekerja`);

--
-- Constraints for table `proyek`
--
ALTER TABLE `proyek`
  ADD CONSTRAINT `proyek_ibfk_1` FOREIGN KEY (`id_pekerjaan`) REFERENCES `pekerjaan` (`id_pekerjaan`);

--
-- Constraints for table `report`
--
ALTER TABLE `report`
  ADD CONSTRAINT `report_ibfk_1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`),
  ADD CONSTRAINT `report_ibfk_2` FOREIGN KEY (`id_pekerja`) REFERENCES `pekerja` (`id_pekerja`),
  ADD CONSTRAINT `report_ibfk_3` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id_admin`);

--
-- Constraints for table `review`
--
ALTER TABLE `review`
  ADD CONSTRAINT `review_ibfk_1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`),
  ADD CONSTRAINT `review_ibfk_2` FOREIGN KEY (`kode_proyek`) REFERENCES `proyek` (`kode_proyek`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`kode_proyek`) REFERENCES `proyek` (`kode_proyek`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
