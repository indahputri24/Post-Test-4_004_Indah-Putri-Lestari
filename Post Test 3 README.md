# Post Test 3 PBO

Nama: Indah Putri Lestari

NIM: 2409116004

Kelas: A'2024

# Alur Program

## Package Model

<img width="478" height="144" alt="image" src="https://github.com/user-attachments/assets/486200fa-cef2-4a6f-8de8-f027d922db8d" />

1. Class Parkir menjadi kelas induk (Superclass) yang menyimpan atribut umum setiap kendaraan parkir. Semua atribut bersifat private dan diakses melalui getter dan setter (menerapkan encapsulation). Serta menyediakan method seperti:
- setKeluarHitung() untuk mencatat jam keluar, durasi, dan biaya.
- hitungBiaya(long jam) sebagai method dasar yang dapat di override.

2. Class ParkirMobil (Subclass) menggunakan extends Parkir sehingga mewarisi semua atribut dan method dari Parkir. Konstruktor memanggil super() untuk menginisialisasi field induk. Menggunakan @Override pada hitungBiaya(long jam) agar tarif khusus 5000/jam otomatis diterapkan untuk kendaraan mobil.

3. Class ParkirMotor (Subclass) sama seperti subclass ParkirMobil, namun yang berbeda hanya tarif khusus 3000/jam, dan juga mengoverride hitungBiaya(long jam).

## Tambah Data Parkir

<img width="1081" height="555" alt="image" src="https://github.com/user-attachments/assets/5fba5a70-e00e-4864-a17b-8420ac746cc8" />

Pada menu Tambah Data, setelah validasi input, program membuat objek model melalui method factory objekParkir(). Method ini memeriksa jenis kendaraan dan mengembalikan objek ParkirMobil atau ParkirMotor yang extends Parkir. Dengan cara ini, seluruh data tetap disimpan di ArrayList<Parkir>, namun setiap entri sudah berupa subclass yang sesuai. Perubahan ini menggantikan cara sebelumnya yang selalu memakai new Parkir(...) dan untuk menjadi penerapan inheritance dan overriding, karena proses perhitungan tarif di tahap berikutnya akan otomatis menyesuaikan jenis kendaraan melalui method hitungBiaya() yang dioverride di masing-masing subclass.

## Perbarui Data Parkir - Blok Lokasi

### Sebelum Perbarui Blok Lokasi pada ID Tiket 0005

<img width="1305" height="497" alt="Cuplikan layar 2025-09-21 203503" src="https://github.com/user-attachments/assets/87f9afd1-5be5-45b6-a282-8ce2a52633bc" />

### Proses Perbarui Blok Lokasi

<img width="1033" height="976" alt="image" src="https://github.com/user-attachments/assets/a154ca3f-561e-4933-91a4-ceef13b54688" />

Pada menu Perbarui Blok Lokasi, pengguna memilih ID 5 lalu mengubah blok parkir dari E1 menjadi C3. Jika inputan valid, ParkingService memanggil setter setBlok() pada objek data parkir. Karena atribut blok di kelas Parkir bersifat private, nilainya tidak dapat diubah secara langsung, perubahan hanya bisa dilakukan melalui method setter tersebut.

### Setelah Perbarui Blok Lokasi pada ID Tiket 0005

<img width="1292" height="507" alt="image" src="https://github.com/user-attachments/assets/3e780823-87e8-48a6-81d9-fc46958861a1" />

Data blok kendaraan berhasil diperbarui dari E1 menjadi C3 pada ID 0005.

## Perbarui Data Parkir - Jam Keluar

### Sebelum Perbarui Jam Keluar pada ID Tiket 0001

<img width="1299" height="510" alt="image" src="https://github.com/user-attachments/assets/9b84c1eb-5ca3-4240-b677-893855f4e962" />

### Proses Perbarui Jam Keluar pada ID 0001

<img width="985" height="1051" alt="image" src="https://github.com/user-attachments/assets/2e398e81-f0d2-4632-86f6-ff620f5bae8b" />

Pada menu Perbarui (Jam Keluar & Hitung Biaya) untuk kendaraan Mobil, program menghitung lama parkir dari selisih jam masuk dan jam keluar menggunakan Duration.between(masuk, keluar), kemudian membulatkannya ke atas ke satuan jam minimal 1 jam dengan rumus (menit + 59) / 60 dan Math.max(1, ...) (selisih 08:10 - 12:35 menjadi 5 jam). Setelah menerapkan inheritance dan overriding, perhitungan tarif tidak lagi dilakukan di ParkingService, melainkan cukup memanggil posisi.hitungBiaya(jamBulatKeAtas). Method ini dioverride di ParkirMobil sehingga biaya parkir langsung dihitung dengan perkalian jamBulatKeAtas × 5000 (5 jam × 5000 = Rp25.000). Selain mengembalikan nilai biaya, method override di ParkirMobil juga menampilkan informasi ke konsol, seperti pesan “>> Menghitung biaya untuk kendaraan Mobil KT4959IO . . .”, durasi parkir dalam jam, dan total biaya parkir. Hasil akhir berupa jam keluar, durasi, dan biaya kemudian disimpan melalui setter setKeluarHitung(...).

### Sesudah Perbarui Jam Keluar pada ID Tiket 0001

<img width="1302" height="500" alt="image" src="https://github.com/user-attachments/assets/5991e5d1-2756-44c3-a018-4a7da8bc390a" />

Data kendaraan Mobil dengan ID 0001 berhasil diperbarui, jam keluar tercatat 12:35 dengan durasi 265 menit dan total biaya parkir Rp25.000.

###

### Sebelum Perbarui Jam Keluar pada ID Tiket 0004

<img width="1286" height="499" alt="image" src="https://github.com/user-attachments/assets/4a19c78c-51ac-4973-a1d7-ec4e64ba2bee" />

### Proses Perbarui Jam Keluar pada ID 0004

<img width="1004" height="1059" alt="image" src="https://github.com/user-attachments/assets/bcc71e61-0b8a-48dc-8cc3-efa4e6aed21c" />

Pada menu Perbarui (Jam Keluar & Hitung Biaya) untuk Motor, program menghitung selisih 09:20–16:00 menjadi 7 jam, lalu memanggil hitungBiaya() yang dioverride di ParkirMotor untuk menghitung biaya 7 × 3000 = Rp21.000. Jam keluar, durasi, dan biaya disimpan melalui setKeluarHitung().

### Sesudah Perbarui Jam Keluar pada ID Tiket 0004

<img width="1283" height="502" alt="image" src="https://github.com/user-attachments/assets/282c532e-59a8-4ffa-a029-859e2c9fc084" />

Data kendaraan Motor dengan ID 0004 berhasil diperbarui, jam keluar tercatat 16.00 dengan durasi 400 menit dan total biaya parkir Rp21.000.
