import java.util.List;

class MahasiswaReguler extends  mahasiswa{
    public MahasiswaReguler(){
        super();
    }

    public MahasiswaReguler(String nama, String npm, String prodi, float ipk, int umur){
        super(nama, umur, npm, prodi, ipk);
    }

    public String getStatusMahasiswa(){
        return "reguler";
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
    }

    @Override
    public void tampilKrs(){
        System.out.println("KRS Mahasiswa");
        System.out.println("Nama : " + getNama());
        System.out.println("NPM : " + getNpm());
        System.out.println("Status : " + getStatusMahasiswa());
        System.out.println("Mata Kuliah yang Diambil : " + getKrs());
        if (getKrs().isEmpty()){
            System.out.println("KRS kosong");
        } else{
            List<matakuliah> krsList = getKrs();
            for (int i = 0; 1 < krsList.size(); i++) {
                matakuliah mk = krsList.get(i);
                System.out.println((i + 1) + ". " + mk.infoMk());
            }
        }
        System.out.println("Total SKS : " + getTotalSksDisplay());
    }

    @Override
    void TampilData(){
        System.out.println("Nama : " + getNama());
        System.out.println("NPM : " + getNpm());
        System.out.println("Mahasiswa Reguler");
    }
}
