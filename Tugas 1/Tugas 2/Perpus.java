import java.io.*;
import java.util.*;

class Pembukuan {
    private String judul;
    private List<String> penulis;

    public Pembukuan(String judul, List<String> penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    public String Judul() {
        return judul;
    }

    public List<String> Penulis() {
        return penulis;
    }
}

class KategoriBuku {
    private String namaKategori;
    private List<Pembukuan> daftarBuku;

    public KategoriBuku(String namaKategori) {
        this.namaKategori = namaKategori;
        this.daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(Pembukuan buku) {
        daftarBuku.add(buku);
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public List<Pembukuan> getDaftarBuku() {
        return daftarBuku;
    }
}
public class Perpus {
    private Map<String, KategoriBuku> kategoriBukuMap;

    public Perpus() {
        this.kategoriBukuMap = new HashMap<>();
    }

    public void tambahKategoriBuku(String namaKategori) {
        kategoriBukuMap.put(namaKategori, new KategoriBuku(namaKategori));
    }

    public void tambahBukuKeKategori(String namaKategori, Pembukuan buku) {
        KategoriBuku kategoriBuku = kategoriBukuMap.get(namaKategori);
        if (kategoriBuku != null) {
            kategoriBuku.tambahBuku(buku);
            System.out.println("Buku berhasil ditambahkan ke kategori " + namaKategori);
        } else {
            System.out.println("Kategori '" + namaKategori + "' tidak ditemukan. kategori baru...");
            tambahKategoriBuku(namaKategori);
            tambahBukuKeKategori(namaKategori, buku);
        }
    }

    public void tampilkanBukuDalamKategori(String namaKategori) {
        KategoriBuku kategoriBuku = kategoriBukuMap.get(namaKategori);
        if (kategoriBuku != null) {
            System.out.println("Buku dalam kategori " + namaKategori + ":");
            List<Pembukuan> daftarBuku = kategoriBuku.getDaftarBuku();
            if (!daftarBuku.isEmpty()) {
                for (Pembukuan buku : daftarBuku) {
                    System.out.println("Judul: " + buku.Judul());
                    System.out.println("Penulis: " + String.join(", ", buku.Penulis()));
                    System.out.println();
                }
            } else {
                System.out.println("Tidak ada buku dalam kategori ini.");
            }
        } else {
            System.out.println("Kategori '" + namaKategori + "' tidak ditemukan.");
        }
    }

    public void tulisDataKeFile(String namaFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(namaFile))) {
            for (KategoriBuku kategoriBuku : kategoriBukuMap.values()) {
                writer.println("Kategori: " + kategoriBuku.getNamaKategori());
                for (Pembukuan buku : kategoriBuku.getDaftarBuku()) {
                    writer.println("Judul: " + buku.Judul());
                    writer.println("Penulis: " + String.join(", ", buku.Penulis()));
                    writer.println();
                }
            }
            System.out.println("Data telah ditulis ke " + namaFile);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis ke file: " + e.getMessage());
        }
    }

    public void bacaDataDariFile(String namaFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Kategori: ")) {
                    String namaKategori = line.substring("Kategori: ".length());
                    tambahKategoriBuku(namaKategori);
                } else if (line.startsWith("Judul: ")) {
                    String judul = line.substring("Judul: ".length());
                    String penulisLine = reader.readLine();
                    String[] penulis = penulisLine.substring("Penulis: ".length()).split(", ");
                    tambahBukuKeKategori(kategoriBukuMap.keySet().iterator().next(),
                            new Pembukuan(judul, Arrays.asList(penulis)));
                }
            }
            System.out.println("Data telah dibaca dari " + namaFile);
        } catch (IOException e) {
            System.out.println("Kesalahan membaca dari file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Perpus perpustakaan = new Perpus();
        perpustakaan.bacaDataDariFile("library_data.txt");

        Scanner input = new Scanner(System.in);

        System.out.println("Selamat datang di Perpustakaan Universitas Konoha");
        
        while (true) {
            System.out.println("==========================");
            System.out.println("MENU :");
            System.out.println("1. Tulis Sebuah Buku");
            System.out.println("2. Pencarian Kategori Buku?");
            System.out.println("3. Tulis Buku ke File");
            System.out.println("4. Baca Buku");
            System.out.println("5. Keluar");
            System.out.println("===========================");
            System.out.print("Masukkan nomer yang ingin anda lakukan : ");
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul buku:");
                    String judul = input.nextLine();

                    System.out.print("Masukkan penulis :");
                    String[] penulis = input.nextLine().split(", ");
                    System.out.print("Masukkan kategori:");
                    String namaKategori = input.nextLine();
                    perpustakaan.tambahBukuKeKategori(namaKategori, new Pembukuan(judul, Arrays.asList(penulis)));
                    break;
                case 2:
                    System.out.print("Masukkan kategori:");
                    namaKategori = input.nextLine();
                    perpustakaan.tampilkanBukuDalamKategori(namaKategori);
                    break;
                case 3:
                    System.out.print("Masukkan nama file untuk disimpan:");
                    String namaFileSimpan = input.nextLine();
                    perpustakaan.tulisDataKeFile(namaFileSimpan);
                    break;
                case 4:
                    System.out.print("Masukkan nama file yang akan tampilkan:");
                    String namaFileMuat = input.nextLine();
                    perpustakaan.bacaDataDariFile(namaFileMuat);
                    break;
                case 5:
                    System.out.print("Keluar dari program...");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    System.out.println("Masukkan dengan benar!!! :");
            }
        }
    }
}
