package model;

public class Parkir extends CetakLaporan implements InfoKendaraan {
    private int idTiket;
    private String plat;
    private String jenis;
    private String blok;
    private String jamMasuk;
    private String jamKeluar;
    private long durasiMenit;
    private int biaya;

    public Parkir(int idTiket, String plat, String jenis, String blok, String jamMasuk) {
        this.idTiket = idTiket;
        this.plat = plat;
        this.jenis = jenis;
        this.blok = blok;
        this.jamMasuk = jamMasuk;
        this.jamKeluar = "-";
        this.durasiMenit = 0;
        this.biaya = 0;
    }
    
    // Getter
    public int getIdTiket() {
        return idTiket;
    } 
    public String getPlat() {
        return plat;
    }
    public String getJenis() {
        return jenis;
    }
    public String getBlok() {
        return blok; 
    }
    public String getJamMasuk() {
        return jamMasuk; 
    }
    public String getJamKeluar() {
        return jamKeluar; 
    }
    public long getDurasiMenit() {
        return durasiMenit;
    }
    public int getBiaya() {
        return biaya; 
    }
    
    //Setter
    public void setPlat(String plat) {
        this.plat = plat; 
    }
    public void setJenis(String jenis) {
        this.jenis = jenis; 
    }
    public void setBlok(String blok) { 
        this.blok = blok; 
    }
    public void setJamMasuk(String jamMasuk) {
        this.jamMasuk = jamMasuk; 
    }
    public void setKeluarHitung(String jamKeluar, long durasiMenit, int biaya) {
        this.jamKeluar = jamKeluar;
        this.durasiMenit = durasiMenit;
        this.biaya = biaya;
    }
    
    // Override cetakRingkas dari abstract class CetakLaporan
    @Override
    public void cetakRingkas() {
        System.out.println("ID    : " + getIdTiket());
        System.out.println("Plat  : " + getPlat());
        System.out.println("Biaya : Rp" + getBiaya());
        System.out.println("---------------------------------------------------");
    }
    
    // Override cetakInfo dari interface InfoKendaraan
    @Override
    public void cetakInfo() {
        System.out.println("Kendaraan dengan plat " + getPlat() + " berada di blok " + getBlok());
    }
    
    // Biaya
    public int hitungBiaya(long jamBulatKeAtas) {
        return (int) (jamBulatKeAtas * 4000);
    }
}
