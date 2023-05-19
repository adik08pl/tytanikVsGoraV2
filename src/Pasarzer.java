public class Pasarzer {
    //PassengerId	Survived	Pclass	Name	Sex	Age	SibSp	Parch	Ticket	Fare	Cabin	Embarked
    String survived, pClass, name, sex, sibSp, parch, ticket, fare, cabin, embarked;
    int age,id;
    public Pasarzer(String id2,String survived2,String pClass2,String name2,String sex2,String age2,String sibSp2,String parch2,String ticket2,String fare2,String cabin2,String embarked2) {
        id = Integer.parseInt(id2);
        survived=survived2;
        pClass=pClass2;
        name=name2;
        sex=sex2;
        age=Integer.getInteger(age2);
        sibSp=sibSp2;
        parch=parch2;
        ticket=ticket2;
        fare=fare2;
        cabin=cabin2;
        embarked=embarked2;
    }
}
