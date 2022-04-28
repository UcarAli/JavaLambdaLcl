import java.util.*;

public class Lambda02 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        System.out.println("   *** ciftKarePrint() ***   ");
        ciftKarePrint(sayi); //1156 484 256 400 64 1444
        System.out.println("\n\n   *** tekKupBirFazlaPrint() ***   ");
        tekKupBirFazlaPrint(sayi);
        System.out.println("\n\n   *** ciftKareKokPrint() ***   ");
        ciftKareKokPrint(sayi);
        System.out.println("\n\n   *** maxElmBul() ***   ");
        maxElmBul(sayi);
        System.out.println("\n\n   *** ciftKareMaxBul() ***   ");
        ciftKareMaxBul(sayi);
        System.out.println("\n\n   *** elmTopla() ***   ");
        elmTopla(sayi);
        System.out.println("\n\n   *** ciftCarp() ***   ");
        ciftCarp(sayi);
        System.out.println("\n\n   *** minBul() ***   ");
        minBul(sayi);
        System.out.println("\n\n   *** bestenBykEnKck() ***   ");
        bestenBykEnKck(sayi);
        System.out.println("\n\n   *** ciftKareKcktenBygePrint() ***   ");
        ciftKareKcktenBygePrint(sayi);
        System.out.println("\n\n   *** tekKareByktenKcgePrint() ***   ");
        tekKareByktenKcgePrint(sayi);



    }

    // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz.
    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t->t*t). // map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
                forEach(Lambda01::yazdir);

    }

    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void tekKupBirFazlaPrint(List<Integer> sayi) {
        sayi.
                stream(). // sayilar akisa alindi
                filter(t-> t%2!=0).
                map(t-> (t*t*t)+1). // tek elemanlar kuplerinin 1 fazlasina update edildi
                forEach(Lambda01::yazdir);
    }

    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz.
    public static void ciftKareKokPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt). // Math class indan sqrt() method call edildi.
//                forEach(Lambda01::yazdir); // yazdir() metdo int. calistigi icin map den cikan datalari calistirmaz
                forEach(t->System.out.print(t+" "));
    }

    // Task : list'in en buyuk elemanini yazdiriniz
    public static void maxElmBul(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max); // akisa giren elemanlarin action sonrasi tek eleman haline getiri
                                    // reduce() den sonra terminal methodu forEach() gelmediginden atama yapip yazdirabiliriz. yada sout icinde yazabiliriz

        System.out.println(maxSayi);
        // Yada
        System.out.println("sout ici : "+sayi.stream().reduce(Math::max));
        /*
         reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde)
         cevirmek icin kullanilir.
         kullanımı yaygındır pratiktir.
         Bir Stream içerisindeki verilerin teker teker işlenmesidir.
         Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç bir sonraki adıma
         girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
         reduce metodu ilk parametrede identity değeri, ikinci parametrede ise
         BinaryOperator türünden bir obj kullanılır.
         reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer
         bir işleme tabi tutulmaktadır.
         İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

         */
    }

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareMaxBul(List<Integer> sayi) {
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Math::max));
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t * t).
                reduce(Integer::max)); // specific class daha hizli rum olur
    }

    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
    //Lambda Expression...
    public static void elmTopla(List<Integer> sayi) {
        int toplam = sayi.stream().reduce(0,(a,b)->a+b); // Lambda Expression...
        /*
        a ilk degerini her zaman atanan degerden (identity) alır
        b degerini her zamana  stream()'dan akısdan alır
        a ilk degerinden sonraki her değeri action(işlem)'dan alır
       */

        System.out.println("Lambda Exp... : "+toplam);

        // Method Ref...
        Optional<Integer> topla = sayi.stream().reduce(Integer::sum);
        System.out.println("Method Ref... : "+topla); // Method Ref...
        // YADA
        System.out.println("Method Ref... : "+sayi.stream().reduce(Integer::sum)); // Method Ref...
    }

    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftCarp(List<Integer> sayi) {
        // Method Referance ... ile
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact));

        //Lambda Expression... ile
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1, (a, b) -> (a * b)));

    }

    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.
    public static void minBul(List<Integer> sayi) {
        //1. yontem Method Reference --> Integer class
        Optional<Integer> minSayiInteger = sayi.stream().reduce(Integer::min);
        System.out.println("minSayiInteger = " + minSayiInteger);
        //2. yontem Method Reference --> Math class
        Optional<Integer> minSayiMath = sayi.stream().reduce(Math::min);
        System.out.println("minSayiMath = " + minSayiMath);
        //3. yontem Lambda Expression
        int minSayiLJambda = sayi.stream().reduce(Integer.MAX_VALUE, (x,y) -> x<y ? x:y);
        System.out.println("minSayiLJambda = " + minSayiLJambda);
        //4. yontem Method Reference --> Haluk class
        Optional<Integer> minSayiMethodRef = sayi.stream().reduce(Lambda02::byMethodMin);
        System.out.println("minSayiMethodRef = " + minSayiMethodRef);
    }
    private static int byMethodMin(int a, int b) {
        return a<b ? a:b;
    }

    // Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void bestenBykEnKck(List<Integer> sayi) {
        System.out.println(sayi.stream().filter(t -> t > 5 && t % 2 == 1).reduce(Lambda02::byMethodMin));
    }

    // Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftKareKcktenBygePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t -> t*t).
                sorted(). // karesi alinan sayilari dogal siraladi (kucukten buyuge)
                forEach(Lambda01::yazdir);

        //sorted() => Doğal düzene göre sıralanmış, bu akışın elemanlarında oluşan bir akış döndürür.
        //Sorted() methodu tekrarlı kullanılırsa en son kullanılan aktif olur.
    }

    // Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.
    public static void tekKareByktenKcgePrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(t -> t%2!=0).
                map(t -> t*t).
                sorted(Comparator.reverseOrder()). // karesi alinan sayilari ters siraladi (buyukten kucuge)
                forEach(Lambda01::yazdir);
    }

}
