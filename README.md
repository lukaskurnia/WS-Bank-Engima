# Tugas 2 IF3110 Pengembangan Aplikasi Berbasis Web

## 1. Deskripsi Web Service

Web service Bank diimlementasikan di atas java servlet menggunakan JAX-WS dengan protokol SOAP. Web service ini digunakan untuk Aplikasi Bank Pro dan Engima.

Web service Bank memiliki basis data terpisah dari basis data Engima yang terdiri dari data nasabah dan transaksi rekening setiap bank (lihat daftar bank di Aplikasi Bank) Bank Pro. Informasi rekening yang disimpan adalah nama pemilik, nomor rekening, dan nomor akun virtual (jika ada). Nomor akun virtual untuk satu rekening bisa lebih dari satu. Informasi transaksi yang disimpan adalah id nasabah, jenis transaksi (debit/kredit), jumlah transaksi, nomor yang terkait (rekening atau akun virtual, jika ada), dan waktu transaksi.

Layanan yang disediakan oleh web service ini adalah:
Validasi nomor rekening. Jika nomor rekening terdaftar di basis data, maka nomor tersebut valid.
Memberikan data rekening seorang nasabah. Data pengguna meliputi nama pengguna, nomor kartu nomor rekening, saldo terakhir, dan riwayat transaksi (debit dan kredit).
Melakukan transaksi transfer dengan input nomor rekening pengirim, nomor rekening/akun virtual penerima, dan jumlah uang yang ditransfer. Layanan mengembalikan status transfer (berhasil/gagal). Transfer berhasil jika:
Nomor rekening atau akun virtual tujuan valid
Saldo rekening mencukupi untuk transaksi
Jika transfer berhasil, akan dicatat transaksi debit pada rekening pengirim dan transaksi kredit pada rekening penerima.
Membuat akun virtual untuk suatu nomor rekening. Layanan mengembalikan nomor unik akun virtual tersebut.
Mengecek ada atau tidak sebuah transaksi kredit dalam suatu rentang waktu. Input yang diterima adalah nomor rekening atau akun virtual tujuan, jumlah nominal yang diharapkan, dan jangka waktu (dalam menit) rentang waktu (start datetime, end datetime).

## 2. Basis Data

Basis data yang digunakan untuk web service transaksi ini adalah mysql dengan nama basis data adalah ws_bank. Isi dari basis data tersebut adalah tabel nasabah(id nasabah, nama nasabah, no. rekening nasabah, saldo, dan password), nasaah_vaccount(id, id nasabah, dan virtual account), transaction_data(id transaction, no rekening, jenis transaksi, jumlah transaksi, no rekening tujuan, waktu transaksi dilakukan).

## 3. Pembagian Tugas DPPL

1. CI/CD: 13517084
2. Eksplorasi dan setup mesin deployment: 13517006, 13517084

## 4. URL Deployment

Berikut ini merupakan URL yang digunakan untuk mendeploy ws_bank.
http://3.83.30.182:8081/ws-bank-1.0-SNAPSHOT/services/ValidateRekening