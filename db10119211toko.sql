-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 26, 2021 at 05:03 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db10119211toko`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `harga` int(11) NOT NULL,
  `stok` int(11) NOT NULL,
  `id_supplier` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `harga`, `stok`, `id_supplier`) VALUES
(1, 'Coklat SQ 1KG', 1000000, 1000, 1),
(2, 'Indomie Ayam Bawang', 5000, 1000, 4),
(3, 'Indomie Rendang', 5500, 1000, 4),
(4, 'Sanco 650ML', 10000, 500, 6),
(5, 'Mie Sedap Ayam B', 4000, 700, 6),
(6, 'Chicken Nuggets', 25000, 2000, 1),
(7, 'Chicken Wings 10pcs', 50000, 100, 3),
(8, 'Rinso Anti Noda 900G', 12000, 200, 12),
(9, 'Attack Softener 900G', 13500, 250, 10),
(10, 'Tropical 1LT', 11000, 500, 23),
(11, 'Bimoli 2LT', 25500, 900, 24),
(12, 'Sun Light 800ML', 16000, 450, 22),
(13, 'Molto Ultra Biru 300', 7500, 1000, 20),
(14, 'Molto Softener Bloss', 9500, 850, 20),
(15, 'Pepsodent Whitening ', 9000, 450, 15),
(16, 'Close Up Menthol', 8500, 100, 16),
(17, 'Biore Healthy Plus', 8500, 750, 18),
(18, 'Lifebuoy Nature Pure', 8800, 1250, 21),
(19, 'Supermi Gokar', 1200, 1000, 23),
(20, 'Kapal Api Spesial', 8600, 780, 11),
(21, 'So Good Chicken Katu', 23000, 680, 25),
(22, 'Fiesta Nugget', 21500, 350, 19),
(23, 'Goldstar Karaage', 30500, 170, 17),
(24, 'Champ Chicken Nugget', 19600, 840, 16),
(25, 'Kanzler', 9000, 960, 14);

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` int(11) NOT NULL,
  `tgl_bayar` date NOT NULL,
  `total_bayar` int(20) NOT NULL,
  `id_transaksi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `tgl_bayar`, `total_bayar`, `id_transaksi`) VALUES
(1, '2021-01-01', 80000, 1),
(2, '2021-07-26', 1000000, 2),
(3, '2021-07-26', 5500, 3),
(4, '2021-07-26', 25000, 6),
(5, '2021-07-26', 4000, 5),
(6, '2021-07-26', 50000, 7),
(7, '2021-07-26', 10000, 4),
(8, '2021-07-26', 4000, 8),
(9, '2021-01-02', 160000, 20),
(10, '2021-01-03', 90000, 16),
(11, '2021-01-04', 230000, 11),
(12, '2021-01-05', 540000, 22),
(13, '2021-01-03', 780000, 25),
(14, '2021-01-09', 340000, 24),
(15, '2021-01-08', 55000, 19),
(16, '2021-01-02', 89000, 23),
(17, '2021-01-10', 600000, 21),
(18, '2021-01-16', 300000, 17),
(19, '2021-01-06', 455000, 15),
(20, '2021-01-07', 620000, 13),
(21, '2021-01-13', 345000, 14),
(22, '2021-01-08', 980000, 9),
(23, '2021-01-04', 565000, 10),
(24, '2021-01-06', 230000, 14),
(25, '2021-01-01', 270000, 22);

-- --------------------------------------------------------

--
-- Table structure for table `pembeli`
--

CREATE TABLE `pembeli` (
  `id_pembeli` int(11) NOT NULL,
  `nama_pembeli` varchar(20) NOT NULL,
  `jk` enum('Laki-laki','Perempuan') NOT NULL,
  `no_telp` varchar(14) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pembeli`
--

INSERT INTO `pembeli` (`id_pembeli`, `nama_pembeli`, `jk`, `no_telp`, `alamat`) VALUES
(1, 'Badra S', 'Laki-laki', '081281817375', 'Ciamis, Jawa Barat'),
(2, 'Daffa A', 'Laki-laki', '089423242532', 'Jl. Sekeloa 32'),
(3, 'Nuraeni Eka', 'Perempuan', '08742323525', 'Jl. Gatsu 24'),
(4, 'Ferdi Bayu', 'Laki-laki', '08492423234', 'Jl. Raya Cikole 421'),
(5, 'Kartika', 'Perempuan', '08742352323', 'Jl. Tubagus Ismail Dalam'),
(6, 'Mya Hauliyah', 'Perempuan', '08327423532', 'Jl. Raya Malangbong 32'),
(7, 'Salma', 'Perempuan', '0895721582', 'Jl. Mangga Dua No. 29'),
(8, 'badrudin', 'Laki-laki', '081223064743', 'jl. Cikalong no 32'),
(9, 'Ayunda', 'Perempuan', '081223054331', 'jl. Daan Mogot IV'),
(10, 'Tedi', 'Laki-laki', '081223054332', 'jl. M.H Thamrin'),
(11, 'Deris', 'Perempuan', '081223054333', 'jl. Veteran no 5'),
(12, 'Saepul', 'Laki-laki', '081223054334', 'jl. Jend. A. Yani'),
(13, 'Novi', 'Perempuan', '081223054335', 'jl. Ranca Tengah no 99'),
(14, 'Chintia', 'Laki-laki', '081223054336', 'jl. Dewi Sartika no 65'),
(15, 'Rifki', 'Perempuan', '081223054337', 'jl. Pegangsaan Timur'),
(16, 'Shupita', 'Laki-laki', '081223054338', 'jl. Bumi Asri no 23'),
(17, 'Naufal', 'Perempuan', '081223054339', 'jl. Pasir Mas no 7'),
(18, 'Arina', 'Laki-laki', '081223054310', 'jl. Medan Merdeka no 33'),
(19, 'Bambang', 'Perempuan', '081223054311', 'jl. Suka Mulya Indah'),
(20, 'Shuviatul', 'Perempuan', '081223054312', 'jl. Setia Budi no 40'),
(21, 'Fathoni', 'Perempuan', '081223054313', 'jl. Salemba Raya'),
(22, 'Tsania', 'Perempuan', '081223054314', 'jl. Cikutra Barat no 2'),
(23, 'Ujang', 'Perempuan', '081223054315', 'jl. Siliwangi no 15'),
(24, 'Mahmud', 'Laki-laki', '081223054316', 'jl. Supratman no 81'),
(25, 'Tsania', 'Perempuan', '0812230543317', 'jl. Pangeran no 11');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` int(11) NOT NULL,
  `nama_supplier` varchar(30) NOT NULL,
  `no_telp` varchar(14) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `nama_supplier`, `no_telp`, `alamat`) VALUES
(1, 'PT. Aksara Group', '081281817375', 'Jl. Raya Panumbangan No. 62'),
(2, 'PT. Angkasa', '81222321832', 'Jl. Dago 77'),
(3, 'PT. Starixa', '0821312767321', 'Jakarta, Indonesia'),
(4, 'PT. Indofood', '081324322352', 'Jakarta, Indonesia'),
(5, 'PT. Wings', '089132112423', 'Jl. Pahlawan 2, Bekasi'),
(6, 'PT. HolyGroup', '08253259235', 'Jl. Sudirman 412, Jakarta'),
(7, 'PT.Jaya Utama Santikah', '02155727787', 'SMART MARKET blok b no. 8 Kota Tangerang'),
(8, 'PT. Khalifa Global Indonesia', '02122379679', 'Jl. Pejaten Raya No. 7 Jakarta Selatan'),
(9, 'PT Abdi Darma', '0214700008', 'Jl Pulo Nangka Tmr II 14 Jakarta'),
(10, 'PT. Adibella Nugraha', '0216459206', 'Jl Danau Agung Sunter Brt Bl A-4/5 Jakarta'),
(11, 'PT. Agrofood Propranindo', '0215643017', 'Kompl Green Ville Bl AW/8 Jakarta'),
(12, 'PT. Aldima Baruna Kencana', '02143902024', 'Jl Enggano 73 Jakarta'),
(13, 'PT. Alexandi Century Transport', '0214529016', 'Jl Boulevard Bl TB-2/31-32-33'),
(14, 'PT. Alison Agung', '0216294630', 'Jl Boulevard Bl TB-2/31-32-33'),
(15, 'PT. Aneka Rasa Citra Sejati', '02143911446', 'Jl Daan Mogot Kav B/6 Jakarta'),
(16, 'PT. Asia Indah Makmur Trust', '02151402240', 'Jl Jend Sudirman Kav 59 Plaza ABDA Lt 15 Jakarta'),
(17, 'PT. Sari Husada Tbk', '0227568158', 'Jl Soekarno Hatta 606 Bandung'),
(18, 'PT. Sawon', '0226033511', 'Jl Maleber Brt 6 Bandung'),
(19, 'PT. Smart Tbk', '02270800277', 'Jl Raya Cinunuk 274 RT 001/20 Bandung'),
(20, 'PT. Indo Marco', '0226040146', 'Jl Peta Lingkar Selatan Ruko Kopo Plaza Blok C/22 Bandung'),
(21, 'PT. Charisfood', '0216456333', 'Jl Laks L RE Martadinata Ruko Permata Ancol Bl M/1 Jakarta 33'),
(22, 'PT. Pangan Mitra Makmur', '0225402339', 'Komplek Perum Kopo Permai II Blok 6-AR/3-5 Bandung'),
(23, 'PT. Panindo Eka Tama', '0222033115', 'Jl Dr Setiabudi 64 Bandung Jabar'),
(24, 'PT. Panjunan Perkasa Jaya', '0225400850', 'Jl Cibolerang 18 Bandung'),
(25, 'PD. Taruna Boga', '02270144078', 'Jl. Sanggar Kencana Bandung 33');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `id_pembeli` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_barang`, `id_pembeli`, `tanggal`, `keterangan`) VALUES
(1, 7, 11, '2018-09-01', 'LUNAS'),
(2, 1, 1, '2021-07-25', 'LUNAS'),
(3, 3, 2, '2021-07-26', 'LUNAS'),
(4, 4, 5, '2021-07-26', 'LUNAS'),
(5, 5, 3, '2021-07-26', 'LUNAS'),
(6, 6, 6, '2021-07-26', 'LUNAS'),
(7, 7, 4, '2021-07-26', 'LUNAS'),
(8, 5, 4, '2021-07-26', 'LUNAS'),
(9, 25, 3, '2021-01-03', 'LUNAS'),
(10, 16, 17, '2021-07-13', 'LUNAS'),
(11, 11, 18, '2021-03-15', 'LUNAS'),
(12, 20, 10, '2021-05-27', 'LUNAS'),
(13, 16, 2, '2021-07-15', 'LUNAS'),
(14, 13, 15, '2021-04-13', 'LUNAS'),
(15, 22, 12, '2021-03-17', 'LUNAS'),
(16, 9, 5, '2021-06-12', 'LUNAS'),
(17, 14, 13, '2021-01-12', 'LUNAS'),
(18, 21, 16, '2021-06-09', 'LUNAS'),
(19, 11, 11, '2021-04-23', 'LUNAS'),
(20, 19, 14, '2021-01-26', 'LUNAS'),
(21, 17, 23, '2021-02-19', 'LUNAS'),
(22, 7, 19, '2021-05-27', 'LUNAS'),
(23, 8, 20, '2021-07-25', 'LUNAS'),
(24, 14, 22, '2021-12-28', 'LUNAS'),
(25, 15, 24, '2021-08-18', 'LUNAS');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD KEY `id_supplier` (`id_supplier`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD KEY `id_transaksi` (`id_transaksi`);

--
-- Indexes for table `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`id_pembeli`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_pembeli` (`id_pembeli`),
  ADD KEY `id_barang` (`id_barang`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id_pembayaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `pembeli`
--
ALTER TABLE `pembeli`
  MODIFY `id_pembeli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `id_supplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_pembeli`) REFERENCES `pembeli` (`id_pembeli`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
