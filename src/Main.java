import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //PassengerId	Survived	Pclass	Name	Sex	Age	SibSp	Parch	Ticket	Fare	Cabin	Embarked
        List<String> linie = Files.readAllLines(Path.of("C:/Users/sirk0/Desktop/tytanik.txt"));
        for (String linia: linie)

    }
}