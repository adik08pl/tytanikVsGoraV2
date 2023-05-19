import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
                Pasarzer pasarzer = new Pasarzer(linia.get(i)[0],linia.get(i)[1],linia.get(i)[2],linia.get(i)[3],linia.get(i)[4],linia.get(i)[5],linia.get(i)[6],linia.get(i)[7],linia.get(i)[8],linia.get(i)[9],linia.get(i)[10],linia.get(i)[11]);
                pasarzerowie.add(pasarzer);
        }
        AtomicInteger sredniWiek= new AtomicInteger(1);
        pasarzerowie.stream().forEach(x-> sredniWiek.updateAndGet(v -> v * pasarzerowie.get(x.id).age));
        System.out.println("Ilość pasażerów: "+pasarzerowie.size());
        System.out.println("Średni wiek pasażerów: "+(sredniWiek.get() /pasarzerowie.size()));
    }
}