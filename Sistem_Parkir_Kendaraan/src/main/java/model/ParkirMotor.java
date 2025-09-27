package model;

public class ParkirMotor extends Parkir {
    public ParkirMotor(int idTiket, String plat, String blok, String jamMasuk) {
        super(idTiket, plat, "Motor", blok, jamMasuk);
    }
    
    @Override
    public int hitungBiaya(long jamBulatKeAtas) {
        System.out.println(">> Menghitung biaya untuk kendaraan Motor " + getPlat() + " . . .");
        System.out.println(">> Durasi Parkir: " + jamBulatKeAtas + " Jam.");
        int biaya = (int) (jamBulatKeAtas * 3000);
        System.out.println(">> Biaya Parkir: Rp" + biaya);
        return biaya;
    }
}
