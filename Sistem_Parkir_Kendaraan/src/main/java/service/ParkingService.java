package service;

import model.Parkir;
import model.ParkirMobil;
import model.ParkirMotor;
import view.ParkingView;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ParkingService {

    private ArrayList<Parkir> dataParkir = new ArrayList<>();
    private int id = 1; // penomoran ID tiket parkir

    private DateTimeFormatter FMT = DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault());
    private ParkingView view;

    // Data Awal
    public ParkingService(ParkingView view) {
        this.view = view;
        tambahDataAwal("KT4959IO", "Mobil", "A1", "08:10");
        tambahDataAwal("KT1234AB", "Motor", "B2", "08:30");
        tambahDataAwal("KT5678CD", "Mobil", "C1", "09:05");
        tambahDataAwal("KT8765XYZ","Motor", "D3", "09:20");
        tambahDataAwal("KT4321EFG","Mobil", "E1", "09:45");
    }

    private Parkir objekParkir(int idTiket, String plat, String jenis, String blok, String jamMasuk) {
        if ("Mobil".equalsIgnoreCase(jenis)) {
            return new ParkirMobil(idTiket, plat, blok, jamMasuk);
        } else if ("Motor".equalsIgnoreCase(jenis)) {
            return new ParkirMotor(idTiket, plat, blok, jamMasuk);
        }
        return new ParkirMotor(idTiket, plat, blok, jamMasuk);
    }
    
    private void tambahDataAwal(String plat, String jenis, String blok, String jamMasuk) {
        dataParkir.add(objekParkir(id++, plat, jenis, blok, jamMasuk));
    }

    // Tambah Data Parkir
    public void tambahData(Scanner sc) {
        view.headerTambah();
        // Tambah plat
        String plat;
        while (true) {
            System.out.println("Masukkan plat nomor kendaraan (ENTER untuk batal): ");
            plat = sc.nextLine().toUpperCase();
            if (plat.equals("")) {
                view.batalMenambahData();
                return;
            }
            // validasi format plat
            if (!plat.matches("^[A-Z]{1,2}\\d{1,4}[A-Z]{1,3}$")) {
                view.infoFormatPlat();
                continue;
            }
            // cek duplikat plat
            boolean duplikat = false;
            for (Parkir parkir : dataParkir) {
                if (parkir.getPlat().equalsIgnoreCase(plat)) {
                    duplikat = true;
                    break;
                }
            }
            if (duplikat) {
                view.infoPlatDuplikat();
                continue;
            }
            break;
        }

        // Tambah jenis kendaraan
        String jenis;
        while (true) {
            System.out.println("Jenis kendaraan (mobil/motor) (ENTER untuk batal): ");
            String inputJenis = sc.nextLine();
            if (inputJenis.equals("")) {
                view.batalMenambahData();
                return;
            }
            if (inputJenis.equalsIgnoreCase("Mobil") || inputJenis.equalsIgnoreCase("Motor")) {
                jenis = Character.toUpperCase(inputJenis.toLowerCase().charAt(0))
                        + inputJenis.toLowerCase().substring(1);
                break;
            } else {
                view.infoJenisHarusMobilMotor();
            }
        }

        // Tambah blok lokasi
        String blok;
        while (true) {
            System.out.println("Masukkan blok lokasi parkir (ENTER untuk batal): ");
            blok = sc.nextLine().toUpperCase();
            if (blok.equals("")) {
                view.batalMenambahData();
                return;
            }
            if (blok.matches("^[A-Z][0-9]$")) {
                break;
            } else {
                view.infoFormatBlok();
            }
        }

        // Jam Masuk
        String jamMasuk;
        while (true) {
            System.out.println("Masukkan jam masuk (format HH:mm, ENTER untuk batal): ");
            String jam = sc.nextLine();
            if (jam.equals("")) {
                view.batalMenambahData();
                return;
            }
            try {
                LocalTime.parse(jam, FMT);
                jamMasuk = jam;
                break;
            } catch (Exception e) {
                view.infoFormatJam();
            }
        }
        int idTiket = id++;
        dataParkir.add(objekParkir(idTiket, plat, jenis, blok, jamMasuk));
        view.infoTambahBerhasil(idTiket, plat);
    }

    // Tampilkan Data
    public void tampilkanData() {
        view.headerData();
        if (dataParkir.isEmpty()) {
            view.BelumAdaData();
            return;
        }
        view.printBaris(dataParkir);
    }

    // Perbarui Data Parkir
    public void perbaruiData(Scanner sc) {
        tampilkanData();
        if (dataParkir.isEmpty())
            return;

        view.headerPerbarui();

        // Cari berdasarkan Id Tiket
        Parkir posisi = null;
        while (true) {
            System.out.println("Masukkan ID Tiket yang ingin diperbarui (ENTER untuk batal): ");
            String idTiket = sc.nextLine();
            if (idTiket.equals("")) {
                view.infoBatalPerbarui();
                return;
            }
            int idInput;
            try {
                idInput = Integer.parseInt(idTiket);
            } catch (NumberFormatException e) {
                view.infoIdHarusAngka();
                continue;
            }
            for (Parkir parkir : dataParkir) {
                if (parkir.getIdTiket() == idInput) {
                    posisi = parkir;
                    break;
                }
            }
            if (posisi != null) 
                break;
            view.infoIdTidakDitemukan();
        }

        view.tampilkanDataSaatIni(posisi);
        view.submenuPerbarui();
        System.out.println("Masukkan menu pilihan data yang ingin diperbarui [1-5]: ");

        int pilihan;
        try {
            pilihan = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            view.infoMenuHarusAngka();
            return;
        }

        switch (pilihan) {
            case 1 -> { // Perbarui Plat
                while (true) {
                    System.out.println("Masukkan plat baru (ENTER untuk batal): ");
                    String platBaru = sc.nextLine().toUpperCase();
                    if (platBaru.equals("")) {
                        view.infoBatalUbahPlat();
                        return;
                    }
                    // validasi format plat
                    if (!platBaru.matches("^[A-Z]{1,2}\\d{1,4}[A-Z]{1,3}$")) {
                        view.infoFormatPlat();
                        continue;
                    }
                    if (platBaru.equalsIgnoreCase(posisi.getPlat())) {
                        view.infoPlatSama();
                        return;
                    }
                    boolean duplikat = false;
                    for (Parkir parkir : dataParkir) {
                        if (parkir.getIdTiket() != posisi.getIdTiket() &&
                                parkir.getPlat().equalsIgnoreCase(platBaru)) {
                            duplikat = true;
                            break;
                        }
                    }
                    if (duplikat) {
                        view.infoPlatBaruSudahAda();
                        continue;
                    }
                    posisi.setPlat(platBaru);
                    view.infoPlatBerhasilDiperbarui(posisi.getPlat(), platBaru);
                    return;
                }
            }

            case 2 -> { // Perbarui Jenis Kendaraan
                while (true) {
                    System.out.println("Masukkan jenis baru (Mobil/Motor) (ENTER untuk batal): ");
                    String jenisBaru = sc.nextLine();
                    if (jenisBaru.equals("")) {
                        view.infoBatalUbahJenis();
                        return;
                    }
                    if (jenisBaru.equalsIgnoreCase("Mobil") || jenisBaru.equalsIgnoreCase("Motor")) {
                        String fix = Character.toUpperCase(jenisBaru.toLowerCase().charAt(0))
                                + jenisBaru.toLowerCase().substring(1);
                        posisi.setJenis(fix);
                        view.infoJenisBerhasil();
                        return;
                    }
                    view.infoJenisHarusMobilMotor();
                }
            }

            case 3 -> { // Perbarui Blok Lokasi
                String blokBaru;
                while (true) {
                    System.out.println("Masukkan blok lokasi parkir (ENTER untuk batal): ");
                    blokBaru = sc.nextLine().toUpperCase();
                    if (blokBaru.equals("")) {
                        view.batalMenambahData();
                        return;
                    }
                    if (blokBaru.matches("^[A-Z][0-9]$")) {
                        break;
                    } else {
                        view.infoFormatBlok();
                    }
                }
                String lama = posisi.getBlok();
                posisi.setBlok(blokBaru);
                view.infoBlokBerhasilDiubah(lama, blokBaru);
            }

            case 4 -> { // Jam Keluar + Hitung Biaya
                if (!"-".equals(posisi.getJamKeluar())) {
                    view.infoSudahAdaJamKeluar();
                    return;
                }

                String jamKeluar;
                while (true) {
                    System.out.println("Masukkan jam keluar (format HH:mm, ENTER untuk batal): ");
                    String jam = sc.nextLine();
                    if (jam.equals("")) {
                        view.batalInputJamKeluar();
                        return;
                    }
                    try {
                        LocalTime.parse(jam, FMT);
                        jamKeluar = jam;
                        break;
                    } catch (Exception e) {
                        view.infoFormatJam();
                    }
                }

                LocalTime masuk = LocalTime.parse(posisi.getJamMasuk(), FMT);
                LocalTime keluar = LocalTime.parse(jamKeluar, FMT);
                if (keluar.isBefore(masuk)) {
                    view.infoJamKeluarLebihAwal();
                    return;
                }

                long menit = Duration.between(masuk, keluar).toMinutes();
                if (menit <= 0) menit = 1;

                long jamBulatKeAtas = Math.max(1, (menit + 59) / 60);
                // Menggunakan overriding
                int biaya = posisi.hitungBiaya(jamBulatKeAtas);

                posisi.setKeluarHitung(jamKeluar, menit, biaya);
                view.infoJamKeluarTersimpan(posisi.getPlat(), biaya);
            }
            case 5 -> { // Batal Perbarui Data
                view.infoBatalPerbarui();
            }
            default -> {
                view.infoPilihanTidakValid();
            }
        }
    }

    // Hapus Data Parkir
    public void hapusData(Scanner sc) {
        tampilkanData();
        if (dataParkir.isEmpty())
            return;

        view.headerHapus();
        while (true) {
            System.out.println("Masukkan ID tiket atau Plat nomor yang ingin dihapus (ENTER untuk batal): ");
            String input = sc.nextLine();

            if (input.equals("")) {
                view.infoBatalHapus();
                return;
            }
            Parkir posisi = null;
            boolean angka = input.matches("\\d+");
            if (angka) {
                int idInput = Integer.parseInt(input);
                for (Parkir parkir : dataParkir) {
                    if (parkir.getIdTiket() == idInput) {
                        posisi = parkir;
                        break;
                    }
                }
            } else {
                for (Parkir parkir : dataParkir) {
                    if (parkir.getPlat().equalsIgnoreCase(input)) {
                        posisi = parkir;
                        break;
                    }
                }
            }
            if (posisi == null) {
                view.infoDataTidakDitemukanCobaLagi();
                continue;
            }

            while (true) {
                view.konfirmasiHapus(posisi.getPlat(), posisi.getIdTiket());
                String konfirmasi = sc.nextLine();
                if (konfirmasi.equalsIgnoreCase("Y")) {
                    String platHapus = posisi.getPlat();
                    dataParkir.remove(posisi);
                    view.infoHapusBerhasil(platHapus);
                    return;
                } else if (konfirmasi.equalsIgnoreCase("T")) {
                    view.infoBatalHapus();
                    return;
                } else if (konfirmasi.equals("")) {
                    view.infoBatalHapusEnter();
                    return;
                } else {
                    view.infoInputKonfirmasiTidakValid();
                }
            }
        }
    }
    // Cari Data
    public void cariData(Scanner sc) {
        if (dataParkir.isEmpty()) {
            view.BelumAdaUntukDicari();
            return;
        }
        view.headerCari();
        while (true) {
            System.out.println("\nMasukkan ID tiket / Plat / Jenis (Mobil/Motor). (ENTER untuk batal): ");
            String cari = sc.nextLine().trim();
            if (cari.equals("")) {
                view.BatalCari();
                break;
            }

            ArrayList<Parkir> hasil = new ArrayList<>();

            if (cari.matches("\\d+")) {
                int idAngka;
                try {
                    idAngka = Integer.parseInt(cari);
                } catch (NumberFormatException e) {
                    view.infoIdHarusAngka();
                    continue;
                }
                Parkir parkir = cariData(idAngka);
                if (parkir != null) {
                    hasil.add(parkir);
                }
            }
            else {
                hasil = cariData(cari);
            }
            if (hasil.isEmpty()) {
                view.DataTidakDitemukan();
                continue;
            }
            
            view.headerHasilCari();
            view.printBaris(hasil);
            
            // kombinasi abstract + interface
            System.out.println("\nRingkasan detail setiap hasil: \n");
            for (Parkir parkir : hasil) {
                parkir.cetakInfo();
                parkir.cetakRingkas();
            }
        }
    }
    // Overloading 1 untuk cari data berdasarkan ID tiket
    public Parkir cariData(int idTiket) {
        for (Parkir parkir : dataParkir) {
            if (parkir.getIdTiket() == idTiket) {
                return parkir;
            }
        }
        return null;
    }
    // Overloading 2 untuk cari data berdasarkan plat
    public ArrayList<Parkir> cariData(String kata) {
        ArrayList<Parkir> hasil = new ArrayList<>();
        String lower = kata.toLowerCase();

        for (Parkir parkir : dataParkir) {
            if (parkir.getPlat().equalsIgnoreCase(kata) ||
                parkir.getPlat().toLowerCase().contains(lower.toLowerCase())) {
                hasil.add(parkir);
            }
            else if (parkir.getJenis().toLowerCase().contains(lower)) {
                hasil.add(parkir);
            }
        }
        return hasil;
    }
}