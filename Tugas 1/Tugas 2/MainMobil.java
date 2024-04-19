import java.util.Scanner;

public class MainMobil {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        Mobil m1 = new Mobil();

        System.out.print("Masukkan kecepatan mobil 1: ");
        System.out.println("Ex 50");
        int kecepatan1 = Input.nextInt();
        m1.setKecepatan(kecepatan1);

        System.out.print("Masukkan manufaktur mobil 1: ");
        System.out.println("Toyota");
        String manufaktur1 = Input.next();
        m1.setManufaktur(manufaktur1);

        System.out.print("Masukkan nomor plat mobil 1: ");
        System.out.println("AB 1231 UA");
        String noPlat1 = Input.next();
        m1.setNoPlat(noPlat1);

        System.out.print("Masukkan warna mobil 1: ");
        System.out.println("Merah");
        String warna1 = Input.next();
        m1.setWarna(warna1);

        System.out.println("================");

        Mobil m2 = new Mobil();
        System.out.print("Masukkan kecepatan mobil 2: ");
        System.out.println("Ex 100");
        int kecepatan2 = Input.nextInt();
        m2.setKecepatan(kecepatan2);

        System.out.print("Masukkan manufaktur mobil 2: ");
        System.out.println("Ex Mitsubishi");
        String manufaktur2 = Input.next();
        m2.setManufaktur(manufaktur2);

        System.out.print("Masukkan nomor plat mobil 2: ");
        System.out.println("Ex N 1134 AG");
        String noPlat2 = Input.next();
        m2.setNoPlat(noPlat2);

        System.out.print("Masukkan warna mobil 2: ");
        System.out.println(" Ex Pink");
        String warna2 = Input.next();
        m2.setWarna(warna2);

        System.out.println("================");

        System.out.println("Mobil pada objek m1 dirubah menjadi warna hijau");
        m1.setWarna("Hijau");

        m1.displayMessage();
    }
}
