import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
	
	public static int genelPuan=0; //Oyunlardan elde edilen puan ile genel toplam puanı tutar.
	public static int giris=0; // Kullanıcı oyun seçimini tutar.
	public static boolean  veri = false; //Veritabanı login işlemini kontrol eder.
	public static int kullaniciid;  //Connect olan kullanıcının id değerini tutar.
	public static boolean kosul = true; //maindeki while döngüsünün koşulu
	
	public static istatistik_Menu istatistik = new istatistik_Menu();
	public static Veritabani db = new Veritabani();
	public static Connection conn = db.connect_to_db("vt2024", "postgres", "freddy"); //database adı, kullanıcıadı, database sifrem
	public static boolean online = true; 
	
	// main metodu
    public static void main(String[] args) throws FileNotFoundException, IOException {
    	
    	String kullaniciadi="";
		String sifre = "";
		int hesapsecimi = 0;
		
		// Hoşgeldiniz mesajını göster
        hosGeldiniz();

        // Yükleme ekranını göster
        yuklemeEkrani();
        
        //ASCII sembolünü göster
        girisiGoster();

        // Ortadan açılan ekran olacaktı olmadı ama ismi kaldi
        acilisEkrani();

		Scanner input = new Scanner(System.in);
		
		
		while(kosul) 
		{
			System.out.println(" ");
			System.out.println("Welcome to Game Center...");
			System.out.println(" ");
			   
			System.out.println("1- Giriş Yap");
			System.out.println("2- Hesap oluştur");
			String secim = input.nextLine();
			   
			if(secim.equals("1")) 
			{
				System.out.println("1- Online hesap girişi");
				System.out.println("2- Offline hesap girişi");
				hesapsecimi = input.nextInt();
				input.nextLine();
				
			    switch (hesapsecimi) {
	                case 1:
	                	//Online hesap girişi, database connection
	              	   	System.out.print("Kullanıcı adınızı girin: ");
	              	   	kullaniciadi = input.nextLine();
	              	   	System.out.print("Parolanızı girin: ");
	              	   	sifre = input.nextLine();
	              	   	db.search_by_name(conn, "xxx", kullaniciadi, sifre);
	              	   	kosul = false; // döngüden çıkartıyoruz.
	              	   	break;
	     			  
	               case 2:
	            	   // ofline hesap girişi, txt kayıt
	            	   online = false;
	            	   System.out.print("Kullanıcı adınızı girin: ");
	            	   kullaniciadi = input.nextLine();
	            	   System.out.print("Parolanızı girin: ");
	            	   sifre = input.nextLine();
	            	   kosul = false; // döngüden çıkartıyoruz. 
	            	   Localreader okuyucu = new Localreader();
	            	   okuyucu.dosyaOku(kullaniciadi, sifre);
	            	   
		     		   break;
		     		  
	               default:
	            	   
	            	   System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
	            	   break;
		   		}
			}
			
			else if(secim.equals("2")) 
			{
			   

			   System.out.println("1- Online hesap oluştur");
			   System.out.println("2- Offline hesap oluştur");
			   hesapsecimi = input.nextInt();
			   input.nextLine();
			   
			   switch (hesapsecimi) {
	               case 1:
	                   System.out.println("Online hesap oluşturma");
	                   System.out.println("Kullanıcı ekleme paneli");
	                   System.out.print("Kullanıcı adınızı belirleyin: ");
	                   kullaniciadi = input.nextLine();
	                   System.out.print("Parolanızı belirleyin: ");
	                   sifre = input.nextLine();
	                   db.insert_row(conn, "xxx", kullaniciadi, sifre, genelPuan);
	                   break;
	               case 2:
	                   System.out.println("Offline oluşturma");
	                   System.out.println("Kullanıcı ekleme paneli");
	                   System.out.print("Kullanıcı adınızı belirleyin: ");
	                   kullaniciadi = input.nextLine();
	                   System.out.print("Parolanızı belirleyin: ");
	                   sifre = input.nextLine();
	                   
	                   Localsavemaker offlinehesap = new Localsavemaker();
	                   offlinehesap.dosyaOlustur(kullaniciadi, sifre);
	                   break;
	               default:
	                   System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
	                   break;
			   	}
			   
			}
		}
		
		
		if(veri == true) // Kullanıcı girişi başarılıysa veri değişkeni true oluyo.
		{
			int choice = 0;
	    	
			while (choice != 3) {  // 3 seçeneği ile çıkış yapacağız
                
				// Menü ekranını göster
                menu();
                
                choice = input.nextInt();

                switch (choice) {
                case 1:
                	GirisMenu();
                	
                    switch (giris) {
	                    case 1:	           
	                        SayiTahminb.sayitahmingame();
	                        SayiTahminb.Donus();
	                        break;
	                    case 2:	                        
	                        HayvanTahmin.hayvanTahminGame();
	                        HayvanTahmin.Donus();
	                        break;
	                    case 3:	                         
	                        tasKagitMakas.taskagitmakas();
	                        tasKagitMakas.Donus();
	                        break;
	                    case 4:	                        
	                        new Hayatta_kalma();
	                        Hayatta_kalma.Donus();
	                        break;
	                    case 5:
	                        System.out.println("Kim milyoner olmak ister oyunu Seçildi");
                            KimMilyonerOlmakIster.KimMilyoner oMilyoner = new KimMilyonerOlmakIster.KimMilyoner();
                            oMilyoner.basla();
                            
	                        break;
	                    case 6:
	                    	System.out.println("Çıkış yapılıyor....");
	                        break;       
	                    default:
	                        System.out.println("Geçersiz giriş.");
	                        break;
	                
                    }
                    break;
                case 2:                	                    
                    istatistik_Menu b = new istatistik_Menu();
                    b.Goster();
                    break;
                case 3:
                	System.out.println("Çıkılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
		}
		else 
		{
			System.out.println("Kullanıcı adı veya şifreniz yanlış");
		}
    	
	}
	
	
	
	
	public static void menu() {
		System.out.println(" ");
    	System.out.println("######################################");
        System.out.println("#--------------- MENÜ ---------------#");
        System.out.println("#--------- 1. Oyun Menüsü------------#");
        System.out.println("#------- 2. İstatistik Menüsü--------#");
        System.out.println("#------------ 3. Çıkı----------------#");
        System.out.println("#------------------------------------#");
        System.out.println("######################################");
        System.out.print("Seçiminizi yapınız: ");
    }
	
	
	 public static void hosGeldiniz() {
	        System.out.println("*****************************************");
	        System.out.println("*                                       *");
	        System.out.println("*        Gaming Center Açılıyor!        *");
	        System.out.println("*                                       *");
	        System.out.println("*****************************************");
	        System.out.println("HAZIRLAYAN: Emin Can, Alihan, Burak");
	        System.out.println();
	    }
	 
	 
	 
	 public static final String[] intro = {
	    		"######################################",
	            "         ⠀⢠⣶⣿⣿⣗⡢⠀⠀⠀⠀⠀⠀⠉⢤⣒⣿⣿⣷⣆⠀⠀      ",
	            "         ⠀⠋⠉⠉⠙⠻⣿⣷⡄⠀⠀⠀⣴⣿⠿⠛⠉⠉⠉⠃⠀      ",
	            "         ⠀⠀⢀⡠⢤⣠⣀⡹⡄⠀⠀⠀⡞⣁⣤⣠⠤⡀⠀⠀⠀       ",
	            "         ⢐⡤⢾⣿⣿⢿⣿⡿⠀⠀⠀⠀⠸⣿⣿⢿⣿⣾⠦⣌⠀       ",
	            "         ⠁⠀⠀⠀⠉⠈⠀⠀⣸⠀⠀⢰⡀⠀⠈⠈⠀⠀⠀⠀⠁        ",
	            "         ⠀⠀⠀⠀⠀⠀⣀⡔⢹⠀⠀⢸⠳⡄⡀⠀⠀⠀⠀⠀⠀        ",
	            "         ⠸⡦⣤⠤⠒⠋⠘⢠⡸⣀⣀⡸⣠⠘⠉⠓⠠⣤⢤⡞⠀      ",
	            "         ⠀⢹⡜⢷⣄⠀⣀⣀⣾⡶⢶⣷⣄⣀⡀⢀⣴⢏⡾⠁       ",
	            "         ⠀⠀⠹⡮⡛⠛⠛⠻⠿⠥⠤⠽⠿⠛⠛⠛⣣⡾⠁⠀⠀      ",
	            "         ⠀⠀⠀⠙⢄⠁⠀⠀⠀⣄⣀⡄⠀⠀⠀⢁⠞⠀⠀⠀⠀       ",
	            "         ⠀⠀⠀⠀⠀⠂⠀⠀⠀⢸⣿⠀⠀⠀⠠⠂⠀⠀⠀⠀⠀        ",
	            "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀        ",
	            "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀        ",
	            "######################################",
	            "         _____            _____ ",
	            "        / ____|         / _____| ",
	            "        | |  __         | |     ",
	            "        | | |_ |        | |     ",
	            "        | |__| |        | |____ ",
	            "        \\______|        \\______|",
	            "",
	            "           IT'S IN THE GAME",
	            "######################################"
	        };
	 
	 
	 public static void yuklemeEkrani() {
         
         System.out.print("Yükleniyor \n");

         for (int i = 0; i < 30; i++) {
             try {
                 Thread.sleep(40); // 0.25 saniye bekliyor
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.print("▰");

         }

         System.out.println("\nYüklendi, Hadi bakalım!");
         try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     }
	 
	 
	// ASCII sanatı ile sembolleri gösteren metod
     public static void girisiGoster() {
         for (String line : intro) {
             System.out.println(line);
             try {
             	Thread.sleep(35);
             }catch(InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
             }
         }
     }
     
    
  // Ortadan açılan ekran efektini gösteren metod
     public static void acilisEkrani() {
         for (int i = 0; i < 10; i++) {
             System.out.print("-");
             try {
                 Thread.sleep(40); // 0.1 saniye bekle
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         System.out.println("\nAçılıyor...\n");
     }
	
	
	public static void GirisMenu() 
	{
		Scanner input = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("HOŞGELDİNİZ...");
		System.out.println(" ");
		System.out.println("Toplam puanınız: "+genelPuan);
		System.out.println("Oyun Menüsü ve Oyunlar:");
    	System.out.println("1. Oyun: Sayı Tahmin oyunu.");
    	System.out.println("2. Oyun: Hayvan Tahmin oyunu.");
    	System.out.println("3. Oyun: Taş-Kağıt-Makas oyunu.");
    	System.out.println("4. Oyun: Hayatta Kalma oyunu.");
    	System.out.println("5. Oyun: Kim milyoner olmak ister.");
    	System.out.println("Çıkış yapmak için 6 giriniz.");
    	System.out.print("Seçiminizi yapınız: ");
		giris = input.nextInt();
	}
	
	
	
	
    
}