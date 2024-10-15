
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Localsavemaker {

	public void dosyaOlustur(String profilismi, String sifre){
			
		
        // Java kodunun bulunduğu diziyi alırız ki sonra o konumda profil dosyalarımızı depolayabiliriz
        String suankiYol = System.getProperty("user.dir");
        String dosyaIsmi = "profiller"; // Oluşturulacak klasörün adı
        String textDosyaIsmi = profilismi + ".txt"; // Oluşturulacak dosyanın adı

        // Klasörün ve dosyanın tam yolu
        File depo = new File(suankiYol + File.separator + dosyaIsmi);
        File profil = new File(depo + File.separator + textDosyaIsmi);

        // Klasörü oluştur
        if (!depo.exists()) {
            if (depo.mkdir()) {
                System.out.println(dosyaIsmi + " klasörü oluşturuldu.");
            } else {
                System.out.println(dosyaIsmi + " klasörü oluşturulamadı.");
                return;
            }
        }
        // Kayıt dosyasının var olup olmadığını kontrol et ve yoksa oluştur
        if (profil.exists()) {
            System.out.println(textDosyaIsmi + " Profili mevcut, başka bir isim giriniz...");
        } 
        else {
            try {
                if (profil.createNewFile()) {
                    System.out.println(textDosyaIsmi + " Profili oluşturuldu!");
                    FileWriter sifreyazici = new FileWriter(profil);
                    sifreyazici.write(sifre);
                    sifreyazici.close();
                } else {
                    System.out.println(textDosyaIsmi + " Profili oluşturulamadı!");
                }
            } catch (IOException e) {
                System.out.println("Dosya oluşturulurken bir hata oluştu: " + e.getMessage());
            }
        }
    }
}