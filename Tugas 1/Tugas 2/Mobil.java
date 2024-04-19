public class Mobil {
    private String noPlat; 
    private String warna; 
    private String manufaktur; 
    private double kecepatan; 
    private double waktu;

    public void setNoPlat(String s){ 
        noPlat = s; 
    } 

    public void setWarna(String s){ 
        warna = s; 
    } 

    public void setManufaktur(String s){ 
        manufaktur = s; 
    } 

    public void setKecepatan(double i){ 
	    kecepatan = i; 	 
        RubahKecepatan();	 	 
	}

    public void RubahKecepatan(){
        kecepatan = kecepatan/3.6;
    }

    public void setWaktu(double w){
        waktu = w;
        RubahDetik();
    }

    public void RubahDetik(){
        waktu = waktu * 3600;
    }

    public double HitungJarak(){
        return kecepatan * waktu;
    }
    
	
    public void displayMessage(){  	 	 
        double Hitungjarak = HitungJarak() / 1000;
        System.out.println("Mobil anda adalah bermerek "+manufaktur);    
        System.out.println("mempunyai nomor plat "+noPlat); 
        System.out.println("serta memililki warna "+warna); 
	    System.out.println("dan mampu menempuh kecepatan "+ kecepatan +" m/s"); 
        System.out.println("Jarak yang dapat di tempuh adalah " + Hitungjarak + " km" );	 	 	 
	} 	 	 	 
} 	 
