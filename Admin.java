public class Admin extends User {
    
    void tambahData(){
        System.out.println("Data berhasil ditambahkan");
    }

    void ubahData(){
        System.out.println("Data berhasil diubah");
    }

    void tambahUser(){
        System.out.println("User berhasil ditambahkan");
    }

    void hapusUser(){
        System.out.println("User berhasil dihapus");
    }
    
    @Override
    void tampilMenu() {
        System.out.println("Menu Admin");
    }
    
}
