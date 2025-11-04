import java.util.Scanner;

public class main {

    Scanner scan = new Scanner(System.in);
    static mahasiswa[] mhs = new mahasiswa[5];
    static int jumlahMahasiswa = 0;

    public static void main(String[] args) {
        mahasiswa m1 = new mahasiswa();
        m1.setNama("Mahesa");
        m1.setUmur(20);
        m1.setNpm("24552011382");
        m1.setProdi("TIF");
        m1.setIpk(3.50f);
        m1.setDosenWali("Pak Sabar");
        mhs[jumlahMahasiswa++] = m1;

        main app = new main();
        app.menuUtama();
    }

    void menuUtama() {
        boolean running = true;
        while (running) {
            System.out.println("SISTEM INFORMASI MAHASISWA");
            System.out.println("1. Daftar mahasiswa");
            System.out.println("2. Cari data pakai NIM");
            System.out.println("3. Hitung rata-rata IPK");
            System.out.println("4. Ganti dosen wali");
            System.out.println("5. Tambah mahasiswa");
            System.err.println("6. Kelola KRS");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            int pilihan = scan.nextInt();
            scan.nextLine();
            switch (pilihan) {
                case 1:
                    daftarMahasiswa();
                    break;
                case 2:
                    cariMahasiswaByNIM();
                    break;
                case 3:
                    ratarataIPK();
                    break;
                case 4:
                    gantiDosenWali();
                    break;
                case 5:
                    tambahMahasiswa();
                    break;
                case 6:
                    menuKrs();
                    break;
                case 0:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 0-5.");
            }

            if (running && pilihan != 0) {
                System.out.println("\nTekan Enter untuk kembali ke menu utama...");
                scan.nextLine();
            }
        }
    }

    void menuKrs(){
        if (jumlahMahasiswa == 0) {
            System.out.println("[INFO] Belum ada data mahasiswa. Silakan tambah mahasiswa terlebih dahulu.");
            return;
        }
        int pilihan;
        do {
            System.out.println("KELOLA KRS MAHASISWA");
            System.out.println("1. Tambah Mata Kuliah ke KRS");
            System.out.println("2. Hapus Mata Kuliah dari KRS");
            System.out.println("3. Lihat KRS Mahasiswa");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilihan: ");
            pilihan = scan.nextInt();
            scan.nextLine();
            switch (pilihan) {
                case 1:
                    tambahMataKuliah();
                    break;
                case 2:
                    hapusMataKuliahDariKRS();
                    break;
                case 3:
                    lihatKRSMahasiswa();
                    break;
                case 0:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 0-3.");
            }
            if (pilihan != 0) {
                System.out.println("\nTekan Enter untuk melanjutkan...");
                scan.nextLine();
            }
        } while (pilihan != 0);
    }

    void tambahMataKuliah(){
        System.out.println("TAMBAH MATA KULIAH KE KRS");

        mahasiswa mhs = pilihMahasiswa();
        if (mhs == null) return;

        System.out.println("\nMasukkan data mata kuliah:");

        String kode = validasiKodeMataKuliah(mhs);

        System.out.print("Masukkan Nama Mata Kuliah: ");
        String nama = scan.nextLine();

        int sks = validasiSKS();

        try {
            matakuliah mk = new matakuliah();
            mk.setKode_matkul(kode);
            mk.setNamaMk(nama);
            mk.setSks(sks);
            mhs.tambahMataKuliah(mk);
            System.out.println("\n[SUKSES] Mata kuliah berhasil ditambahkan ke KRS!");

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
    void lihatKRSMahasiswa() {
        System.out.println("LIHAT KRS MAHASISWA");

        mahasiswa mhs = pilihMahasiswa();
        if (mhs == null) return;

        mhs.tampilKrs();
    }
    mahasiswa pilihMahasiswa() {
        System.out.println("\nDaftar Mahasiswa:");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println((i + 1) + ". " + mhs[i].getNpm() + " - " + mhs[i].getNama());
        }

        System.out.print("Pilih nomor mahasiswa (1-" + jumlahMahasiswa + "): ");
        if (!scan.hasNextInt()) {
            System.out.println("[ERROR] Input harus berupa angka!");
            scan.next();
            return null;
        }

        int pilihan = scan.nextInt();
        scan.nextLine();

        if (pilihan < 1 || pilihan > jumlahMahasiswa) {
            System.out.println("[ERROR] Pilihan tidak valid!");
            return null;
        }

        return mhs[pilihan - 1];
    }
    String validasiKodeMataKuliah(mahasiswa mhs) {
        String kode;
        boolean kodeValid = false;
        do {
            System.out.print("Masukkan Kode Mata Kuliah: ");
            kode = scan.nextLine().trim();
            if (kode.isEmpty()) {
                System.out.println("[ERROR] Kode mata kuliah tidak boleh kosong!");
                continue;
            }
            boolean duplikat = false;
            for (matakuliah mk : mhs.getKrs()) {
                if (mk.getKode_matkul().equalsIgnoreCase(kode)) {
                    System.out.println("[ERROR] Kode mata kuliah '" + kode + "' sudah ada di KRS mahasiswa ini!");
                    duplikat = true;
                    break;
                }
            }
            if (!duplikat) {
                kodeValid = true;
            }

        } while (!kodeValid);
        return kode;
    }
    int validasiSKS() {
        int sks = -1;
        while (sks < 1 || sks > 6) {
            System.out.print("Masukkan SKS (1-6): ");
            if (!scan.hasNextInt()) {
                System.out.println("[ERROR] SKS harus berupa angka antara 1-6!");
                scan.next();
                continue;
            }
            sks = scan.nextInt();
            scan.nextLine();
            if (sks < 1 || sks > 6) {
                System.out.println("[ERROR] SKS harus berada dalam rentang 1-6!");
            }
        }
        return sks;
    }
    void hapusMataKuliahDariKRS() {
        System.out.println("HAPUS MATA KULIAH DARI KRS");
        mahasiswa mhs = pilihMahasiswa();
        if (mhs == null) return;

        if (mhs.getKrs().isEmpty()) {
            System.out.println("[INFO] KRS mahasiswa " + mhs.getNama() + " kosong.");
            return;
        }

        System.out.println("\nKRS Mahasiswa " + mhs.getNama() + ":");
        mhs.tampilKrs();

        System.out.print("Masukkan Kode Mata Kuliah yang akan dihapus: ");
        String kodeHapus = scan.nextLine();

        try {
            mhs.hapusMataKuliah(kodeHapus);
            System.out.println("[SUKSES] Mata kuliah berhasil dihapus dari KRS!");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
    
    static void daftarMahasiswa() {
        System.out.println("DAFTAR MAHASISWA:");

        if (jumlahMahasiswa == 0) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        for (int i = 0; i < jumlahMahasiswa; i++) {
            mahasiswa m = mhs[i];
            System.out.println("No. " + (i + 1));
            if (m.getDsn1() != null) {
                m.infoSingkat(m.getDsn1());
            } else {
                m.infoSingkat();
            }
        }
        System.out.println("Total: " + jumlahMahasiswa + " mahasiswa");
    }

    String validasiNIM() {
        String nim;
        boolean nimValid = false;
        do {
            System.out.print("Masukkan NIM: ");
            nim = scan.nextLine().trim();
            if (nim.isEmpty()) {
                System.out.println("[ERROR] NIM tidak boleh kosong!");
                continue;
            }
            if (isNimExist(nim)) {
                System.out.println("[ERROR] NIM '" + nim + "' sudah terdaftar! Silakan gunakan NIM yang berbeda.");
            } else {
                nimValid = true;
            }
        } while (!nimValid);
        return nim;
    }

    boolean isNimExist(String npm) {
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (mhs[i].getNpm().equalsIgnoreCase(npm)) {
                return true;
            }
        }
        return false;
    }

    float validasiIPK() {
        float ipk = -1.0f;
        while (ipk < 0.0f || ipk > 4.0f) {
            System.out.print("Masukkan IPK (0.00 - 4.00, gunakan titik sebagai desimal): ");
            if (scan.hasNextFloat()) {
                ipk = scan.nextFloat();
                if (ipk >= 0.0f && ipk <= 4.0f) {
                    break;
                } else {
                    System.out.println("[ERROR] IPK harus berada dalam rentang 0.00 hingga 4.00. Silakan coba lagi.");
                }
            } else {
                System.out.println("[ERROR] Input tidak valid. Pastikan Anda memasukkan angka desimal (float) dan menggunakan titik (.). Silakan coba lagi.");
                scan.next();
            }
        }
        return ipk;
    }

    void cariMahasiswaByNIM() {
        System.out.println("CARI DATA MAHASISWA BERDASARKAN NIM");

        if (mhs.length == 0) {
            System.out.println("[INFO] Daftar mahasiswa kosong. Tidak ada yang bisa dicari.");
            return;
        }

        System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
        String nimCari = scan.nextLine();

        mahasiswa foundMhs = null;
        for (int i = 0; i < mhs.length; i++) {
            if (mhs[i].getNpm().equalsIgnoreCase(nimCari)) {
                foundMhs = mhs[i];
                break;
            }
        }

        if (foundMhs != null) {
            System.out.println("[SUKSES] Mahasiswa dengan NIM " + nimCari + " ditemukan!");
            foundMhs.infoSingkat();
            if (foundMhs.getDsn1() != null) {
                System.out.println("Dosen Wali : " + foundMhs.getDsn1().getNama());
            } else {
                System.out.println("Dosen Wali : Belum Ditetapkan");
            }
        } else {
            System.out.println("[INFO] Maaf, Mahasiswa dengan NIM " + nimCari + " TIDAK DITEMUKAN.");
        }
    }

    void tambahMahasiswa() {
        System.out.println("TAMBAH MAHASISWA BARU");

        if (jumlahMahasiswa >= mhs.length) {
            System.out.println("[ERROR] Kapasitas mahasiswa penuh! Tidak bisa menambah data baru.");
            return;
        }

        System.out.print("Berapa mahasiswa yang mau ditambah? (1-" + (mhs.length - jumlahMahasiswa) + ") : ");

        if (!scan.hasNextInt()) {
            System.out.println("[ERROR] Input harus berupa angka!");
            scan.next();
            scan.nextLine();
            return;
        }

        int jumlahTambahMahasiswa = scan.nextInt();
        scan.nextLine();

        if (jumlahTambahMahasiswa <= 0) {
            System.out.println("[ERROR] Jumlah mahasiswa harus lebih dari 0.");
            return;
        }

        if (jumlahTambahMahasiswa > (mhs.length - jumlahMahasiswa)) {
            System.out.println("[ERROR] Kapasitas tidak mencukupi! Hanya bisa menambah " + (mhs.length - jumlahMahasiswa) + " mahasiswa.");
            return;
        }

        for (int i = 0; i < jumlahTambahMahasiswa; i++) {
            System.out.println("\n--- Data Mahasiswa ke-" + (jumlahMahasiswa + 1) + " ---");

            System.out.print("Masukkan Nama: ");
            String nama = scan.nextLine();

            System.out.print("Masukkan Umur: ");
            int umur = scan.nextInt();
            
            String nim = validasiNIM();

            System.out.print("Masukkan Prodi: ");
            String prodi = scan.nextLine();

            float ipk = validasiIPK();
            scan.nextLine();

            System.out.print("Masukkan Nama Dosen Wali Awal: ");
            String namaDosenWali = scan.nextLine();

            mahasiswa mahasiswaBaru = new mahasiswa(nama, umur, nim, prodi, ipk);
            mahasiswaBaru.setDosenWali(namaDosenWali);
            mhs[jumlahMahasiswa++] = mahasiswaBaru;

            System.out.println("[SUKSES] Mahasiswa '" + nama + "' berhasil ditambahkan.");
        }

        System.out.println("\n[SUKSES] Total " + jumlahTambahMahasiswa + " mahasiswa berhasil ditambahkan.");
        System.out.println("Total mahasiswa saat ini: " + jumlahMahasiswa);
    }

    void gantiDosenWali() {
        System.out.println("GANTI DOSEN WALI MAHASISWA");

        if (jumlahMahasiswa == 0) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        System.out.println("DAFTAR MAHASISWA & DOSEN WALINYA");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("No. " + i);
            System.out.println("Nama : " + mhs[i].getNama());
            if (mhs[i].getDsn1() != null) {
                System.out.println("Dosen Wali: " + mhs[i].getDsn1().getNama());
            } else {
                System.out.println("Dosen Wali: Belum ada");
            }
        }

        System.out.print("Pilih nomor mahasiswa yang mau diubah (0 s/d " + (jumlahMahasiswa - 1) + ") : ");
        int pilihan = scan.nextInt();
        scan.nextLine();

        if (pilihan >= 0 && pilihan < jumlahMahasiswa) {
            System.out.println("\nKamu memilih : " + mhs[pilihan].getNama());
            System.out.print("Masukkan nama dosen wali yang baru : ");
            String namaDosenWaliBaru = scan.nextLine();
            mhs[pilihan].setDosenWali(namaDosenWaliBaru);
            System.out.println("\n[SUKSES] Dosen wali untuk " + mhs[pilihan].getNama() + " berhasil diubah!");
            System.out.println("Dosen Wali Baru: " + mhs[pilihan].getDsn1().getNama());
        } else {
            System.out.println("[ERROR] Pilihan tidak valid.");
        }
    }
    static void ratarataIPK(){
        System.out.println("RATA-RATA IPK MAHASISWA");

        if(jumlahMahasiswa == 0){
            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        float jumlah = 0;
        for (int i = 0; i < jumlahMahasiswa; i++){
            jumlah += mhs[i].getIpk();
        }
        float ratarata = jumlah / jumlahMahasiswa;
        System.out.printf("Rata-rata IPK dari %d mahasiswa adalah: %.2f\n", jumlahMahasiswa, ratarata);
    }
}