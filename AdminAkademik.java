public class AdminAkademik extends User {
    
    void tambahData(){
        System.out.println("Data akademik berhasil ditambahkan");
    }

    void ubahData(){
        System.out.println("Data akademik berhasil diubah");
    }

    @Override
    void tampilMenu() {
        System.out.println("Menu Admin Akademik");
    }
}
