package view;

import model.Parkir;
import java.util.List;

public class ParkingView {

    public void menuUtama() {
        System.out.println("\n====================================");
        System.out.println("|     MENU SISTEM PARKIR MALL      |");
        System.out.println("====================================");
        System.out.println("| 1. Tambah Data Parkir            |");
        System.out.println("| 2. Tampilkan Data Parkir         |");
        System.out.println("| 3. Perbarui Data Parkir          |");
        System.out.println("| 4. Hapus Data Parkir             |");
        System.out.println("| 5. Cari Data Parkir              |");
        System.out.println("| 6. Keluar                        |");
        System.out.println("====================================");
        System.out.println("Masukkan pilihan menu [1-6]: ");
    }

    public void headerData() {
        System.out.println("\n===============================================================================");
        System.out.println("                           Data Parkir Kendaraan di Mall                       ");
        System.out.println("===============================================================================");
        System.out.printf("%-3s %-6s %-10s %-10s %-6s %-8s %-8s %-8s %-8s%n",
                "No", "ID", "PLAT", "JENIS", "BLOK", "MASUK", "KELUAR", "DURASI", "BIAYA");
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void headerCari() {
        System.out.println("\n=============== Fitur Cari Data ===============");
    }

    public void headerHasilCari() {
        System.out.println("\n===============================================================================");
        System.out.println("                             Hasil Pencarian Data                              ");
        System.out.println("===============================================================================");
        System.out.printf("%-3s %-6s %-10s %-10s %-6s %-8s %-8s %-8s %-8s%n",
                "No", "ID", "PLAT", "JENIS", "BLOK", "MASUK", "KELUAR", "DURASI", "BIAYA");
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void headerTambah() {
        System.out.println("\n=============== Tambah Data Parkir ===============");
    }

    public void headerPerbarui() {
        System.out.println("\n========== Perbarui Data Parkir ===========");
    }

    public void headerHapus() {
        System.out.println("\n============ Hapus Data Parkir ============");
    }

    public void printBaris(List<Parkir> data) {
        int no = 1;
        for (Parkir parkir : data) {
            String durasiStr = (parkir.getDurasiMenit() <= 0) ? "-" : (parkir.getDurasiMenit() + " mnt");
            String biayaStr  = (parkir.getBiaya() <= 0) ? "-" : ("Rp" + parkir.getBiaya());
            System.out.printf("%-3d %04d %-10s %-10s %-6s %-8s %-8s %-8s %-8s%n",
                    no++,
                    parkir.getIdTiket(),
                    parkir.getPlat(),
                    parkir.getJenis(),
                    parkir.getBlok(),
                    parkir.getJamMasuk(),
                    parkir.getJamKeluar(),
                    durasiStr,
                    biayaStr);
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    public void BelumAdaData() {
        System.out.println("Belum ada data parkir kendaraan di mall.");
    }

    public void BelumAdaUntukDicari() {
        System.out.println("\nBelum ada data untuk dicari.");
    }

    public void BatalCari() {
        System.out.println("Batal mencari data, kembali ke menu utama.");
    }

    public void DataTidakDitemukan() {
        System.out.println("Data tidak ditemukan.");
    }

    public void infoTambahBerhasil(int idTiket, String plat) {
        System.out.println("\nBerhasil menambahkan data parkir dengan ID " +
                String.format("%04d", idTiket) + " dan plat " + plat + ".");
        System.out.println("--------------------------------------------------");
    }

    public void infoBatalPerbarui() {
        System.out.println("Batal perbarui data. Kembali ke menu utama.");
    }

    public void batalMenambahData() {
        System.out.println("Batal menambah data, kembali ke menu utama.");
    }

    public void infoFormatPlat() {
        System.out.println("Format plat harus 1-2 huruf awal, 1-4 angka, dan 1-3 huruf akhir. Contoh: B1AA, B123AB, KT1234ABC.");
    }

    public void infoPlatDuplikat() {
        System.out.println("Plat sudah ada, data tidak bisa ditambahkan.");
    }

    public void infoPilihanTidakValid() {
        System.out.println("Pilihan tidak valid. Kembali ke menu utama.");
    }

    public void infoJenisHarusMobilMotor() {
        System.out.println("Jenis harus 'Mobil' atau 'Motor'! Coba lagi.");
    }

    public void infoFormatBlok() {
        System.out.println("Format blok harus 1 huruf dan 1 angka, contoh: A1, B2. Coba lagi.");
    }

    public void infoFormatJam() {
        System.out.println("Format jam harus HH:mm, contoh 09:30");
    }

    public void infoIdHarusAngka() {
        System.out.println("ID tiket harus angka! Coba lagi.");
    }

    public void infoIdTidakDitemukan() {
        System.out.println("\nID tiket tidak ditemukan.");
    }

    public void tampilkanDataSaatIni(Parkir parkir) {
        System.out.println("\nData saat ini");
        System.out.println("ID    : " + parkir.getIdTiket());
        System.out.println("Plat  : " + parkir.getPlat());
        System.out.println("Jenis : " + parkir.getJenis());
        System.out.println("Blok  : " + parkir.getBlok());
        System.out.println("Masuk : " + parkir.getJamMasuk());
        System.out.println("Keluar: " + parkir.getJamKeluar());
    }

    public void submenuPerbarui() {
        System.out.println("\n==================================");
        System.out.println("|     Pilihan Perbarui Data      |");
        System.out.println("==================================");
        System.out.println("| 1. Plat Nomor                  |");
        System.out.println("| 2. Jenis Kendaraan             |");
        System.out.println("| 3. Blok Lokasi                 |");
        System.out.println("| 4. Jam Keluar (hitung biaya)   |");
        System.out.println("| 5. Batal Perbarui              |");
        System.out.println("==================================");
    }

    public void infoMenuHarusAngka() {
        System.out.println("Input menu harus angka 1-5.");
    }

    public void infoBatalUbahPlat() {
        System.out.println("Batal ubah plat.");
    }

    public void infoPlatSama() {
        System.out.println("Plat sama seperti sebelumnya.");
    }

    public void infoPlatBaruSudahAda() {
        System.out.println("Plat baru sudah ada di data lain.");
    }

    public void infoPlatBerhasilDiperbarui(String posisiGetPlatSetelahUpdate, String platBaruArg) {
        System.out.println("Plat " + posisiGetPlatSetelahUpdate + " berhasil diperbarui menjadi " + platBaruArg);
    }

    public void infoBatalUbahJenis() {
        System.out.println("Batal ubah jenis.");
    }

    public void infoJenisBerhasil() {
        System.out.println("Jenis kendaraan berhasil diperbarui.");
    }

    public void infoBlokBerhasilDiubah(String lama, String baruBlok) {
        System.out.println("Blok " + lama + " berhasil diperbarui menjadi " + baruBlok);
    }

    public void infoSudahAdaJamKeluar() {
        System.out.println("Data ini sudah memiliki jam keluar.");
    }

    public void batalInputJamKeluar() {
        System.out.println("Batal input jam keluar.");
    }

    public void infoJamKeluarLebihAwal() {
        System.out.println("Jam keluar tidak boleh lebih awal dari jam masuk.");
    }

    public void infoJamKeluarTersimpan(String plat, int biaya) {
        System.out.println("Jam keluar dan biaya parkir " + plat + " berhasil tersimpan.");
    }

    public void infoBatalHapus() {
        System.out.println("Batal hapus data, kembali ke menu utama.");
    }

    public void infoDataTidakDitemukanCobaLagi() {
        System.out.println("Data tidak ditemukan, coba lagi.");
    }

    public void konfirmasiHapus(String plat, int id) {
        System.out.println("Yakin ingin menghapus data dengan plat " + plat +
                " (ID: " + id + ")? (Y/T, ENTER untuk batal): ");
    }

    public void infoHapusBerhasil(String plat) {
        System.out.println("Data dengan plat " + plat + " berhasil dihapus!");
        System.out.println("------------------------------------------------");
    }

    public void infoBatalHapusEnter() {
        System.out.println("Batal hapus data (ENTER ditekan), kembali ke menu utama.");
    }

    public void infoInputKonfirmasiTidakValid() {
        System.out.println("Input tidak valid! Harap masukkan Y untuk ya, T untuk tidak, atau tekan ENTER untuk batal.");
    }
    
    public void infoKeluar() {
        System.out.println("Terima kasih. Program Selesai.");
    }
}
