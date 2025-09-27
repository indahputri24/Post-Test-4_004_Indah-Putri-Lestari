package model;

public class ParkirMobil extends Parkir {
    public ParkirMobil(int idTiket, String plat, String blok, String jamMasuk) {
        super(idTiket, plat, "Mobil", blok, jamMasuk);
    }
    
    @Override
    public int hitungBiaya(long jamBulatKeAtas) {
        System.out.println(">> Menghitung biaya untuk kendaraan Mobil " + getPlat() + " . . .");
        System.out.println(">> Durasi Parkir: " + jamBulatKeAtas + " Jam.");
        int biaya = (int) (jamBulatKeAtas * 5000);
        System.out.println(">> Biaya Parkir: Rp" + biaya);
        return biaya;
    }
}
