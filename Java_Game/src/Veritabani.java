

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Veritabani {
	
	Main anasayfa = new Main();
	istatistik_Menu istatistik = new istatistik_Menu();
	
	//Veri tabanı bağlantısı sağlama
	public Connection connect_to_db(String dbname,String user,String pass){
        Connection conn=null;
        // try catch ile hata yakalama işlemini yapıyorum.
        try{
            Class.forName("org.postgresql.Driver");
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if(conn!=null){
                System.out.println("Veritabanı bağlantısı başarılı.");
            }
            else{
                System.out.println("Veritabanı bağlantısı başarısız.");
            }

        }catch (Exception e){
            System.out.println("hata!!\n"+e);
        }
        return conn;
    }
	
	
	//Tabloya veri ekleme
	public void insert_row(Connection conn,String table_name,String ad, String sifre, int puan){
        Statement statement;
        try {
            String query=String.format("insert into %s(ad,sifre,puan) values('%s','%s','%s');",table_name,ad,sifre,puan);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Hesabınız oluşturuldu.");
        }catch (Exception e){
            System.out.println("ekleme sırasında hata\n"+e);
        }
    }
	
	// Veritabanı puan güncelleme
	public void update_puan(Connection conn,String table_name, int id,int yeni_puan){
        Statement statement;
        try {
            String query=String.format("update %s set puan='%s' where id='%s'",table_name,yeni_puan,id);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }
	
	
	// Veritabanı istatistik kısmı
		public void update_istatistik(Connection conn,String columnAdi ,int id){
	        Statement statement;
	        try {
	            String query=String.format("update xxx set %s = %s +1 where id='%s'",columnAdi,columnAdi,id);
	            statement=conn.createStatement();
	            statement.executeUpdate(query);
	            System.out.println("Data Updated");
	        }catch (Exception e){
	            System.out.println(e);
	        }
	    }
	
	
	// Kullanıcı giriş kontrolü
	public void search_by_name(Connection conn, String table_name,String ad,String sifre){
		Statement statement;
        ResultSet rs=null;
        try {
            String query=String.format("select * from %s where ad= '%s' and sifre= '%s'",table_name,ad,sifre);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
                 
            while (rs.next()){
            	
            	anasayfa.veri = true; 
                System.out.print("Giriş Başarılı");

                anasayfa.genelPuan = rs.getInt("puan"); // Veritabanındaki tutulan puanıda buraya ekledim.
                anasayfa.kullaniciid = rs.getInt("id"); //Giren kullanıcının id'sini aldım.
                
                istatistik.SayiTahimD = rs.getInt("sayitahmind"); //Kazanılan sayitahmin oyunu istatistiğini ekliyorum.
                istatistik.SayiTahimY = rs.getInt("sayitahminy"); //Kaybedilen sayitahmin oyunu istatistiğini ekliyorum.
                istatistik.HayvanTahimD = rs.getInt("hayvantahmind");
                istatistik.HayvanTahimY = rs.getInt("hayvantahminy");
                istatistik.survived = rs.getInt("survived");
                istatistik.survivey = rs.getInt("survivey");
                istatistik.makasd = rs.getInt("makasd");   // Taş-Kağıt-Makas oyununun istatistiklerini çekiyorum.
                istatistik.makasy = rs.getInt("makasy");
                
                
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
	
}
