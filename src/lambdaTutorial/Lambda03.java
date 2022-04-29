package lambdaTutorial;

import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> menu=new ArrayList<>(Arrays.asList("kusleme","adana","trilece",
                "havucDilim","buryan", "yaglama","kokarec","arabAsi","guvec","trilece","trilece","trilece", "waffle", "welwmwn", "cacix"));


        System.out.println("   *** alfBykHarfTkrsz() ***   ");
        alfBykHarfTkrsz(menu); //1156 484 256 400 64 1444
        System.out.println("\n\n   *** chrSayisiTersSirali() ***   ");
        chrSayisiTersSirali(menu);
        System.out.println("\n\n   *** chrSayisiKcktenBykSirali() ***   ");
        chrSayisiKcktenBykSirali(menu);
        System.out.println("\n\n   *** sonHarfByktenSirali() ***   ");
        sonHarfByktenSirali(menu);
        System.out.println("\n\n   *** charKaresiCiftElSirali() ***   ");
        charKaresiCiftElSirali(menu);
        System.out.println("\n\n   *** harfSayisi7denAzKontrol() ***   ");
        harfSayisi7denAzKontrol(menu);
        System.out.println("\n\n   *** wIleBaslayanElmKontrol() ***   ");
        wIleBaslayanElmKontrol(menu);
        System.out.println("\n\n   *** xIleBitenElmKontrol() ***   ");
        xIleBitenElmKontrol(menu);
        System.out.println("\n\n   *** charSayisiBykElmPrint() ***   ");
        charSayisiBykElmPrint(menu);
        System.out.println("\n\n   *** ilkElmHaricSonHrfSiraliPrint() ***   ");
        ilkElmHaricSonHrfSiraliPrint(menu);



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
    public static void charKaresiCiftElSirali (List<String> menu){
        menu.
                stream().//akısa alndı
                map(t -> t.length() * t.length()).//akısdaki string elemanları boyutlarının karesine update edildi
                filter(Lambda01::ciftBul).//cift elelmalar filtrelendi
                distinct().//tekrarsız yapıldı
                sorted(Comparator.reverseOrder()).//ters b->k sıra yapıldı
                forEach(Lambda01::yazdir);// print edildi
    }


    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7denAzKontrol (List<String> menu){
        // amele code :)
        System.out.println("amele code");
        boolean kontrol = menu.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) {
            System.out.println("list elemanları 7 ve daha az harften olusuyor");
        } else System.out.println("list elemanları 7 harften  buyuk");
        // cincik code :)
        System.out.println("cincix code");
        System.out.println(menu.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanları 7 ve daha az harften olusuyor" :
                "list elemanları 7 harften  buyuk");

        //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
        //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
        //noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
    }

    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanElmKontrol (List<String> menu){
        System.out.println(menu.
                stream().
                noneMatch(t->t.startsWith("w")) ? "agam w ile baslayan yemahh olu mu ?" :
                "agam wenemen ne menen bi sey ?");
    }

    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBitenElmKontrol (List<String> menu){
        System.out.println(menu.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "agam senden bir  cacix olmaz  ?" :
                "agam senin aradigin yemek bu torpaklarda yooogggg");
    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSayisiBykElmPrint (List<String> menu){
        System.out.println(menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                findFirst()); // ilk eleman alindi


        // akıs cıktısını bir veriable assaign edilebilir

        Optional<String> enBykKrEl= menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                findFirst(); // ilk eleman alindi
        System.out.println(enBykKrEl);

        //veya
        Stream<String> sonIsim = menu.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                // findFirst() yerine asagidaki gibi
                limit(1);//limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır.

        // sonIsim.toArray()--> limit() meth return dan dolayı  stream type olan sonIsim toArray() method ile array type convert edildi
        System.out.println(Arrays.toString(sonIsim.toArray()));//arraya cevrilen sonIsim stream print edildi
 /*
  TRİCK : Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz. Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
•  Ör; System.out.println(Arrays.toString(stream.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.
   */

        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.
    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElmHaricSonHrfSiraliPrint (List<String> menu){
        menu.
                stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). //son harfe gore siralandi
                skip(1). //ilk eleman atlandı -->adana
                forEach(t->System.out.print(t+" "));

        //skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından oluşan bir akış return eder.
        // Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
        //skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.
    }

}
