# Post Test 2 PBO

Nama: Indah Putri Lestari

NIM: 2409116004

Kelas: A'2024

# Deskripsi Program

Program Sistem Parkir Kendaraan di Mall adalah program sederhana untuk mencatat data kendaraan yang parkir di mall dengan operasi CRUD (Create, Read, Update, Delete). Setiap data mencakup ID tiket otomatis, plat nomor, jenis kendaraan, blok parkir, serta jam masuk dan keluar. Program juga melakukan perhitungan durasi dan biaya parkir dengan tarif berbeda untuk mobil dan motor, serta validasi input seperti format plat dan jam.

# Struktur Packages

<img width="584" height="363" alt="image" src="https://github.com/user-attachments/assets/c18bc807-4ca0-46a8-a052-dc8a3f55a318" />

Arsitektur MVC (Model–View–Controller) membagi program menjadi tiga komponen utama agar terstruktur dan mudah dikelola. Model mengatur dan menyimpan data inti seperti informasi tiket parkir lengkap dengan atribut dan perhitungannya. View bertugas menampilkan menu, tabel, serta hasil proses kepada pengguna. Controller (Main) menjadi penghubung yang menerima input dari Main, memproses logika dan perhitungan pada Model, lalu mengirim hasilnya ke View.

## Model

<img width="426" height="79" alt="image" src="https://github.com/user-attachments/assets/a6772bdc-5b78-4cdc-8dfc-ab55f209f5fe" />

Package model berisi class Parkir yang bertugas merepresentasikan struktur data untuk setiap tiket parkir. Class ini menyimpan semua atribut seperti idTiket, plat nomor, jenis kendaraan, blok parkir, jam masuk, jam keluar, durasi parkir, dan biaya. Selain itu, class ini menyediakan getter dan setter untuk membaca dan mengubah nilai setiap atribut secara aman.

## View

<img width="534" height="78" alt="image" src="https://github.com/user-attachments/assets/17e6ba08-50f9-4bde-ab07-5bbfed941198" />

Package view berisi class ParkingView yang bertugas menampilkan informasi kepada pengguna. Class ini menangani tampilan menu, format tabel data parkir, dan pesan hasil proses seperti konfirmasi penambahan, pembaruan, atau penghapusan data.

## Service

<img width="416" height="82" alt="image" src="https://github.com/user-attachments/assets/9a3778ec-d459-4137-90fe-5434dd12a28b" />

Package service berisi class ParkingService yang menjadi pusat pengolahan data parkir. Class ini menerima perintah dari Main lalu menjalankan proses seperti menambah data kendaraan, menampilkan daftar parkir, memperbarui informasi (misalnya mengisi jam keluar dan menghitung biaya), mencari data berdasarkan ID, plat, atau jenis kendaraan, serta menghapus data yang sudah tidak diperlukan. Semua aturan dan perhitungan disimpan di class ini sehingga logika program terpisah dari tampilan.

## Main

<img width="407" height="82" alt="image" src="https://github.com/user-attachments/assets/44153772-7265-4d80-9577-963a7205cb62" />

Package main berisi class Main yang menjadi titik awal (entry point) jalannya program. Class ini menampilkan menu utama ke pengguna, menerima input pilihan menu melalui Scanner, lalu meneruskan perintah tersebut ke ParkingService untuk diproses.

# Penjelasan Alur Program

## Menu Program

<img width="671" height="492" alt="image" src="https://github.com/user-attachments/assets/ce1b2893-1344-4553-b31b-7fe112c27b59" />

Di dalamnya terdapat enam pilihan utama yang masing-masing menghubungkan pengguna dengan fungsi CRUD yang disediakan oleh ParkingService:
1. Tambah Data Parkir: Menjalankan method tambahData() untuk menambahkan data kendaraan baru lengkap dengan plat, jenis, blok, dan jam masuk.
3. Tampilkan Data Parkir: Menjalankan method tampilkanData() untuk menampilkan seluruh data parkir yang tersimpan dalam format tabel.
4. Perbarui Data Parkir: Menjalankan method perbaruiData() agar pengguna bisa mengubah informasi tertentu, misalnya plat, jenis, blok, atau menambahkan jam keluar sekaligus menghitung biaya.
5. Hapus Data Parkir: Menjalankan method hapusData() untuk menghapus data berdasarkan ID tiket atau plat nomor kendaraan.
6. Cari Data Parkir: Menjalankan method cariData() yang memungkinkan pencarian data melalui ID tiket, plat nomor, atau jenis kendaraan.
7. Keluar: Mengakhiri program dengan menutup loop utama.

Setelah menu tampil, program menunggu input angka [1–6] dari pengguna.

<img width="898" height="1007" alt="image" src="https://github.com/user-attachments/assets/c111e9e3-b2ed-4491-a049-31578d0a32bd" />

Saat pengguna memasukkan input menu yang tidak sesuai, yaitu angka 9, sementara pilihan menu yang tersedia hanya dari 1 sampai 6. Program kemudian menampilkan pesan "Pilihan tidak valid. Masukkan pilihan angka [1-6]." untuk memberi tahu pengguna bahwa input salah. Setelah itu, program otomatis kembali menampilkan menu utama agar pengguna bisa mencoba memasukkan pilihan yang benar.

<img width="696" height="1031" alt="image" src="https://github.com/user-attachments/assets/23d07762-704a-41c4-aa5d-61c834a19774" />

Saat pengguna mencoba memasukkan input menu dengan teks "pbo" padahal program hanya menerima angka 1 sampai 6 sebagai pilihan menu. Lalu program menampilkan pesan kesalahan "Input menu harus angka 1-6.". Setelah itu, program tidak berhenti, melainkan kembali menampilkan menu utama sehingga pengguna bisa mencoba lagi dengan input yang benar.

## 1. Tambah Data Parkir

<img width="1160" height="603" alt="image" src="https://github.com/user-attachments/assets/aa53d691-7f33-4d95-a139-ed3bc27ac12b" />

Menampilkan proses Tambah Data Parkir setelah pengguna memilih menu 1. Program meminta input plat nomor, jenis kendaraan, blok parkir, dan jam masuk dengan validasi otomatis (format plat, pilihan jenis, dan format jam). Setelah semua data valid, sistem membuat objek Parkir baru dengan ID tiket otomatis (0006) dan menyimpannya ke dalam daftar di ParkingService.

<img width="1381" height="606" alt="image" src="https://github.com/user-attachments/assets/a3a17682-290d-4b65-8422-0e6ce7ad2878" />

Daftar Parkir setelah berhasil menambahkan data parkir baru.

<img width="883" height="803" alt="image" src="https://github.com/user-attachments/assets/2f71c97c-67f8-4757-9833-b721d6b65be4" />

Pada saat pengguna memilih menu Tambah Data Parkir, program akan meminta input berupa plat nomor kendaraan. Jika pengguna tidak jadi untuk menambahkan data parkir, cukup tekan ENTER untuk membatalkannya, maka program secara otomatis membatalkan proses penambahan data dan mengembalikan pengguna ke menu utama untuk memilih opsi lain.

<img width="1692" height="249" alt="image" src="https://github.com/user-attachments/assets/f907a137-3e52-4417-9b8a-0dafb0aa16c2" />

Jika pengguna salah memasukkan plat kendaraan, misalnya mengetik "dr" daripada format plat 1-2 huruf awal, 1-4 angka, dan 1-3 huruf akhir, maka program akan menolak input tersebut dan mengulang kembali permintaan input hingga pengguna memberikan data yang valid atau memilih batal dengan menekan ENTER.

<img width="904" height="323" alt="image" src="https://github.com/user-attachments/assets/e3a0749d-2cc1-4892-8be5-eb59f75a6afb" />

Jika pengguna salah memasukkan jenis kendaraan, misalnya mengetik "kapal" daripada Mobil atau Motor, maka program akan menolak input tersebut dan mengulang kembali permintaan input hingga pengguna memberikan data yang valid atau memilih batal dengan menekan ENTER.

<img width="1132" height="398" alt="image" src="https://github.com/user-attachments/assets/06409a6e-e73a-4363-99fc-c7c5f2a43334" />

Jika pengguna salah memasukkan blok lokasi, misalnya mengetik "aaa234" daripada format blok 1 huruf dan 1 angka, maka program akan menolak input tersebut dan mengulang kembali permintaan input hingga pengguna memberikan data yang valid atau memilih batal dengan menekan ENTER.

<img width="940" height="482" alt="image" src="https://github.com/user-attachments/assets/06947527-36f9-4765-a1b4-8ea2b091fd97" />

Jika pengguna salah memasukkan jam masuk, misalnya mengetik angka atau huruf daripada format jam HH:mm, contoh 09:30, maka program akan menolak input tersebut dan mengulang kembali permintaan input hingga pengguna memberikan data yang valid atau memilih batal dengan menekan ENTER.

## 2. Tampilkan Data Parkir

<img width="1399" height="652" alt="image" src="https://github.com/user-attachments/assets/c0c7754d-341c-4c51-ae1d-3cb0412a508a" />

Ketika pengguna memilih menu 2 (Tampilkan Data Parkir), program akan menampilkan seluruh data kendaraan yang sudah tersimpan dalam bentuk tabel dengan kolom No, Plat, Jenis, Blok, Jam Masuk, Jam Keluar, Durasi, dan Biaya.

## 3. Perbarui Data Parkir

<img width="1371" height="798" alt="image" src="https://github.com/user-attachments/assets/205a4603-e78a-4fce-b3c5-ccd548161028" />

Saat pengguna memilih menu 3 (Perbarui Data Parkir) akan menampilkan daftar parkir yang tersimpan terlebih dahulu, lalu menampilkan pilihan sub-menu perbarui data jika plat yang ingin diperbarui ada di daftar parkir.

<img width="1051" height="297" alt="image" src="https://github.com/user-attachments/assets/657e023c-19da-4175-b0e0-9e097e4aec05" />

Ketika pengguna memasukkan id tiket yang tidak terdapat pada daftar parkir, seperti contoh "24", program tidak menemukan kecocokan. Program kemudian menampilkan pesan "ID tiket tidak ditemukan." dan meminta pengguna untuk memasukkan ulang id tiket atau menekan ENTER untuk membatalkan proses perbarui data.

<img width="1071" height="1209" alt="image" src="https://github.com/user-attachments/assets/c17c0f8b-643c-4bdd-a034-5bfa2cf0f00b" />

<img width="1378" height="515" alt="image" src="https://github.com/user-attachments/assets/7087a61e-cf09-4ee0-b800-5a3b6aa548e9" />

Pada saat pengguna memilih menu Perbarui Data Parkir dan memasukkan id tiket "6", program menampilkan data lama berupa plat, jenis kendaraan, blok lokasi, jam masuk, dan keluar. Selanjutnya, pengguna memilih opsi 1 (Plat Nomor) pada sub-menu perbarui data. Program kemudian meminta input plat baru, dan pengguna memasukkan "b242nl". Setelah diverifikasi bahwa plat baru valid dan tidak duplikat, program memperbarui data dari plat lama KT1234BCA menjadi B424NL serta formatnya huruf besar semua walaupun pengguna memasukkan huruf kecil.

<img width="1049" height="1122" alt="image" src="https://github.com/user-attachments/assets/98a34786-6272-46f1-be68-c23f35bf8f36" />

Ketika pengguna memilih opsi 1 (Plat Nomor) pada sub-menu perbarui data dan memasukkan plat baru "kt1234ab", program mendeteksi bahwa plat tersebut sudah digunakan oleh kendaraan lain (pada no 2). Akibatnya, program menolak perubahan dan menampilkan pesan “Plat baru sudah ada di data lain.”. Dengan demikian, pengguna diminta kembali untuk memasukkan plat baru yang valid atau membatalkan proses dengan menekan ENTER, sehingga program dapat menjaga agar tidak ada data ganda pada daftar parkir.

<img width="1087" height="1120" alt="image" src="https://github.com/user-attachments/assets/d3aaca99-a589-4753-9317-8fb0bcc1648a" />

Saat diminta memasukkan jenis baru, pengguna mengetikkan input tidak valid, yaitu “pesawat”. Karena program hanya menerima input “Mobil” atau “Motor”, program menolak perubahan dan menampilkan pesan “Jenis harus 'Mobil' atau 'Motor'! Coba lagi.”. Setelah itu, program kembali meminta pengguna untuk menginput ulang jenis kendaraan yang benar atau menekan ENTER untuk membatalkan proses pembaruan.

<img width="1044" height="1163" alt="image" src="https://github.com/user-attachments/assets/30334248-1419-4b71-9505-94e4630fe841" />

<img width="1373" height="289" alt="image" src="https://github.com/user-attachments/assets/603e4620-41ec-49d3-8fdf-c615fd2b0e62" />

Ketika pengguna memilih opsi 2 (Jenis Kendaraan), program meminta input jenis baru, dan pengguna memasukkan Mobil. Karena input tersebut valid sesuai dengan ketentuan, program memperbarui jenis kendaraan dari Motor menjadi Mobil dan menampilkan pesan konfirmasi “Jenis kendaraan berhasil diperbarui.” Data kendaraan berhasil diubah tanpa memengaruhi plat maupun blok lokasi.

<img width="1075" height="1053" alt="image" src="https://github.com/user-attachments/assets/5c7a793e-459c-4459-9f06-294fe35ba3cf" />

<img width="1389" height="232" alt="image" src="https://github.com/user-attachments/assets/2e0ac4f2-f600-4cf3-8530-dd6fd640f109" />

Ketika pengguna memilih opsi 3 (Blok Baru), program meminta input blok baru, dan pengguna memasukkan n2. Karena input tersebut valid sesuai dengan ketentuan, program memperbarui blok baru dari A1 menjadi N2 dan menampilkan pesan konfirmasi “Jenis kendaraan berhasil diperbarui.”.

<img width="1075" height="1005" alt="image" src="https://github.com/user-attachments/assets/7d98a7d6-83bf-40c9-8624-3b1dd5fe4cb7" />

Jika pengguna salah memasukkan blok lokasi, misalnya mengetik "abcd1234" daripada format blok 1 huruf dan 1 angka, maka program akan menolak input tersebut dan mengulang kembali permintaan input hingga pengguna memberikan data yang valid atau memilih batal dengan menekan ENTER.

<img width="1401" height="1613" alt="image" src="https://github.com/user-attachments/assets/742fa5cc-0be2-4e18-b2e7-f377a625fc2e" />

<img width="1388" height="513" alt="image" src="https://github.com/user-attachments/assets/4bac6d44-748e-4b97-bfa2-c6ecde067a6f" />

Ketika pengguna memilih opsi 4 (Jam Keluar) kendaraan, lalu memasukkan jam 16:40. Program menghitung selisih dari jam masuk 08:10 menjadi 510 menit dan otomatis membulatkan ke atas sesuai tarif mobil Rp5.000/jam, sehingga total biaya parkir Rp45.000.

<img width="1062" height="1115" alt="image" src="https://github.com/user-attachments/assets/7a4a788e-d779-4a67-8e71-b94227bfc98e" />

Jika pengguna salah memasukkan jam keluar, misalnya mengetik angka atau huruf daripada format jam HH:mm, contoh 09:30, maka program akan menolak input tersebut dan mengulang kembali permintaan input hingga pengguna memberikan data yang valid atau memilih batal dengan menekan ENTER.

<img width="1395" height="1526" alt="image" src="https://github.com/user-attachments/assets/f442175b-213b-48c4-aabe-9a46ac9e9ff9" />

Ketika data parkir dengan id tiket "0001" yang sudah memiliki jam keluar (16.40) kembali dipilih untuk Perbarui Data Parkir. Setelah itu pengguna memilih menu 4. Jam Keluar (hitung biaya), program menolak perubahan dan menampilkan pesan “Data ini sudah memiliki jam keluar.”. Hal ini untuk mencegah perhitungan ganda atau perubahan jam keluar.

<img width="1062" height="1478" alt="image" src="https://github.com/user-attachments/assets/25e7c3c9-8c39-488b-8acf-5ae46684b070" />

Jika pengguna memilih opsi 5 (Batal Perbarui). Karena pilihan ini berarti pengguna tidak ingin melakukan perubahan, program langsung menampilkan pesan “Batal perbarui data. Kembali ke menu utama.” dan keluar dari proses pembaruan tanpa mengubah data apapun.

## Hapus Data Parkir

<img width="1446" height="953" alt="image" src="https://github.com/user-attachments/assets/46026a53-3d5a-4244-bdcc-a30a87643108" />

Program menampilkan daftar data parkir yang tersedia, kemudian pengguna mengetikkan id tiket "7" untuk dihapus. Program mendeteksi id tiket tersebut ada dalam daftar, sehingga menampilkan konfirmasi: “Yakin ingin menghapus data dengan plat KT1424IO? (Y/T):”. Pengguna kemudian mengetik T, yang berarti Tidak, sehingga program tidak jadi menghapus data tersebut. Program langsung menampilkan pesan “Batal hapus data, kembali ke menu utama.” dan mengembalikan pengguna ke menu utama.

<img width="1432" height="854" alt="image" src="https://github.com/user-attachments/assets/b6cdd60a-4800-481b-a885-eb510c1ccb1c" />

<img width="1381" height="479" alt="image" src="https://github.com/user-attachments/assets/cb480db0-3c67-441f-bc10-bc864d414602" />

Pada saat pengguna memilih menu Hapus Data Parkir, program terlebih dahulu menampilkan seluruh daftar kendaraan yang sedang terdaftar di parkiran. Pengguna kemudian memasukkan plat nomor KT1424IO sebagai data yang ingin dihapus. Untuk memastikan, program meminta konfirmasi dengan pertanyaan “Yakin ingin menghapus data dengan plat KT1424IO? (Y/T)”. Setelah pengguna mengetikkan Y, program langsung menghapus data tersebut dari daftar parkir. Proses ini ditutup dengan pesan konfirmasi “Data dengan plat KT1424IO berhasil dihapus!”, yang menandakan bahwa data kendaraan tersebut sudah tidak ada lagi di daftar parkir.

<img width="1394" height="807" alt="image" src="https://github.com/user-attachments/assets/77a5ff4c-40ff-4040-a5b3-d8bb5eeab24c" />

Jika pengguna mengetikkan plat nomor "kt1424" untuk dihapus. Namun, program melakukan pencarian pada daftar yang ada dan tidak menemukan plat nomor tersebut. Karena tidak cocok dengan data yang tersedia, program menampilkan pesan “Plat nomor tidak ditemukan.”. Setelah itu, program langsung meminta kembali pengguna untuk memasukkan plat nomor yang ingin dihapus atau menekan ENTER jika ingin membatalkan.

<img width="1550" height="1410" alt="image" src="https://github.com/user-attachments/assets/ca1db3d1-f8ee-4e4f-a20c-a102fd65e6da" />

Ketika pengguna menghapus data dengan id tiket "6". Program mendeteksi id tiket tersebut ada dalam daftar dan menampilkan konfirmasi penghapusan. Namun, ketika pengguna salah mengetik input konfirmasi dengan memasukkan teks selain Y, T, atau menekan ENTER, program memberikan peringatan bahwa input tidak valid dan meminta konfirmasi ulang. Saat pengguna hanya menekan ENTER, program mengenali hal tersebut sebagai pembatalan penghapusan sehingga menampilkan pesan “Batal hapus data (ENTER ditekan), kembali ke menu utama”. Dengan demikian, data tidak jadi dihapus dan program kembali ke menu utama.

## 5. Cari Data Parkir

<img width="1308" height="410" alt="image" src="https://github.com/user-attachments/assets/14fd1c24-f3dd-4012-b839-7321f9bc62df" />

Ketika pengguna memasukkan ID tiket 2, program menampilkan detail kendaraan dengan plat KT1234AB, jenis Motor, blok B2, jam masuk 08:30, jam keluar 12:20, durasi parkir 230 menit, dan biaya Rp12.000.

<img width="1274" height="500" alt="image" src="https://github.com/user-attachments/assets/a76a783c-38fb-4e9c-ab99-6341d8450bf4" />

Ketika pengguna hanya mengetik kata kunci “bil”, bukan kata lengkap mobil. Program tetap menampilkan semua data kendaraan Mobil (ID 0001, 0003, dan 0005), program akan mencocokkan input dengan sebagian teks pada kolom plat maupun jenis kendaraan, sehingga meskipun hanya sebagian kata yang dimasukkan, data yang mengandung kata itu akan tetap ditemukan dan ditampilkan.

<img width="1158" height="758" alt="image" src="https://github.com/user-attachments/assets/0b2227ef-1b90-4013-8ef2-275b9605a4c1" />

Ketika pengguna memasukkan ID tiket 58, plat kt123, dan kata kapal, namun seluruhnya tidak cocok dengan data yang tersimpan, maka program akan menolak input tersebut dan mengulang kembali permintaan input hingga pengguna memberikan data yang valid atau memilih batal dengan menekan ENTER.

<img width="1129" height="709" alt="image" src="https://github.com/user-attachments/assets/876e3b90-1f2d-4e7e-87b7-bad4b9aaad89" />

Ketika pengguna tidak jadi melakukan pencarian data, maka cukup tekan enter untuk membatalkannya, dan akan kembali ke menu utama.

## 6. Keluar Program

<img width="1164" height="577" alt="image" src="https://github.com/user-attachments/assets/5f59ea7e-af9e-402e-b770-a3d8f06f0f67" />

Saat pengguna memilih menu nomor 6 (Keluar) pada program Sistem Parkir Mall. Setelah input angka 6, program langsung menampilkan pesan "Terima kasih. Program Selesai." serta indikator BUILD SUCCESS menandakan program berhenti normal tanpa error, menutup seluruh proses sesuai logika di kelas Main.
