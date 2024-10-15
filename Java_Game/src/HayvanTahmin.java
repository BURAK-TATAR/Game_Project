import java.util.Random;
import java.util.Scanner;

public class HayvanTahmin extends Oyun{
	
	public static void hayvanTahminGame(){
		Main anasayfa = new Main();
		
		
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] hayvanlar = {"antilop", "arı", "aslan", "at", "ay", "balık", "balina", "baykuş", "boğa", "böcek", "çakal", "çekirge", "çita", "denizanası",
                "deve", "domuz", "eşşek", "fare", "fil", "güvercin", "hamster", "hindi", "horoz", "impala", "inek", "jaguar", "kanguru", "kaplan", "kaplumbağa",
                "karga", "karınca", "karıncayiyen", "kartal", "keçi", "kedi", "kelebek", "koala", "koyun", "köpek", "köstebek", "kunduz", "kurbağa", "kurt",
                "kuş", "kuzu", "leopar", "martı", "maymun", "ördek", "örümcek", "papağan", "pelikan", "penguen", "rakun", "serçe", "sivrisinek", "şahin", "tavşan",
                "tavuk", "tilki", "timsah", "yarasa", "yılan", "yunus", "zebra", "zürafa"};

        int can = 10;
        int hayvanIndex = random.nextInt(hayvanlar.length);
        String secilenHayvan = hayvanlar[hayvanIndex];
        System.out.println(" ");
        System.out.println("Hayvan Adı Tahmin Etme Oyununa Hoşgeldiniz");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Toplamda " + secilenHayvan.length() + " harften oluşan bir hayvan adı seçildi.");

        
        
        boolean[] dogruTahminler = new boolean[secilenHayvan.length()];  // sonradan ekledim 
        
                
        while (can > 0) 	{
            System.out.print("Harf Giriniz: ");
            char girilenHarf = scanner.next().charAt(0);
            String girilenKelime = String.valueOf(girilenHarf);
            

            boolean dogruHarf = false;
            for (int i = 0; i < secilenHayvan.length(); i++)
            {
                if (girilenHarf == secilenHayvan.charAt(i)) 
                {
                    System.out.println("Kelimenin " + (i + 1) + ". harfi doğru.");
                    dogruHarf = true;
                    dogruTahminler[i] = true;                ///////////////////////////// sonradan ekledim                   
                }
                
            }
            System.out.println();
            if (!dogruHarf) {
                can--;
                System.out.println("Bu harf hayvan adında yok. Kalan can: " + can);
            }

            
           
            boolean kazandi = true;
            for (int i = 0; i < secilenHayvan.length(); i++) {
                if (!dogruTahminler[i]) {
                    kazandi = false;
                    break;
                }
            }
            
            
            if (kazandi) {
                System.out.println("Tebrikler, doğru hayvanı buldunuz: " + secilenHayvan);
                if(can == 1 || can==2 || can==3) { //şimdi can sayısına göre puan vericem. Ana puana eklicem.
                	System.out.println("100 puan genel puanınıza eklendi.");
                	anasayfa.genelPuan += 100;
                	
                }
                else if(can == 4 || can==5 || can==6) {
                	System.out.println("250 puan genel puanınıza eklendi.");
                	anasayfa.genelPuan += 250;
                	
                	
                	
                }
                else {
                	System.out.println("350 puan genel puanınıza eklendi.");
                	anasayfa.genelPuan += 350;
                	
                }
                
                //istatistik verisi
                if(anasayfa.online == true)
                	anasayfa.db.update_istatistik(anasayfa.conn, "hayvantahmind", anasayfa.kullaniciid);
                
                anasayfa.istatistik.HayvanTahimD +=1;
                break;
            }
            
        }

        if (can == 0) {
            System.out.println("Üzgünüz, can hakkınız bitti. Doğru hayvan: " + secilenHayvan);
            System.out.println("200 puan çıkarılıyor.");
            anasayfa.genelPuan -= 200;
            if(anasayfa.genelPuan < 0)
            	anasayfa.genelPuan = 0;
            
            //İstatistik verisi
            if(anasayfa.online == true)
               anasayfa.db.update_istatistik(anasayfa.conn, "hayvantahminy", anasayfa.kullaniciid);
            anasayfa.istatistik.HayvanTahimY += 1;
        }
        
        //Puan güncellemesini veritabanınada ekliyorum.
        if(anasayfa.online == true)
        	anasayfa.db.update_puan(anasayfa.conn, "xxx", anasayfa.kullaniciid, anasayfa.genelPuan);
        

    }

	
	
}
