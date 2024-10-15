import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Localreader {
	
	Main anasayfa = new Main();
	
	public void dosyaOku(String profilismi, String sifre) throws FileNotFoundException, IOException{
		
        // Java kodunun bulunduğu diziyi alırız ki sonra o konumda profil dosyalarımızı depolayabiliriz
        String suankiYol = System.getProperty("user.dir");
        String dosyaIsmi = "profiller"; // kontrol edilecek dosyanın ismi
        String textDosyaIsmi = profilismi + ".txt"; // içine bakılacak olan dosyanın ismi

        // Klasörün ve dosyanın tam yolu
        File depo = new File(suankiYol + File.separator + dosyaIsmi);
        File profil = new File(depo + File.separator + textDosyaIsmi);

        // Kayıt dosyasının var olup olmadığını kontrol et ve yoksa oluştur
        if (profil.exists()) {
        	try (BufferedReader okunacak = new BufferedReader(new FileReader(profil))) {
                String satir;
                while ((satir = okunacak.readLine()) != null) {
                    if (satir.contains(sifre)) {
                       anasayfa.veri = true;
                       System.out.println("giriş başarılı!");
                       break;
                    }
                }
       } 
    }

  }
       
}


