-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2024 at 04:20 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubes_pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `book_title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `publication_year` varchar(255) NOT NULL,
  `genre` varchar(100) NOT NULL,
  `category` varchar(100) NOT NULL,
  `rating` double NOT NULL,
  `sinopsis` text NOT NULL,
  `book_status` varchar(50) NOT NULL,
  `book_cover` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `book_title`, `author`, `publication_year`, `genre`, `category`, `rating`, `sinopsis`, `book_status`, `book_cover`) VALUES
(1, 'Harry Potter', 'JK. Rowling', '1998', 'Fantasy', 'Novel', 8.9, 'Bercerita tentang penyihir', 'Completed', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\pictures\\novel\\Harry Potter.jpg'),
(2, 'Jujutsu Kaisen', 'Gege Akutami', '2017', 'Fantasy', 'Comic', 8.3, 'Seorang anak SMA yang memakan kutukan', 'Ongoing', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\pictures\\comic\\Jujutsu Kaisen.jpg'),
(3, 'Sherlock Holmes - A Study In Scarlet', 'Sir Arthur Conan Doyle', '1880', 'Mystery', 'Novel', 8.5, 'Ini sinopsis', 'Completed', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\pictures\\novel\\Sherlock Holmes.jpg'),
(4, 'One Piece', 'Oda', '1990', 'Action', 'Comic', 8.5, 'Bajak Laut', 'Ongoing', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\pictures\\comic\\One Piece.jpg'),
(5, 'Black Butler', 'Yana Toboso', '2006', 'Fantasy', 'Comic', 7.8, 'Bercerita tentang anak yang membuat kontrak dengan iblis', 'Ongoing', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\pictures\\comic\\Black Butler.jpg'),
(8, 'Bumi', 'Tere Liye', '2014', 'Fantasy', 'Novel', 8.7, 'Bercerita tentang dunia paralel', 'Completed', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\pictures\\novel\\Bumi.jpg'),
(9, 'The ABC Murders', 'Agatha Christie', '1936', 'Mystery', 'Novel', 8.4, 'Detektif bernama Hercule Poirot mendapat surat berisi inisial ABC', 'Completed', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\pictures\\novel\\The ABC Murders.jpg'),
(10, 'Kimetsu no Yaiba', 'Koyoharu Gotoge', '2016', 'Fantasy', 'Comic', 8.5, 'Bercerita tentang pemburu iblis', 'Ongoing', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\pictures\\comic\\Kimetsu no Yaiba.jpg'),
(11, 'Dreaming Freedom', '2L', '2022', 'Thriller', 'Comic', 7.9, 'Seorang anak SMA dibully dan ingin balas dendam', 'Ongoing', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\pictures\\comic\\Dreaming Freedom.jpg'),
(12, 'Ao Haru Ride', 'Io Sakisaka', '2011', 'Romance', 'Comic', 7.5, 'Kisah percintaan anak SMA', 'Ongoing', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\pictures\\comic\\Ao Haru Ride.jpg'),
(13, 'Tower Of God', 'SIU', '2010', 'Action', 'Comic', 8, 'Bercerita tentang seorang anak yang menaiki menara', 'Ongoing', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\pictures\\comic\\Tower Of God.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `chapter`
--

CREATE TABLE `chapter` (
  `chapter_id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `chapter_title` varchar(255) DEFAULT NULL,
  `chapter_content` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chapter`
--

INSERT INTO `chapter` (`chapter_id`, `book_id`, `chapter_title`, `chapter_content`) VALUES
(1, 1, 'Chapter 1', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\teks.txt'),
(2, 4, 'Episode 1', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\teks.txt'),
(3, 1, 'Chapter 2', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\teks.txt'),
(4, 2, 'Episode 1', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\teks.txt'),
(5, 10, 'Episode 1', 'D:\\Documents\\Kuliah\\Semester pendek\\PBO\\Tubes\\teks.txt');

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL,
  `id` int(11) DEFAULT NULL,
  `chapter_id` int(11) DEFAULT NULL,
  `comment_content` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`comment_id`, `id`, `chapter_id`, `comment_content`) VALUES
(1, 2, 1, 'Ceritanya bagus'),
(2, 3, 1, 'Ceritanya seru!!'),
(3, 5, 1, 'Seru banget'),
(4, 4, 1, 'Bagus!!'),
(5, 2, 2, 'Seru...!!'),
(6, 3, 5, 'Asik!!');

-- --------------------------------------------------------

--
-- Table structure for table `favorite`
--

CREATE TABLE `favorite` (
  `favorite_id` int(11) NOT NULL,
  `id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `favorite`
--

INSERT INTO `favorite` (`favorite_id`, `id`, `book_id`) VALUES
(1, 2, 1),
(2, 2, 4),
(4, 2, 3),
(6, 3, 1),
(7, 3, 2),
(9, 5, 3),
(10, 4, 10),
(11, 4, 4);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `username`, `email`, `password`, `status`) VALUES
(1, 'admin', 'admin@gmail.com', 'admin', 'admin'),
(2, 'kath', 'kath@gmail.com', '12345', 'user'),
(3, 'rin', 'rin@gmail.com', '54321', 'user'),
(4, 'john', 'john@gmail.com', 'john', 'user'),
(5, 'user', 'user@gmail.com', 'user', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `schedule_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `day` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`schedule_id`, `book_id`, `day`) VALUES
(1, 2, 'Selasa'),
(2, 4, 'Senin'),
(3, 5, 'Rabu'),
(4, 10, 'Kamis'),
(5, 11, 'Jumat'),
(6, 12, 'Sabtu'),
(7, 13, 'Minggu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `chapter`
--
ALTER TABLE `chapter`
  ADD PRIMARY KEY (`chapter_id`),
  ADD KEY `book_id` (`book_id`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `id` (`id`),
  ADD KEY `chapter_id` (`chapter_id`);

--
-- Indexes for table `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY (`favorite_id`),
  ADD KEY `id` (`id`),
  ADD KEY `book_id` (`book_id`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`schedule_id`),
  ADD KEY `book_id` (`book_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `chapter`
--
ALTER TABLE `chapter`
  MODIFY `chapter_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `comment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `favorite`
--
ALTER TABLE `favorite`
  MODIFY `favorite_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `schedule_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chapter`
--
ALTER TABLE `chapter`
  ADD CONSTRAINT `chapter_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`);

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`chapter_id`);

--
-- Constraints for table `favorite`
--
ALTER TABLE `favorite`
  ADD CONSTRAINT `favorite_ibfk_1` FOREIGN KEY (`id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `favorite_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`);

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `schedule_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
