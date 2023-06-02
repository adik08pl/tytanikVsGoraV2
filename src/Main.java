import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Pasarzer> pasarzerowie=new ArrayList<>();
        //PassengerId   Survived    Pclass  Name    Sex	    Age	    SibSp	Parch	Ticket	Fare	Cabin	Embarked
        List<String> linie = Files.readAllLines(Path.of("C:/Users/sirk0/Documents/odp.txt"));
        for(int i = 0;i<linie.size();i++) {

                List<String[]> linia = linie.stream().map(x->x.split("\t")).collect(Collectors.toList());
                Pasarzer pasarzer = new Pasarzer(linia.get(i)[0],linia.get(i)[1],linia.get(i)[2],linia.get(i)[3],linia.get(i)[4],linia.get(i)[5],linia.get(i)[6],linia.get(i)[7],linia.get(i)[8],linia.get(i)[9],linia.get(i)[10],linia.get(i)[10]);
                pasarzerowie.add(pasarzer);
        }
        int sredniWiek = 0;
        int iloscPasarzerowZWiekiem = 0;
        System.out.println("Ilość pasażerów: "+pasarzerowie.size());
        for(int i = 0;i<pasarzerowie.size();i++) {
            try {
                sredniWiek += Integer.parseInt(pasarzerowie.get(i).age);
                iloscPasarzerowZWiekiem++;
            }catch (NumberFormatException n){

            }
        }
        System.out.println("Średni wiek: "+sredniWiek / iloscPasarzerowZWiekiem);
        int kobiety=0,mezczyzni=0;
        for(int j = 0;j<pasarzerowie.size();j++){
            if(pasarzerowie.get(j).sex.equals("male")){
                mezczyzni++;
            }
            else if(pasarzerowie.get(j).sex.equals("female")){
                kobiety++;
            }
        }
        System.out.println("Ilość mężczyzn: "+mezczyzni);
        System.out.println("Ilość kobiet: "+kobiety);
        int przezyli=0;
        for(int k = 0;k<pasarzerowie.size();k++){
            if(pasarzerowie.get(k).survived.equals("1"))
                przezyli++;
        }
        System.out.println("Ile procent przeżyło: "+100*przezyli / pasarzerowie.size());
        int pierwszaKlasa=0,drugaKlasa=0,trzeciaKlasa=0;
        for(int l = 0;l<pasarzerowie.size();l++){
            if(pasarzerowie.get(l).pClass.equals("1"))
                pierwszaKlasa++;
            else if(pasarzerowie.get(l).pClass.equals("2"))
                drugaKlasa++;
            else if(pasarzerowie.get(l).pClass.equals("3"))
                trzeciaKlasa++;
        }
        System.out.println("Ilość pasażerów w 1 klasie: "+pierwszaKlasa);
        System.out.println("Ilość pasażerów w 2 klasie: "+drugaKlasa);
        System.out.println("Ilość pasażerów w 3 klasie: "+trzeciaKlasa);
        int mezczyzniKtorzyPrzezyli=0, kobietyKtorePrzezyly=0;
        for(int m = 0;m<pasarzerowie.size();m++){
            if(pasarzerowie.get(m).sex.equals("male")&&pasarzerowie.get(m).survived.equals("1")){
                mezczyzniKtorzyPrzezyli++;
            }
            else if(pasarzerowie.get(m).sex.equals("female")&&pasarzerowie.get(m).survived.equals("1")){
                kobietyKtorePrzezyly++;
            }
        }
        System.out.println("Kobiety które przeżyły: "+kobietyKtorePrzezyly);
        System.out.println("Mężczyźni którzy przeżyli: "+mezczyzniKtorzyPrzezyli);
        int nieWypelnionaPlec=0,nieWypelnionaKlasa=0;
        for(int n = 0;n<pasarzerowie.size();n++){
            if(!(pasarzerowie.get(n).sex.equals("male")||pasarzerowie.get(n).sex.equals("female"))){
                nieWypelnionaPlec++;
            }
            if(!(pasarzerowie.get(n).pClass.equals("1")||pasarzerowie.get(n).pClass.equals("2")||pasarzerowie.get(n).pClass.equals("3"))){
                nieWypelnionaKlasa++;
            }
        }
        System.out.println("Ilość pasażerów bez wypełnionej płci: "+nieWypelnionaPlec);
        System.out.println("Ilość pasażerów bez wypełnionej klasy: "+nieWypelnionaKlasa);
    }
}