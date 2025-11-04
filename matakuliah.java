class matakuliah {
    private String kode_matkul;
    private String namaMk;
    private int sks;

    public String getKode_matkul(){
        return kode_matkul;
    }
    public String getNamaMk(){
        return namaMk;
    }
    public int getSks(){
        return sks;
    }
    
    public void setKode_matkul(String kode_matkul){
        if(kode_matkul == null ||kode_matkul.trim().isEmpty()){
            System.out.println("Tidak boleh kosong");
        }
        this.kode_matkul = kode_matkul;
    }
    public void setNamaMk(String namaMk){
        this.namaMk = namaMk;
    }
    public void setSks(int sks){
        if(sks < 1 || sks > 6){
            System.out.println("Sks Harus sesuai");
        }
        this.sks = sks;
    }

    public String infoMk(){
        return kode_matkul + " - " + namaMk + " (" + sks + " SKS)";
    }
}