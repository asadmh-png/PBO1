import java.util.List;

class MahasiswaKonversi extends mahasiswa{
    public MahasiswaKonversi(){
        super();
    }

    public MahasiswaKonversi(String nama, String npm, String prodi, float ipk, int umur){
        super(nama, umur, npm, prodi, ipk);
    }

    public String getStatusMahasiswa(){
        return "Konversi";
    }

    private int getTotalSksDisplay(){
        int total = 0;
        for (matakuliah mk : getKrs()){
           total += mk.getSks(); 
        }
        return total;
    }

    @Override
    void infoSingkat(){
        System.out.println("Nama : " + getNama());
        System.out.println("NPM : " + getNpm());
        System.out.println("Prodi : " + getProdi());
        System.out.println("Status : " + getStatusMahasiswa());
        tampilPredikatIpk();
    }

    @Override
    void infoSingkat(dosen dsn1){
        System.out.println("Nama : " + getNama());
        System.out.println("NPM : " + getNpm());
        System.out.println("Prodi : " + getProdi());
        System.out.println("Status : " + getStatusMahasiswa());
        tampilPredikatIpk();
        System.out.println("Dosen Wali : " + dsn1.getNama());
    }

    @Override
    public void tampilKrs(){
        System.out.println("KRS Mahasiswa");
        System.out.println("Nama : " + getNama());
        System.out.println("NPM : " + getNpm());
        System.out.println("Prodi : " + getProdi());
        System.out.println("Status : " + getStatusMahasiswa());
        System.out.println("Mata Kuliah yang diambil : " + getKrs());
        if (getKrs().isEmpty()){
            System.out.println("KRS kosong");
        } else{
            List<matakuliah> krsList = getKrs();
            for (int i = 0; i < krsList.size(); i++){
                matakuliah mk = krsList.get(i);
                System.out.println((i + 1) + ". " + mk.infoMk());
            }
        }
        System.out.println("Total SKS : " + getTotalSksDisplay());
    }
}