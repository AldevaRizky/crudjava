package com.Config;
import java.sql.*;


public class cConfig {

    //koneksi ke database
    // private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/crudjava";
    private static final String USER = "root";
    private static final String PASS = "";

   // ini untuk instansiasi object dari class yang sudah diimport
    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultData;

    // ini adalah method static connection
    private static void connection()
    {
    // method untuk melakukan koneksi ke database
    try {
      // registrasi driver yang akan dipakai
      // Class.forName(JDBC_DRIVER);
      // DriverManager.registerDriver( new com.mysql.jdbc.Driver() );

      // buat koneksi ke database
        connect = DriverManager.getConnection(DB_URL, USER, PASS);
    } catch (Exception e) {
      // kalo ada error saat koneksi
      // maka tampilkan errornya
        e.printStackTrace();
    }

    }

    public static String getAllData()
    {
    connection();

    // isi nilai default dari variabel data
    String data = "Data tidak ditemukan";

    try {

      // buat object statement yang ambil dari koneksi
        statement = connect.createStatement();

      // query select all data from database
        String query = "SELECT idCamera, namaCamera FROM tblbarang WHERE isActive = '1'";

      // eksekusi query-nya
        resultData = statement.executeQuery(query);

      // set variabel data jadi null
        data = "";

        int count = 0;
      // looping pengisian variabel data
        while( resultData.next() ){
        data += "ID Camera : " + resultData.getInt("idCamera") + ", Nama Camera : " + resultData.getString("namaCamera") + "\n";
        count++;
        }
        
        if( count == 0 ){
        data = "Data tidak ditemukan";
        }
        
      // close statement dan connection
        statement.close();
        connect.close();


    } catch (Exception e) {
        e.printStackTrace();
    }

    return data;

    }

    public static String detailData( int id )
    {
    // panggil method static connection
    connection();
    // ini adalah nilai default yang dikembalikan
    String data = "Data tidak ditemukan";

    try {

      // siapin object untuk statement
        statement = connect.createStatement();

      // buat query nya
      String query = "SELECT * FROM tblbarang WHERE isActive = '1' AND idCamera = " + id;

      // eksekusi querynya dan simpan ke result set
        resultData = statement.executeQuery(query);

      // set variabel data jadi null dulu
        data = "";

        int count = 0;
      // looping untuk pengisian variabel data
        while( resultData.next() ){
        data += "- ID Camera : " + resultData.getInt("idCamera")
            + "\n- Nama Camera : " + resultData.getString("namaCamera")
            + "\n- Type Camera : " + resultData.getString("typeCamera")
            + "\n- Stok Camera : " + resultData.getString("stokCamera")
            + " buah\n- Harga Camera : Rp." + resultData.getString("hargaCamera");
        count++;
        }

        if( count == 0 ){
        data = "Data tidak ditemukan";
        }

      // close statement dan koneksinya
        statement.close();
        connect.close();
        
    } catch (Exception e) {
      // tampilkan errornya kalau ada error
        e.printStackTrace();
    }

    // pengembalian string dari method ini
    return data;

    }

    public static String cariData( String keyword )
    {
    connection();

    String data = "Data tidak ditemukan";

    try {

        statement = connect.createStatement();

      String query = "SELECT * FROM tblbarang WHERE isActive = '1' AND ( idCamera LIKE '%" + keyword + "%' OR namaCamera LIKE '%" + keyword + "%' OR hargaCamera LIKE '%" + keyword + "%' OR stokCamera LIKE '%" + keyword + "%' OR typeCamera LIKE '%" + keyword + "%')";

        resultData = statement.executeQuery(query);

        data = "";

        int count = 0;
        while( resultData.next() ){
        data += "- ID Camera : " + resultData.getInt("idCamera")
        + "\n- Nama Camera : " + resultData.getString("namaCamera")
        + "\n- Type Camera : " + resultData.getString("typeCamera")
        + "\n- Stok Camera : " + resultData.getString("stokCamera")
        + " buah\n- Harga Camera : Rp." + resultData.getString("hargaCamera");
    count++;
        data += "\n---------------------\n";
        count++;
        }

        if( count == 0 ){
        data = "Data tidak ditemukan";
        }
        
      // close statement dan koneksinya
        statement.close();
        connect.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return data;

    }

    public static boolean tambahData(String namaCamera, String typeCamera, int stokCamera, int hargaCamera) {
        connection();
        boolean data = false;
    
        try {
            statement = connect.createStatement();
            String query = "INSERT INTO tblbarang VALUES (" + null + ", '" + namaCamera + "', '" + typeCamera + "', " + stokCamera + ", " + hargaCamera + ", '1')";
            int rowsAffected = statement.executeUpdate(query);
    
            if (rowsAffected > 0) {
                data = true;
            }
    
            // close statement dan koneksi
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return data;
    }
    

    public static boolean updateData( int idCamera, String namaCamera, String typeCamera, int stokCamera, int hargaCamera )
    {

    connection();
    boolean data = false;

    try {

        statement = connect.createStatement();

      String queryCek = "SELECT * FROM tblbarang WHERE idCamera = " + idCamera;

        resultData = statement.executeQuery(queryCek);
      // siapin variabel untuk menampung data pada fild satu row
        String namaCek = "";
        String typeCek = "";
        int stokCek = 0, hargaCek = 0;

        while( resultData.next() ){
        namaCek = resultData.getString("namaCamera");
        typeCek = resultData.getString("typeCamera");
        stokCek = resultData.getInt("stokCamera");
        hargaCek = resultData.getInt("hargaCamera");
        }

      // validasi jika yang diisi diconsole kosong
        if( !namaCamera.equalsIgnoreCase("") ){
        namaCek = namaCamera;
        }
        if( !typeCamera.equalsIgnoreCase("") ){
            typeCek = typeCamera;
            }
        if( stokCamera != 0 ){
        stokCek = stokCamera;
        }
        if( hargaCamera != 0 ){
        hargaCek = hargaCamera;
        }

        String queryUpdate = "UPDATE tblbarang SET namaCamera = '" + namaCek + "', typeCamera = '" + typeCek + "', stokCamera = " + stokCek + ", hargaCamera = " + hargaCek + " WHERE idCamera = " + idCamera ;
        
        if( !statement.execute(queryUpdate) ){
        data = true;
        }

      // close statement dan close koneksi
        statement.close();
        connect.close();
        
    } catch (Exception e) {
        e.printStackTrace();
    }


        return data;
    }

    public static boolean deleteData( int idCamera )
    {
    connection();
    boolean data = false;

    try {
        
        statement = connect.createStatement();

      // String query = "DELETE FROM tblbarang WHERE idCamera = " + idCamera;
        String query = "UPDATE tblbarang SET isActive = '0' WHERE idCamera = " + idCamera;

        if( !statement.execute(query) ){
        data = true;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

        return data;
    }


}
