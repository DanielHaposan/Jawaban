package GUI;

public class User {

    
    private String Kode, Nama, Harga,Stok;

    
    public User(String Kode, String Nama, String Harga, String Stok) {
        this.Kode = Kode;
        this.Nama = Nama;
        this.Harga = Harga;
        this.Stok = Stok;
    }
    
    public String getKode() {
        return Kode;
    }
    public void setKode(String Kode) {
        this.Kode = Kode;
    }
    public String getNama() {
        return Nama;
    }
    public void setNama(String Nama) {
        this.Nama = Nama;
    }
    public String getHarga() {
        return Harga;
    }
    public void setHarga(String Harga) {
        this.Harga = Harga;
    }
  
    public String getStok() {
        return Stok;
    }
    public void setStok(String Stok) {
        this.Stok = Stok;
    }

    
    
}
