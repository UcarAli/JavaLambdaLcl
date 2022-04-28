import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> menü=new ArrayList<>(Arrays.asList("kusleme","adana","trilece",
                "havucDilim","buryan", "yaglama","kokarec","arabAsi","guvec","trilece","trilece","trilece"));

        System.out.println("\n   ***   ");
        System.out.println("   *** alfBykHarfTkrsz() ***   ");
        alfBykHarfTkrsz(menü); //1156 484 256 400 64 1444
        System.out.println("\n\n   *** chrSayisiTersSirali() ***   ");
        chrSayisiTersSirali(menü);
        System.out.println("\n\n   *** chrSayisiKcktenBykSirali() ***   ");
        chrSayisiKcktenBykSirali(menü);
        System.out.println("\n\n   *** sonHarfByktenSirali() ***   ");
        sonHarfByktenSirali(menü);



    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykHarfTkrsz (List<String> yemek){
        yemek.stream().
                //map(t->t.toUpperCase()). //
                map(String::toUpperCase).
                sorted(). // siraladi
                distinct(). // benzersiz (tekrarsiz) hale getirdi
                forEach(t->System.out.print(t+" "));

        // distinct() => Bu method tekrarlı elemanları sadece bir kere yazdırır.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSirali (List<String> menu){
        menu.
                stream(). //akısa alındı
                // map(t->t.length()).
                map(String::length).//elemanlar karakter sayısına update edildi
                sorted(Comparator.reverseOrder()).//ters sıra yapıldı
                distinct().//benzersiz yapıldı
                //forEach(t->System.out.print(t+" "));
                forEach(Lambda01::yazdir);//print edildi, int oldugu icin calisir
    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiKcktenBykSirali (List<String> menu){
        menu.
                stream().
                sorted(Comparator.
                        comparing(String::length)).
                forEach(t->System.out.print(t+" "));
    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfByktenSirali (List<String> menu){
        menu.
                stream().
                sorted(Comparator.
                        comparing(t-> t.toString().
                                charAt(t.toString().length()-1)).
                        reversed()).
                forEach(t->System.out.print(t+" "));
    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..


    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.


    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.


    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.


    // Task : Karakter sayisi en buyuk elemani yazdiriniz.


    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.




}
