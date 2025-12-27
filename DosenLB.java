public class DosenLB extends dosen {

    public DosenLB(String nama, int nidn, String prodi, boolean status) {
        super(nama, nidn, prodi, status);
    }

    @Override
    void absen() {
        System.out.println(getNama() + " sudah tanda tangan");
    }
}
