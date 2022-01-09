-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 09 Jan 2022 pada 12.05
-- Versi server: 10.4.20-MariaDB
-- Versi PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kepegawaian`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `gaji`
--

CREATE TABLE `gaji` (
  `nip` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `gaji` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `gaji`
--

INSERT INTO `gaji` (`nip`, `nama`, `jabatan`, `gaji`) VALUES
('10003', 'andre', 'Kepala Sekolah', '4.000.000'),
('11', 'qq', 'Guru Kejuruan', '123456');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kehadiran`
--

CREATE TABLE `kehadiran` (
  `nip` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jabatan` varchar(100) NOT NULL,
  `absen` enum('Hadir','Sakit','Izin','Alpa') NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kehadiran`
--

INSERT INTO `kehadiran` (`nip`, `nama`, `jabatan`, `absen`, `keterangan`) VALUES
('110001', 'qww', 'Guru umum', 'Hadir', 'as'),
('1234', 'asd', 'Guru umum', 'Hadir', 'asd');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
--

CREATE TABLE `pegawai` (
  `nip` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jk` enum('Laki-laki','Perempuan') NOT NULL,
  `ttl` varchar(50) NOT NULL,
  `agama` varchar(10) NOT NULL,
  `no_sk` varchar(20) NOT NULL,
  `ijazah` varchar(100) NOT NULL,
  `no_telp` varchar(12) NOT NULL,
  `jabatan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`nip`, `nama`, `jk`, `ttl`, `agama`, `no_sk`, `ijazah`, `no_telp`, `jabatan`) VALUES
('10001', 'dewi', 'Perempuan', 'tapi, 24 jun 2000', 'Islam', '1234RFG', 'SMK', '123456789', 'Guru Kejuruan'),
('as', 'ad', 'Perempuan', 'ds', 'Islam', 'sd', 'xzc', 'sd', 'Guru Kejuruan'),
('asa', 'asss', 'Laki-laki', 'aaa', 'Islam', 'aaaa', 'ssss', 'aaa', 'Kepala Sekolah'),
('asdf', 'ddd', 'Perempuan', 'dddd', 'Kristen', 'dddss', 'ssss', 'dddd', 'Guru Kejuruan');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `gaji`
--
ALTER TABLE `gaji`
  ADD PRIMARY KEY (`nip`);

--
-- Indeks untuk tabel `kehadiran`
--
ALTER TABLE `kehadiran`
  ADD PRIMARY KEY (`nip`);

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`nip`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
