// Kelas Akun untuk menyimpan informasi akun pelanggan
public class Akun {
    private String nomorPelanggan;
    private String namaPelanggan;
    private double saldo;
    private int jenisRekening;

    // Constructor
    public Akun(String nomorPelanggan, String namaPelanggan, double saldo, int jenisRekening) {
        this.nomorPelanggan = nomorPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.saldo = saldo;
        this.jenisRekening = jenisRekening;
    }

    // Getter dan setter untuk semua atribut
    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getJenisRekening() {
        return jenisRekening;
    }

    // Metode untuk cek saldo
    public void cekSaldo() {
        System.out.println("Saldo Anda saat ini adalah: Rp" + saldo);
    }
}

// Kelas Transaksi untuk melakukan transaksi pembelian atau top up
