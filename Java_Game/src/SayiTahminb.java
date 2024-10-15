import java.sql.Connection;
import java.util.Random;
import java.util.Scanner;

public class SayiTahminb extends Oyun{
	
	
	public static  void sayitahmingame(){ 
		
		Main anasayfa = new Main();
		
	    System.out.println("Sayı Tahmin Oyununa Hoşgeldiniz");
	    
		Scanner scanner = new Scanner(System.in);
	    Random random = new Random();
	    int tahminEdilecekSayi = random.nextInt(100) + 1; // 1 ile 100 arasında rastgele bir sayı seçiyoruz
	    int tahmin = 0;
	    int can=10;
	    int puan=1000;

	    System.out.println("0 ile 99 arasında bir sayı tahmin edin.");

	    while (can>0) {
	    	System.out.println("Can Hakkınız: "+can);
	        System.out.print("Tahmininiz: ");
	        tahmin = scanner.nextInt();

	        if (tahmin < tahminEdilecekSayi&&can>0) {
	        	can--;
	        	puan-=100;
	        	if(can!=0) {
	        	        System.out.println("Daha büyük bir sayı girin.");
	        	}
	            
	            
	        } 
	         if (tahmin > tahminEdilecekSayi &&can>0) {
	        	 can--;
	             puan-=100;

	        	 if(can!=0) {
	                	System.out.println("Daha küçük bir sayı girin.");
	        	 }
	            
	        } 
	        else if (tahmin==tahminEdilecekSayi){
	            System.out.println("Tebrikler! Doğru tahmin ettiniz.");
	            //Genel İstatistik verisine kazandı diye ekliyorum.
	            if(anasayfa.online == true) {
	            	
		   	        anasayfa.db.update_istatistik(anasayfa.conn, "sayitahmind", anasayfa.kullaniciid);
	            }
	            anasayfa.istatistik.SayiTahimD += 1;
	            break;
	        }
	         
	    }
	    
	    
	    
	    if(can==0) 
	    {
	     System.out.println("can hakkınız bitti. Genel puanınızdan 100 azaltılacak.");
	     
	     //Genel İstatistik verisine kaybını ekliyorum.
	     
	     if(anasayfa.online == true) { // Kullanıcı online giriş yaptı ise bunu yap.
	    	 anasayfa.db.update_istatistik(anasayfa.conn, "sayitahminy", anasayfa.kullaniciid);
	     }
	     anasayfa.istatistik.SayiTahimY += 1; // Yenilgi istatistiğine ekliyorum.
	     
	     anasayfa.genelPuan -= 100;
	     
	     if(anasayfa.genelPuan < 0) { //Genel puanının eskiye düşmesini önledim.
	    	 anasayfa.genelPuan = 0;
	     }
	     
	    }
	    else 
	    {
	    	System.out.println("Puan: "+puan);
	    	anasayfa.genelPuan += puan;
	    	
	    	if(anasayfa.online == true) {
	    		anasayfa.db.update_puan(anasayfa.conn, "xxx", anasayfa.kullaniciid, anasayfa.genelPuan);
	    	}
	    	
	    }
	    	    
	  }

}
