import java.util.Scanner;

public class Buku {
    private int JumlahLembar;
    private int KataPerHari;

    public Buku(int jumlahLembar, int kataPerHari) {
        this.JumlahLembar = jumlahLembar;
        this.KataPerHari = kataPerHari;
    }

    public int hitungHariMenghabiskan() {
        int totalKata = JumlahLembar * 100 * 2; 
        int hari = totalKata / KataPerHari; 
        return hari;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Jumlah Lembar : ");
        int JumlahLembar = input.nextInt();
        System.out.println("Kata Per Hari : ");
        int KataPerHari = input.nextInt();
        
        int HasilKataPerHari = KataPerHari / 2; 
        
        Buku buku = new Buku(JumlahLembar, HasilKataPerHari);
        int hariMenghabiskan = buku.hitungHariMenghabiskan();
        
        System.out.println("Mahasiswa A akan menghabiskan buku tulis dalam " + hariMenghabiskan + " hari.");
    }
}
