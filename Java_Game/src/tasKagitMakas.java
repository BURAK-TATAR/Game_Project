import java.util.Random;
import java.util.Scanner;

public class tasKagitMakas extends Oyun{ 
    public static void taskagitmakas() {
    	Main anasayfa = new Main();
        System.out.println("Taş Kağıt Makas Oyununa Hoşgeldiniz");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] dizi = {"taş", "kağıt", "makas"};
        System.out.println("SEÇİM YAPINIZ: taş, kağıt, makas");
        String secim = scanner.nextLine();

        System.out.println("Bilgisayar Seçimini yaptı");
        int computer = random.nextInt(3);
        String compuersecim = dizi[computer];

        if (secim.equals(compuersecim)) {
            System.out.println("Berabere! Tekrar deneyin.");
        } else if ((secim.equals("taş") && compuersecim.equals("makas")) ||
                   (secim.equals("kağıt") && compuersecim.equals("taş")) ||
                   (secim.equals("makas") && compuersecim.equals("kağıt"))) {
            System.out.println("Tebrikler, kazandınız! +10 puan");
            
            anasayfa.genelPuan += 10;                                    
            anasayfa.istatistik.makasd += 1;
            
            if(anasayfa.online == true) {
            	anasayfa.db.update_puan(anasayfa.conn, "xxx", anasayfa.kullaniciid, anasayfa.genelPuan);
            	anasayfa.db.update_istatistik(anasayfa.conn, "makasd", anasayfa.kullaniciid);
            }
            
        } else {
            System.out.println("Üzgünüz, bilgisayar kazandı! -10 puan");
            anasayfa.genelPuan -= 10; // genel puandan 10 azaltıyoruz.
            
            if(anasayfa.genelPuan < 0) //Puan sıfırın altına inmesin diye böyle bir kontrol sağlıyoruz
            	anasayfa.genelPuan = 0;
            
            if(anasayfa.online == true) {
            	anasayfa.db.update_puan(anasayfa.conn, "xxx", anasayfa.kullaniciid, anasayfa.genelPuan);
            	anasayfa.db.update_istatistik(anasayfa.conn, "makasy", anasayfa.kullaniciid);
            }                        
            
            anasayfa.istatistik.makasy += 1;
            
            
        }

        System.out.println();
        

    }

    
}
