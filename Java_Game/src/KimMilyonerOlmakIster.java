import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KimMilyonerOlmakIster{

    // Para sorusu sınıfı
    public static class ParaSorusu {
		private String paras;
        private String[] secenekler;
        private char dogrucevap;
        private int odul;

        public ParaSorusu(String paras, String[] secenekler, char dogrucevap, int odul) {
            this.paras = paras;
            this.secenekler = secenekler;
            this.dogrucevap = dogrucevap;
            this.odul = odul;
        }

        public String sorual() {
            return paras;
        }

        public String[] seceneklerial() {
            return secenekler;
        }

        public char dogrucevabial() {
            return dogrucevap;
        }

        public int odulal() {
            return odul;
        }
    }

    // Quiz sınıfı
    public static class Soru {
        private List<ParaSorusu> questions;

        public Soru() {
            questions = new ArrayList<>();
            soruEkle();
        }

        private void soruEkle() {
            questions.add(new ParaSorusu("Dünyanın en büyük okyanusu hangisidir?",
                new String[]{"a) Atlantik Okyanusu", "b) Hint Okyanusu", "c) Arktik Okyanusu", "d) Pasifik Okyanusu"}, 'd', 100));
            questions.add(new ParaSorusu("Türkiye'nin başkenti neresidir?",
                new String[]{"a) İstanbul", "b) Ankara", "c) İzmir", "d) Antalya"}, 'b', 100));
            questions.add(new ParaSorusu("Hangi gezegen Güneş Sistemi'nde en büyük gezegendir?",
                new String[]{"a) Mars", "b) Jüpiter", "c) Satürn", "d) Venüs"}, 'b', 100));
            questions.add(new ParaSorusu("Hangisi bir pirinç türüdür?",
                new String[]{"a) Basmati", "b) Mozzarella", "c) Cheddar", "d) Brie"}, 'a', 100));
            questions.add(new ParaSorusu("Mozart hangi dönemin bestecisidir?",
                new String[]{"a) Barok", "b) Rönesans", "c) Klasik", "d) Romantik"}, 'c', 300));
            questions.add(new ParaSorusu("Hangisi bir yılan türüdür?",
                new String[]{"a) Kobra", "b) Ankylosaurus", "c) Tyrannosaurus", "d) Triceratops"}, 'a', 300));
            questions.add(new ParaSorusu("Hangi renk birincil renklerdendir?",
                new String[]{"a) Yeşil", "b) Sarı", "c) Kırmızı", "d) Mor"}, 'c', 500));
            questions.add(new ParaSorusu("Hangi şehir Amerika Birleşik Devletleri'nin başkentidir?",
                new String[]{"a) New York", "b) Los Angeles", "c) Chicago", "d) Washington D.C."}, 'd', 500));
            questions.add(new ParaSorusu("Hangi elementin simgesi 'Fe'dir?",
                new String[]{"a) Kurşun", "b) Demir", "c) Kalay", "d) Altın"}, 'b', 1000));
            questions.add(new ParaSorusu("Hangi ünlü bilim insanı yerçekimi yasalarını keşfetmiştir?",
                new String[]{"a) Galileo Galilei", "b) Nikola Tesla", "c) Isaac Newton", "d) Albert Einstein"}, 'c', 1000));
            questions.add(new ParaSorusu("Hangi şehir İtalya'nın başkentidir?",
                new String[]{"a) Venedik", "b) Milano", "c) Roma", "d) Napoli"}, 'c', 2000));
            questions.add(new ParaSorusu("Elektrik akımının birimi nedir?",
                new String[]{"a) Volt", "b) Ohm", "c) Amper", "d) Watt"}, 'c', 2000));
            questions.add(new ParaSorusu("Hangi yıl Birinci Dünya Savaşı başlamıştır?",
                new String[]{"a) 1905", "b) 1914", "c) 1923", "d) 1939"}, 'b', 5000));
            questions.add(new ParaSorusu("Dünyanın en uzun nehri hangisidir?",
                new String[]{"a) Nil", "b) Amazon", "c) Yangtze", "d) Mississippi"}, 'a', 5000));
            questions.add(new ParaSorusu("Hangi elementin atom numarası 1'dir?",
                new String[]{"a) Helyum", "b) Hidrojen", "c) Lityum", "d) Karbon"}, 'b', 10000));
            questions.add(new ParaSorusu("Hangi gezegenin halkaları vardır?",
                new String[]{"a) Mars", "b) Venüs", "c) Jüpiter", "d) Satürn"}, 'd', 10000));
            questions.add(new ParaSorusu("Hangi ülkenin bayrağında kırmızı arka plan üzerinde beyaz bir çarpı bulunmaktadır?",
                new String[]{"a) İsveç", "b) Norveç", "c) Danimarka", "d) Finlandiya"}, 'c', 50000));
            questions.add(new ParaSorusu("Dünyanın en derin noktası neresidir?",
                new String[]{"a) Marina Çukuru", "b) Challenger Çukuru", "c) Tonga Çukuru", "d) Kuril-Kamchatka Çukuru"}, 'a', 50000));
            questions.add(new ParaSorusu("Dünyanın en kalabalık şehri hangisidir?",
                new String[]{"a) Tokyo", "b) New York", "c) Şangay", "d) Mumbai"}, 'a', 1000000));
            questions.add(new ParaSorusu("İlk modern olimpiyat oyunları hangi yıl düzenlendi?",
                new String[]{"a) 1896", "b) 1900", "c) 1924", "d) 1936"}, 'a', 1000000));
        }

        public List<ParaSorusu> getQuestions() {
            return questions;
        }
    }

    // oyun sınıfı
    public static class KimMilyoner {
    	Main anasayfa = new Main();
        private Soru soru;
        private Scanner scanner;

        public KimMilyoner() {
            this.soru = new Soru();
            this.scanner = new Scanner(System.in);
        }

        public void basla() {
            List<ParaSorusu> sorular = soru.getQuestions();
            int totalReward = 0;

            for (ParaSorusu psorular : sorular) {
                System.out.println(psorular.sorual());
                String[] secenekler = psorular.seceneklerial();
                for (String secenek : secenekler) {
                    System.out.println(secenek);
                }
                System.out.print("Cevabınızı girin (a, b, c, d): ");
                char cevap = scanner.next().charAt(0);

                if (cevap == psorular.dogrucevabial()) {
                    totalReward += psorular.odulal();
                    System.out.println("Doğru cevap! Kazandığınız para: " + psorular.odulal() + " puan");
                } else {
                    System.out.println("Yanlış bildiniz! Doğru cevap "+psorular.dogrucevabial()+" olmalı");
                    System.out.println(" 150 puan eksilecektir.");
                    totalReward = totalReward - 150;
                    break;
                }
            }

            System.out.println("Toplam kazancınız: " + totalReward + " TL");
            anasayfa.genelPuan += totalReward;
            if(anasayfa.genelPuan < 0)
            	anasayfa.genelPuan = 0;
            
            if(anasayfa.online == true) { // kullanıcı online giris yapmısmı bakar.
            	anasayfa.db.update_puan(anasayfa.conn, "xxx", anasayfa.kullaniciid, anasayfa.genelPuan);
            }            
            
        }
    }
}
