import java.util.ArrayList;
import java.util.List;

public class mahasiswa {
    private String nama;
    private int umur;
    private String npm;
    private String prodi;
    private float ipk;
    private dosen dsn1;
    private List<matakuliah> krs;
    private int jumlahKrs;

    public mahasiswa(){
        this.krs = new ArrayList<>();
        this.jumlahKrs = 0;
    }

    public mahasiswa(String nama, int umur, String npm, String prodi, float ipk){
        this.nama = nama;
        this.umur = umur;
        this.npm = npm;
        this.prodi = prodi;
        this.ipk = ipk;
    }
    public List<matakuliah> getKrs(){
        return new ArrayList<>(krs);
    }
    public void setDosenWali(String namadosen){
        this.dsn1 = new dosen(namadosen);
    }

    public void tambahMataKuliah(matakuliah mk){
        if (mk == null) {
            System.out.println("Mata kuliah tidak boleh null");
        }
        for (matakuliah matkul : krs) {
            if (matkul.getKode_matkul().equals(mk.getKode_matkul())) {
                System.out.println("Mata kuliah dengan kode " + mk.getKode_matkul() + " sudah ada di KRS");
            }
        }
        int totalSks = getTotalSks();
        if (totalSks + mk.getSks() > 24) {
            System.out.println("Total SKS melebihi batas maksimal 24. Total SKS saat ini: " + totalSks);
        }
        krs.add(mk);
        jumlahKrs = krs.size();
    }
    public void hapusMataKuliah(String kode){
        if (kode == null || kode.trim().isEmpty()) {
            System.out.println("Kode mata kuliah tidak boleh kosong");
        }
        boolean ditemukan = false;
        for (int i = 0; i < krs.size(); i++) {
            if (krs.get(i).getKode_matkul().equals(kode)) {
                krs.remove(i);
                jumlahKrs = krs.size();
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Mata kuliah dengan kode " + kode + " tidak ditemukan di KRS");
        }
    }
    public void tampilKrs(){
        System.out.println("KRS Mahasiswa");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + npm);
        System.out.println("Mata Kuliah yang Diambil: " + jumlahKrs);
        System.out.println("-----------------------------------");
        if (krs.isEmpty()) {
            System.out.println("KRS kosong");
        } else {
            for (int i = 0; i < krs.size(); i++) {
                matakuliah mk = krs.get(i);
                System.out.println((i + 1) + ". " + mk.infoMk());
            }
        }
        System.out.println("Total SKS: " + getTotalSks());
        System.out.println("-----------------------------------\n");
    }

    void tampilData(){
        System.out.println("Nama: " + nama);
        System.out.println("NPM: " + npm);
        System.out.println("Jurusan: " + prodi);
        System.out.println("IPK: " + ipk);
        System.out.println("Wali Dosen: " + dsn1.getNama());
        System.out.println("NIDN: " + dsn1.getnidn());
        System.out.println("Status: " + dsn1.statusDosen(dsn1.getStatus()));
    }

    String predikatIpk(float ipk){
        if (ipk >= 3.50){
            return "CUMLAUDE";
        } else if (ipk >= 3.00){
            return "Baik";
        } else {
            return "cukup";
        }
    }
    void infoSingkat(dosen dosenWali){
        System.out.println("Nama : "+ nama);
        System.out.println("Dosen Wali : "+ dosenWali.getNama());
    }
    void infoSingkat(){
        System.out.println("Nama : "+nama);
        System.out.println("Prodi : "+prodi);
    }
    void tampilPredikatIpk(){
        System.out.println("Predikatnya: " + predikatIpk(ipk));
    }


    private int getTotalSks() {
        int total = 0;
        for (matakuliah mk : krs) {
            total += mk.getSks();
        }
        return total;
    }
    public String getNama(){
        return nama;
    }
    public int getUmur(){
        return umur;
    }
    public String getNpm(){
        return npm;
    }
    public String getProdi(){
        return prodi;
    }
    public float getIpk(){
        return ipk;
    }
    public dosen getDsn1(){
        return dsn1;
    }

    public void setNama(String nama){
        this.nama = nama;
    }
    public void setUmur(int umur){
        if(umur < 17){
            System.out.println("Umur tidak mencukupi");
        }
        this.umur = umur;
    }
    public void setNpm(String npm){
        this.npm = npm;
    }
    public void setProdi(String prodi){
        this.prodi = prodi;
    }
    public void setIpk(Float ipk){
        this.ipk = ipk;
    }
    public void setDsn1(dosen dsn1){
        this.dsn1 = dsn1;
    }
    
}
