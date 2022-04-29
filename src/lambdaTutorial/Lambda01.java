package lambdaTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        /*
           1) Lambda "Functional Programming"-->mathod(action) kullanma prog dili.
              Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
              Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
              Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
              Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

              "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
           2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
           3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
               ve hatasiz code yazma acilarindan cok faydalidir.
           4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
              Lambda kullanmak hatasız code kullanmaktır.

                  Collections Nedir?
                  Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
                  yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
                  yaptığı gibi, daha fazlasını da yapar.
                  Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
                  topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
                  (implementations) oluşur.
         */


        List<Integer> sayi=new ArrayList<>(Arrays.asList(34,22,16,11,35,20,63,21,65,44,66,64,81,38,15));

        System.out.println("   *** printElmStuructured() ***   ");
        printElmStuructured(sayi);
        System.out.println("\n\n   *** printElmFunctional() ***   ");
        printElmFunctional(sayi);
        System.out.println("\n\n   *** printElmFunctional1() ***   ");
        printElmFunctional1(sayi);
        System.out.println("\n\n   *** printElmFunctional2() ***   ");
        printElmFunctional2(sayi);
        System.out.println("\n\n   *** printCiftElmSturctured() ***   ");
        printCiftElmSturctured(sayi);
        System.out.println("\n\n   *** printCiftElmFunctional() ***   ");
        printCiftElmFunctional(sayi);
        System.out.println("\n\n   *** printCiftElmFunctional1() ***   ");
        printCiftElmFunctional1(sayi);
        System.out.println("\n\n   *** printCiftOtzdrtKckFunctional() ***   ");
        printCiftOtzdrtKckFunctional(sayi);
        System.out.println("\n\n   *** printCiftVeyaOtzdrtBykFunctional() ***   ");
        printCiftVeyaOtzdrtBykFunctional(sayi);

    }

    //Task : "Structured Programming" kullanarak list elemanlarını aralarında bosluk olacak sekilde print ediniz.
    private static void printElmStuructured(List<Integer> sayi) {
        for (Integer each : sayi){
            System.out.print(each+" ");
        }
    }

    //Task : "Functional Programming" kullanarak list elemanlarını aralarında bosluk olacak sekilde print ediniz.
    private static void printElmFunctional(List<Integer> sayi) {
        sayi.stream().forEach(t-> System.out.print(t+" ")); // t-> System.out.print(t+" ") Lamda Expression cok tavsiye edilmez
    }

    /*
         stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
         forEach() :datanin parametresine gore her bir elemanı isler
         t-> : Lambda operatoru
          Lambda Expression-->(parameter list) -> {action body}
              Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
              -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
              Body: Expressionları ve statementları içerir.

             Bir kod bloğundan oluşan bir body...
             Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
             Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

                 () -> {
                  double pi = 3.1415;
                     return pi;
                 };
          trick kosesinde bugun : Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir

 */
    private static void printElmFunctional1(List<Integer> sayi) {
        sayi.stream().forEach( System.out::print); // method reference --> System.out yapisinda print methodu refere et
                                                    // bu action task'deki ayni satira  ve bosluk ile yazmayi  karsilamaz
                                                    // bunun icin seed(tohum) method create edilip refere edilmeli
    } // bosluksuz yazdirdi
    public static void yazdir (int a) { // verilen  int  degeri ayni satirda bosluk birakarak yazdirma action yapan seed(tohum) method create edildi
        System.out.print(a + " ");
    }

    private static void printElmFunctional2(List<Integer> sayi) {
        sayi.stream().forEach( Lambda01::yazdir); // method reference --> Lamda01 class'inda yazdir() methodu refere et
    }

    // "Structured Programming" ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElmSturctured(List<Integer> sayi){
        for (Integer each:sayi) {
            if(each%2==0)
            {  System.out.print(each+" ");}
        }
    }

    // "Functional Programming" ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftElmFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t%2==0).
                forEach(Lambda01::yazdir);
    }
    public static boolean ciftBul(int a){ // seed(tohum) method kendisine verilen int degerin cift olup olmadigini kontrol eder.
        return a%2==0;
    }
    public static void printCiftElmFunctional1(List<Integer> sayi){
        sayi.
                stream(). // list elemanlari akisa alindi
                filter(Lambda01::ciftBul). // ciftBul method refere edilerek akistaki elemanlar filtrelendi
                forEach(Lambda01::yazdir); // filtre den gelen elemanlar yazdir() method refere edilerek print edildi
    }

    // Task : functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftOtzdrtKckFunctional(List<Integer> sayi){
        sayi.
                stream().
//                filter(t->t%2==0 && t<34).
                filter(Lambda01::ciftBul). // method ref.
                filter(t-> t<34). // lambda exp.
                forEach(Lambda01::yazdir);
    }

    //Task : functional Programming ile list elemanlarinin cift veya 34 den buyk olanalrini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void printCiftVeyaOtzdrtBykFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t%2==0 || t>34). //çift veya 34'den buyuk elelmaları filtreler 44 63 65 38
                /*
                    filter(Lambda01::ciftBul).
                    filter(t -> t >34).
                   // Bu sekilde iki filitre kullanirsak VEYA sarti yerine gelmez VE sarti kullanilmis olur
                */
                forEach(Lambda01::yazdir);

    }



}
