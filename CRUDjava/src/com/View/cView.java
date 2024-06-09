package com.View;

import java.util.Scanner;

import com.Config.cConfig;

public class cView {
    public static Scanner input = new Scanner(System.in);

    public static void index()
    {
        
        while(true){
        System.out.println("====================");
        System.out.println("  TimeGrafy Camera  ");
        System.out.println("====================");
        System.out.print("\n======= MENU =======\n"
        + "1. Lihat Semua Data Camera\n"
        + "2. Detail Data Camera\n"
        + "3. Cari Data Camera\n"
        + "4. Tambah Data Camera\n"
        + "5. Update Data Camera\n"
        + "6. Delete Data Camera\n"
        + "0. Exit\n"
        + "Pilih[1/2/3/4/5/0] : ");
        
        String pilihan = input.next();
        
        if( pilihan.equalsIgnoreCase("0") ){
            System.out.println("Terimakasih!!");
            break;
        }
        
        switch (pilihan) {
            case "1" :
                getAllData();
                break;
            case "2" :
                detailData();
                break;
            case "3" :
                cariData();
                break;
            case "4" :
                tambahData();
                break;
            case "5" :
                updateData();
                break;
            case "6" :
                deleteData();
                break;
            default:
                System.out.println("Pilihan salah!!");
                break;
            }
        }
        
    }
    
    public static void getAllData()
    {
      //  pesan header
        System.out.println("\n=== DATA CAMERA ===\n");
      // data semua barangnya
        System.out.println(cConfig.getAllData()); 

    }
    
    public static void detailData()
    {
        System.out.println("\n=== DETAIL DATA CAMERA ===");
        
        System.out.print("Masukkan ID Camera: ");
        int id = input.nextInt();
        
        System.out.println("Hasil Data");
        System.out.println(cConfig.detailData(id));
    }
    
    public static void cariData()
    {
        System.out.println("\n=== CARI DATA ===");
        System.out.print("Masukkan Keyword : ");
        String keyword = input.nextLine();
        keyword = input.nextLine();
        
        System.out.println("\nHasil Data");
        System.out.println(cConfig.cariData(keyword));
    }
    
    public static void tambahData()
    {
        
        System.out.println("\n=== TAMBAH DATA CAMERA ===");
        System.out.print("Masukkan Nama Camera : ");
        String namaCamera = input.nextLine();
        namaCamera = input.nextLine();
        System.out.print("Masukkan Type Camera : ");
        String typeCamera = input.nextLine();
        System.out.print("Masukkan Stok Camera : ");
        int stokCamera = input.nextInt();
        System.out.print("Masukkan Harga Camera : ");
        int hargaCamera = input.nextInt();
    
        if ( cConfig.tambahData(namaCamera, typeCamera, stokCamera, hargaCamera) ){
        System.out.println("Data Barang berhasil ditambahkan!!");
        getAllData();
            }else{
        System.out.println("Data Barang gagal ditambahkan!!");
        }
        
    }
    
    public static void updateData() {
        System.out.println("\n:=== UPDATE DATA CAMERA ===");
        System.out.print("Masukkan ID Camera : ");
        int idCamera = input.nextInt();
        input.nextLine(); // Membersihkan karakter newline dari input stream
    
        System.out.println("\nGanti Data Barang\n");
        System.out.print("Nama Camera (Kosongkan jika tidak ingin mengganti datanya) : ");
        String namaCamera = input.nextLine();
    
        System.out.print("Type Camera (Kosongkan jika tidak ingin mengganti datanya) : ");
        String typeCamera = input.nextLine();
    
        System.out.print("Stok Camera (isi 0 jika tidak ingin merubah data) : ");
        int stokCamera = input.nextInt();
        
        System.out.print("Harga Camera (isi 0 jika tidak ingin merubah data) : ");
        int hargaCamera = input.nextInt();
        
        if (cConfig.updateData(idCamera, namaCamera, typeCamera, stokCamera, hargaCamera)) {
            System.out.println("Data barang berhasil dirubah!!");
            getAllData();
        } else {
            System.out.println("Data barang gagal dirubah!!");
        }
    }
    
    public static void deleteData()
    {
        System.out.println("\n=== DELETE DATA CAMERA ===");
        System.out.print("Masukkan ID Camera : ");
        int idCamera = input.nextInt();
        
            if( cConfig.deleteData(idCamera) ){
            System.out.println("Data Barang Berhasil Dihapus!!");
            getAllData();
        }else{
            System.out.println("Data Barang Gagal Dihapus!!");
        }
        
    }
    
}
