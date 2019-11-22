-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2019 at 03:35 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

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
  `virtual_acc` varchar(18) NOT NULL DEFAULT '0',
  `saldo` int(11) NOT NULL,
  `password` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nasabah`
--

INSERT INTO `nasabah` (`nasabah_id`, `name`, `no_rek`, `virtual_acc`, `saldo`, `password`) VALUES
(1, 'lukas', '1234567890', '0123456789', 100000, 'password'),
(2, 'andy', '2234567890', '0', 200000, 'password');

-- --------------------------------------------------------

--
-- Table structure for table `nasabah_vaccount`
--

CREATE TABLE `nasabah_vaccount` (
  `id` int(11) NOT NULL,
  `nasabah_id` int(11) NOT NULL,
  `virtual_acc` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nasabah_vaccount`
--

INSERT INTO `nasabah_vaccount` (`id`, `nasabah_id`, `virtual_acc`) VALUES
(1, 1, '57358423753'),
(2, 1, '2137557786'),
(1, 1, '471893369775643');

-- --------------------------------------------------------

--
-- Table structure for table `transaction_data`
--

CREATE TABLE `transaction_data` (
  `txn_id` int(11) NOT NULL,
  `nasabah_id` int(11) NOT NULL,
  `jenis_transaksi` tinyint(1) NOT NULL,
  `jumlah_transaksi` int(11) NOT NULL,
  `no_terkait` varchar(18) NOT NULL,
  `timestamp` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction_data`
--

INSERT INTO `transaction_data` (`txn_id`, `nasabah_id`, `jenis_transaksi`, `jumlah_transaksi`, `no_terkait`, `timestamp`) VALUES
(1, 1, 1, 30000, '2234567890', '2019-11-21 10:48:32'),
(2, 1, 1, 50000, '2234567890', '2019-11-21 10:48:32'),
(3, 2, 1, 100000, '123456789', '2019-11-21 10:48:32'),
(4, 2, 1, 5000, '123456789', '2019-11-21 10:48:32');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `nasabah`
--
ALTER TABLE `nasabah`
  ADD PRIMARY KEY (`nasabah_id`);

--
-- Indexes for table `transaction_data`
--
ALTER TABLE `transaction_data`
  ADD PRIMARY KEY (`txn_id`),
  ADD KEY `foreign_key_nasabah` (`nasabah_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nasabah`
--
ALTER TABLE `nasabah`
  MODIFY `nasabah_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `transaction_data`
--
ALTER TABLE `transaction_data`
  MODIFY `txn_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaction_data`
--
ALTER TABLE `transaction_data`
  ADD CONSTRAINT `foreign_key_nasabah` FOREIGN KEY (`nasabah_id`) REFERENCES `nasabah` (`nasabah_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
