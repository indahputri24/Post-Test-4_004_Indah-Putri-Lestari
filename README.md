# Post Test 4 Praktikum PBO

Nama: Indah Putri Lestari

NIM: 2409116004

Kelas: A'2024

# Alur Program

## Abstract Class

<img width="404" height="71" alt="image" src="https://github.com/user-attachments/assets/c085a2fd-2fc5-4f87-b522-f64c9afe52fe" />

File model/CetakLaporan.java dibuat untuk menampung kerangka atau cetakan dasar laporan parkir. Di dalamnya hanya terdapat definisi method cetakRingkas() tanpa isi (body). Class ini tidak dapat dibuat menjadi objek langsung, tetapi tetapi bisa diwariskan ke class Parkir.

### Class Parkir yang mengimplementasikan

<img width="938" height="303" alt="image" src="https://github.com/user-attachments/assets/beeeccd5-8e1c-4535-b846-3f7a715bbfb9" />

Di dalam class Parkir, method cetakRingkas() merupakan implementasi (override) dari method abstrak cetakRingkas() yang didefinisikan di abstract class CetakLaporan. Method ini menuliskan cara menampilkan ringkasan data parkir, yaitu menampilkan ID tiket, plat kendaraan, dan biaya parkir. Dengan memberikan isi seperti ini, Parkir memenuhi kontrak yang diwajibkan oleh CetakLaporan, sehingga setiap objek Parkir (termasuk ParkirMobil dan ParkirMotor) dapat memanggil cetakRingkas() untuk menampilkan ringkasan data.

## Interface

<img width="404" height="104" alt="image" src="https://github.com/user-attachments/assets/3fe15da2-354b-4f87-b584-f7926a535801" />

File model/InfoKendaraan.java dibuat sebagai kontrak yang mewajibkan setiap kelas yang mengimplementasikannya wajib menuliskan sendiri cara kerja method cetakInfo(). Di dalamnya hanya terdapat definisi method cetakInfo() tanpa isi (body).

### Class Parkir yang mengimplementasikan

<img width="1535" height="200" alt="image" src="https://github.com/user-attachments/assets/59347139-fc79-499f-8ef5-10e7a311d432" />

Di dalam class Parkir, method cetakInfo() merupakan implementasi (override) dari method cetakInfo() yang dideklarasikan di interface InfoKendaraan. Isi method ini menampilkan informasi kendaraan, yaitu teks “Kendaraan <plat> berada di blok <blok>” dengan mengambil nilai plat dan blok melalui getPlat() dan getBlok(). Dengan cara ini, Parkir memenuhi kontrak yang diberikan oleh InfoKendaraan dan memungkinkan setiap objek Parkir memanggil cetakInfo() untuk menampilkan keterangan kendaraan.

## Overloading

<img width="1229" height="899" alt="image" src="https://github.com/user-attachments/assets/af0aa27c-280d-4207-9a0e-65b76a25bdd1" />

Pada method cariData, terdapat dua method bernama sama tetapi berbeda parameter. Method cariData(int idTiket) digunakan untuk mencari data parkir berdasarkan ID tiket dan hanya mengembalikan satu objek Parkir atau null jika tidak ditemukan. Sedangkan cariData(String kata) digunakan untuk mencari data berdasarkan plat atau jenis kendaraan dan mengembalikan ArrayList<Parkir> karena hasilnya bisa lebih dari satu, termasuk pencarian sebagian kata seperti “mo” untuk semua motor. 

## Override

<img width="1489" height="299" alt="image" src="https://github.com/user-attachments/assets/2b2a8cd5-9940-4e3e-9f63-2d11216c9b0d" />

Pada class ParkirMotor, method hitungBiaya(long jamBulatKeAtas) yang berada di class Parkir ditulis ulang (override) untuk menghitung biaya parkir khusus kendaraan motor. Di dalamnya ditampilkan informasi perhitungan seperti plat kendaraan, durasi parkir, dan biaya akhir, kemudian biaya dihitung dengan rumus jamBulatKeAtas * 3000. Dengan cara ini setiap objek ParkirMotor akan otomatis menggunakan tarif Rp3.000 per jam ketika method hitungBiaya() dipanggil.

<img width="1489" height="307" alt="image" src="https://github.com/user-attachments/assets/9b36d89a-82f2-41a8-9e66-8ea66038ff8f" />

Pada class ParkirMobil, method hitungBiaya(long jamBulatKeAtas) yang berada di class Parkir juga dioverride untuk menyesuaikan tarif khusus kendaraan mobil. Sama seperti pada motor, method ini menampilkan rincian perhitungan namun biaya dihitung dengan tarif jamBulatKeAtas * 5000. Sehingga saat objek ParkirMobil menjalankan hitungBiaya(), perhitungan biaya parkir dilakukan dengan tarif Rp5.000 per jam.

## Output dari penerapan tersebut

### Pada Menu Cari Data Parkir

<img width="1303" height="1350" alt="Cuplikan layar 2025-09-27 202059" src="https://github.com/user-attachments/assets/b40f8dec-f895-4c3c-9adc-fa1375fb7e38" />

Pada menu 5 (Cari Data Parkir), pengguna memasukkan kata kunci pencarian “bil”. Program menampilkan semua data parkir yang jenis kendaraannya Mobil karena kata kunci “bil” cocok dengan sebagian teks Mobil. Data hasil pencarian ditampilkan dalam bentuk tabel, kemudian diikuti Ringkasan detail setiap hasil. Bagian ringkasan ini memanggil dua method yang berasal dari konsep abstraction:
- cetakInfo(), implementasi dari interface InfoKendaraan yang menampilkan keterangan “Kendaraan dengan plat KT5678CD berada di blok C1”.
- cetakRingkas(), implementasi dari abstract class CetakLaporan yang menampilkan ringkasan seperti ID, Plat, dan Biaya.
Selain itu, proses pencarian ini juga menerapkan polymorphism dengan overloading. Class ParkingService memiliki dua method cariData dengan parameter berbeda:
- cariData(int idTiket) untuk pencarian berdasarkan ID tiket dan mengembalikan satu objek.
- cariData(String kata) untuk pencarian berdasarkan plat atau jenis kendaraan dan mengembalikan banyak data dalam ArrayList<Parkir>.

### Pada Menu Perbarui Data Parkir

<img width="1001" height="1057" alt="image" src="https://github.com/user-attachments/assets/768825cf-64a6-4977-8c77-4606beb0bc10" />

Pada menu 3 (Perbarui Data Parkir), khususnya menu Jam Keluar (hitung biaya) untuk kendaraan Motor dengan ID 2 dan plat KT1234AB. Setelah pengguna memasukkan jam keluar 15:30, program menghitung lama parkir menjadi 7 jam dan biaya sebesar Rp21.000. Perhitungan ini dilakukan melalui pemanggilan method hitungBiaya() yang dioverride di subclass ParkirMotor dengan tarif 3.000 per jam (7 × 3000 = 21.000).

<img width="978" height="1060" alt="image" src="https://github.com/user-attachments/assets/b2e9293c-ff0b-466e-ab8a-bfe6c3d98880" />

Perbarui data pada menu Jam Keluar (hitung biaya) untuk kendaraan Mobil dengan ID 1 dan plat KT4959IO. Setelah pengguna memasukkan jam keluar 18:25, program menghitung lama parkir menjadi 11 jam dan biaya sebesar Rp55.000. Perhitungan ini dijalankan melalui method hitungBiaya() yang dioverride di subclass ParkirMobil dengan tarif Rp5.000 per jam (11 × 5000 = 55.000).
