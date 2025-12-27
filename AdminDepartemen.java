public class AdminDepartemen extends User {
    
    void tambahData(){
        System.out.println("Data departemen berhasil ditambahkan");
    }

    void ubahData(){
        System.out.println("Data departemen berhasil diubah");
    }

    @Override
    void tampilMenu() {
        System.out.println("Menu Admin Departemen");
    }
}
