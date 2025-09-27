package main;

import service.ParkingService;
import view.ParkingView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingView view = new ParkingView();
        ParkingService service = new ParkingService(view);

        boolean jalan = true;
        while (jalan) {
            view.menuUtama();

            String in = sc.nextLine();
            int pilih;
            try {
                pilih = Integer.parseInt(in.trim());
            } catch (NumberFormatException e) {
                view.infoPilihanTidakValid();
                continue;
            }

            switch (pilih) {
                case 1 -> service.tambahData(sc);
                case 2 -> service.tampilkanData();
                case 3 -> service.perbaruiData(sc);
                case 4 -> service.hapusData(sc);
                case 5 -> service.cariData(sc);
                case 6 -> {
                    jalan = false;
                    view.infoKeluar();
                }
                default -> view.infoPilihanTidakValid();
            }
        }
        sc.close();
    }
}
