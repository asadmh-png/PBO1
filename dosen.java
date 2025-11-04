public class dosen {
    private String nama;
    private String nidn;
    private Boolean status;

    public dosen(){
    }

    public dosen(String nama, String nidn, Boolean status){
        this.nama = nama;
        this.nidn = nidn;
        this.status = status;
    }

    public dosen (String nama){
        this.nama = nama;
    }

    void tampilStatus(){
        System.out.println(statusDosen(this.status));
    }
    
    String statusDosen (Boolean status){
        return status == true ? "Tetap" :"Tidak tetap";
    }

    void info(){
        System.out.println("Nama : " + nama);
        System.out.println("NIDN : " + nidn);
        System.out.println("Status : " + status);
    }

    public String getNama(){
        return nama;
    }
    public String getnidn(){
        return nidn;
    }
    public Boolean getStatus(){
        return status;
    }

    public void setNama(String nama){
        this.nama = nama;
    }
    public void setNidn(String nidn){
        this.nidn = nidn;
    }
    public void setStatus(Boolean status){
        this.status = status;
    }
}
