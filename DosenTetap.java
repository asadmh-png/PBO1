public class DosenTetap extends dosen {

    private String nip;

    public DosenTetap(String nama, int nidn, String prodi, boolean status) {
        super(nama, nidn, prodi, status);
        this.nip = nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNip() {
        return nip;
    }

    @Override
    void absen() {
        System.out.println(getNama() + " sudah absen digital");
    }
}
