import java.util.Scanner;

public abstract class Oyun { // abstract tanımladım. Bu classdan nesne üretilmesin. Soyutlanmış class
	
	// bu class hepsinde ortak olucak bazı şeylerin bulunmasını sağlar.
	//Donus metodu hepsi tarafından miras alınsın
	
	public static void Donus(){
		String karakter;
		Scanner scan = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("Ana Menüye Dönmek için  " + " m " +" Basın  ");
		System.out.println("Tekrar Oynamak için  " +" r "+" Basın ");
		Main anasayfa=new Main();
        karakter=scan.nextLine();
         
         if(karakter.equals("m")) 
         {
        	anasayfa.kosul = false; // Anasayfaya gittiğinde tekrar senden kullanıcı adı şifre istemesin diye false yaptım
        	return;
         }
         
         else if(karakter.equals("r")){
        	 if(anasayfa.giris == 1) 
        	 {
        		 SayiTahminb s = new SayiTahminb();
     			 s.sayitahmingame();
        	 }
        	 else if(anasayfa.giris == 2) 
        	 {
        		 HayvanTahmin ht = new HayvanTahmin();
     			 ht.hayvanTahminGame();
        	 }
        	 else if(anasayfa.giris == 3) 
        	 {
        		 tasKagitMakas t = new tasKagitMakas();
        		 t.taskagitmakas();
        	 }
        	 else if(anasayfa.giris == 4) 
        	 {
        		 Hayatta_kalma s = new Hayatta_kalma();
        	 }
        	 else if(anasayfa.giris == 5) 
        	 {
        		 KimMilyonerOlmakIster.KimMilyoner oMilyoner = new KimMilyonerOlmakIster.KimMilyoner();
                 oMilyoner.basla();
        	 }
        }
	}
}
