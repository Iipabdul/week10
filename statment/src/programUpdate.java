import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;


public class programUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection koneksi = KoneksiDatabase.getKoneksi();
        Statement statement = null;
   try {
       statement = koneksi.createStatement();
       System.out.println("Statement berhasil dibuat");
       String url="UPDATE barang SET nama_barang='PENSIL 2B',jumlah=20,harga=2500 WHERE kode_barang='B001'";
       statement.executeUpdate(url);
   }catch(SQLException ex){
       System.out.println("Statement gagal di buat");
       System.out.println("pesan : "+ex.getMessage() );
   }finally{
       if(statement != null){
           try{
               statement.close();
               System.out.println("Statement berhasil di tutup");
           }catch(SQLException ex){
               System.out.println("Statement gagal ditutup");
               System.out.println("pesan :"+ex.getMessage());
           }
       }
       
   }
    }
    
}
