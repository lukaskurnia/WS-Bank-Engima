-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 24, 2019 at 02:09 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ws_bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `nasabah`
--

CREATE TABLE `nasabah` (
  `nasabah_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `no_rek` varchar(18) NOT NULL,
  `saldo` int(11) NOT NULL DEFAULT '0',
  `password` varchar(18) NOT NULL DEFAULT 'password'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nasabah`
--

INSERT INTO `nasabah` (`nasabah_id`, `name`, `no_rek`, `saldo`, `password`) VALUES
(1, 'bioskopEngi', '1234567890', 975100, 'password'),
(2, 'andy', '2234567890', 224900, 'password'),
(3, 'lukas', '1231231231', 1000000, 'password');

-- --------------------------------------------------------

--
-- Table structure for table `nasabah_vaccount`
--

CREATE TABLE `nasabah_vaccount` (
  `id` int(11) NOT NULL,
  `nasabah_id` int(11) NOT NULL,
  `virtual_acc` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nasabah_vaccount`
--

INSERT INTO `nasabah_vaccount` (`id`, `nasabah_id`, `virtual_acc`) VALUES
(1, 1, '1231234589776890'),
(2, 1, '1231234589776892'),
(3, 1, '1231234589776894'),
(4, 1, '1231234589776888'),
(5, 1, '1231237707898484'),
(6, 1, '1231234521331470');

-- --------------------------------------------------------

--
-- Table structure for table `transaction_data`
--

CREATE TABLE `transaction_data` (
  `txn_id` int(11) NOT NULL,
  `no_rek` varchar(18) NOT NULL,
  `jenis_transaksi` varchar(6) NOT NULL,
  `jumlah_transaksi` int(11) NOT NULL,
  `no_terkait` varchar(18) NOT NULL,
  `transaction_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction_data`
--

INSERT INTO `transaction_data` (`txn_id`, `no_rek`, `jenis_transaksi`, `jumlah_transaksi`, `no_terkait`, `transaction_time`) VALUES
(1, '1234567890', 'DEBIT', 30000, '2234567890', '2019-11-21 10:48:32'),
(2, '1234567890', 'KREDIT', 50000, '2234567890', '2019-11-22 00:00:00'),
(3, '2234567890', 'KREDIT', 100000, '1234567890', '2019-11-21 10:48:32'),
(4, '1234567890', 'DEBIT', 5000, '1231234589776890', '2019-11-21 10:48:32'),
(5, '1234567890', 'DEBIT', 5000, '2234567890', '2019-11-24 07:51:39'),
(6, '2234567890', 'KREDIT', 5000, '1234567890', '2019-11-24 07:51:39'),
(7, '2234567890', 'DEBIT', 50000, '1234567890', '2019-11-24 07:52:35'),
(8, '1234567890', 'KREDIT', 50000, '2234567890', '2019-11-24 07:52:35'),
(9, '2234567890', 'DEBIT', 100, '1234567890', '2019-11-24 07:53:17'),
(10, '1234567890', 'KREDIT', 100, '2234567890', '2019-11-24 07:53:17');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `nasabah`
--
ALTER TABLE `nasabah`
  ADD PRIMARY KEY (`nasabah_id`),
  ADD UNIQUE KEY `no_rek` (`no_rek`);

--
-- Indexes for table `nasabah_vaccount`
--
ALTER TABLE `nasabah_vaccount`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nasabah_id` (`nasabah_id`);

--
-- Indexes for table `transaction_data`
--
ALTER TABLE `transaction_data`
  ADD PRIMARY KEY (`txn_id`),
  ADD KEY `index` (`no_rek`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nasabah`
--
ALTER TABLE `nasabah`
  MODIFY `nasabah_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nasabah_vaccount`
--
ALTER TABLE `nasabah_vaccount`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `transaction_data`
--
ALTER TABLE `transaction_data`
  MODIFY `txn_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `nasabah_vaccount`
--
ALTER TABLE `nasabah_vaccount`
  ADD CONSTRAINT `nasabah_vaccount_ibfk_1` FOREIGN KEY (`nasabah_id`) REFERENCES `nasabah` (`nasabah_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
