
public class istatistik_Menu {
	
	public static int SayiTahimD; // Sayi Tahmin kazanma Sayısı
	public static int SayiTahimY; // Sayi Tahmin kaybetme Sayısı
	public static int HayvanTahimD; // Hayvan Tahmin kazanma Sayısı
	public static int HayvanTahimY; // Hayvan Tahmin kaybetme Sayısı
	public static int survived; // Hayatta kalma oyunu kazanma sayısı;
	public static int survivey; // Hayatta kalma oyunu kaybetme sayısı;
	public static int makasd;  // Taş Kağıt Makas Kazanma sayısı;
	public static int makasy;  // Taş Kağıt Makas Kaybetme sayısı;
	
	public void Goster(){
		Main anasayfa = new Main();
		System.out.println(" ");
		System.out.println("  ");                           
        System.out.println("#--------- Başarım Menüsü  -------#");
        
        System.out.println("Toplam Puanınız: "+ anasayfa.genelPuan);
        System.out.println("#######################################");                              
        System.out.println("#---------- Sayı Tahmin Oyunu   -------#");
        System.out.println("#------Kazandığım oyun sayısı: "+SayiTahimD+"------#");
        System.out.println("#------Kaybettiğim oyun sayısı: "+SayiTahimY+"------#");
        System.out.println("#######################################");
        System.out.println("#---------- Hayvan Tahmin Oyunu   -------#");
        System.out.println("#------Kazandığım oyun sayısı: "+HayvanTahimD+"------#");
        System.out.println("#------Kaybettiğim oyun sayısı: "+HayvanTahimY+"------#");
        System.out.println("#######################################");
        System.out.println("#---------- Hayatta Kalma Oyunu -------#");
        System.out.println("#------Kazandığım oyun sayısı: "+survived+"------#");
        System.out.println("#------Kaybettiğim oyun sayısı: "+survivey+"------#");
        System.out.println("#######################################");
        System.out.println("#--------- Taş-Kağıt-Makas Oyunu ------#");
        System.out.println("#------Kazandığım oyun sayısı: "+makasd+"------#");
        System.out.println("#------Kaybettiğim oyun sayısı: "+makasy+"------#");
        System.out.println("#######################################");
        
        
        System.out.println(" ");
	}
	
	
}