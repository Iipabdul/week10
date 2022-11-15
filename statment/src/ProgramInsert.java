import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;


public class ProgramInsert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection koneksi = KoneksiDatabase.getKoneksi();
        Statement statement = null;
   try {
       statement = koneksi.createStatement();
       System.out.println("Statement berhasil dibuat");
       String url="INSERT INTO barang(kode_barang,nama_barang,jumlah,harga)VALUES('B001', 'BUKU GAMBAR', 10, 3000)";
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
