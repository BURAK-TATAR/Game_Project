import java.util.Scanner;

public class Hayatta_kalma extends Oyun{
	Scanner input = new Scanner(System.in);
	Main anasayfa = new Main();
	
	public Hayatta_kalma() { // Constactor metot içine kodları yazıyorum.
		System.out.println(" ");
		System.out.println("HAYATTA KALMA OYUNU BAŞLIYOR....\n*************************");
		System.out.println("Oyun Hakkında kısa bilgi");
		System.out.println("Kullanıcı seçimlerine göre ilerleyen gerilim-macera oyunu");
		System.out.println("***************************************");
		
		System.out.println(" ");
		System.out.println("Yaz tatilinden eve döndünüz. Ve yazlıkta bilgisayarınızı unuttunuz.\nİçinde işiniz ve sizin "
				+ "için önemli bilgiler var. Bilgisayarı almanız gerekiyor.\nYazlık 3 saatlik uzaklıkta\n ");
		System.out.println("A-)Şimdi al(saat:18.00)");
		System.out.println("B-)Yarın sabah erkenden almaya git.");
		String c1 = input.nextLine(); // kullanıcıdan seçimler alıyorum
		
		if(c1.equals("A")|| c1.equals("a")) {
			aksam(); // kodlar düzenli gözüksün diye seneryoları metotlara böldüm.
			String c2 = input.nextLine();
			if(c2.equals("A")|| c2.equals("a")) {
				kayip();
			}
			else if(c2.equals("B")|| c2.equals("b")) {
				resim();
				String c3 = input.nextLine();
				if(c3.equals("A")|| c3.equals("a")) {
					kayip();
				}
				else if(c3.equals("B")|| c3.equals("b")) {
					bekledin();
				}
			}
		}
		else if(c1.equals("B")|| c1.equals("b")) {
			sabah();
			String c4 = input.nextLine();
			if(c4.equals("A")|| c4.equals("a")) {
				System.out.println("Polise gittin iş uzadı. Hırsızlar kaçtı");
				kayip();
			}else if(c4.equals("B")|| c4.equals("b")) {
				gezinti();
				String c5 = input.nextLine();
				if(c5.equals("A")|| c5.equals("a")){
					kayip();
				}else if(c5.equals("B")|| c5.equals("b")){
					suphesiz();
				}
			}
		}
		//Puan güncellemesini veritabanına ekliyorum
		if(anasayfa.online == true) {
			anasayfa.db.update_puan(anasayfa.conn, "xxx", anasayfa.kullaniciid, anasayfa.genelPuan);
		}
	}
	
	
	public void aksam() {
		System.out.println("Çantanı hazırladın ve arabana binip yola"
				+ " koyuldun.Araban arzalandı. Issız bir arazide arabasız kaldın\n"
				+ "evin 15dk uzaklıkta hat çekmiyo. Eve yürüdün uzaktan\nevinin kapısının açık olduğunu gördün.\n"
				+ "hırsızlar evi yağmalıyor.");
		System.out.println("A-)Hırsızlara Saldır.");
		System.out.println("B-)Resimlerini Çek");
	}
	
	public void sabah() {
		System.out.println("Ertesi sabah erkenden yola çıktın. Hava güneşli eve sorusuz ulaştın.\n"
				+ "Eve girdin. Bilgisayarın yerinde yok. Ve ev yağmalanmış.");
		System.out.println("A-)Polise git");
		System.out.println("B-)Etrafta gezintiye çık.");
	}
	
	public void gezinti() {
		System.out.println("Gezinti esnasında şüpheli araç gördün\niçindekilerden ");
		System.out.println("A-)Şüphelen\nB-)Şüphelenme");
	}
	
	public void suphesiz() {
		System.out.println("İlerlemeye devam ettin ve ilerde jandarmalar tarafından yakalanmış\n"
				+ "bir grup gördün ve jandarmalar sana bilgisayarını teslim etti.");
		kazandin();
	}
	
	public void kayip() {
		System.out.println("KAYBETTİN!!!!");
		System.out.println("Genel Puanınızdan 200 eksildi");
		anasayfa.genelPuan -= 200;
		
		if(anasayfa.genelPuan < 0)
			anasayfa.genelPuan = 0;
		System.out.println(" ");
		
		//İstatisik verisi için ekleme
		if(anasayfa.online == true)
			anasayfa.db.update_istatistik(anasayfa.conn, "survivey", anasayfa.kullaniciid);
		anasayfa.istatistik.survivey += 1;
	}
	
	public void resim() {
		System.out.println(" ");
		System.out.println("Resimlerini çektin");
		System.out.println("A-)eve geri dön");
		System.out.println("B-)gitmelerini bekle");
	}
	public void bekledin() {
		System.out.println("Hırsızların peşinden gittin bir mola verdikleri esnada\nbilgisayarı gizlice onlardan aldın.");
		kazandin();
	}
	public void kazandin() 
	{
		System.out.println("Kazandın... +200 puan");
		anasayfa.genelPuan += 200;
		
		//İstatistik verisi alıyorum.
		if(anasayfa.online == true) {
		    anasayfa.db.update_istatistik(anasayfa.conn, "survived", anasayfa.kullaniciid);
		}
		anasayfa.istatistik.survived += 1;
	}

}
