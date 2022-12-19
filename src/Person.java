import java.util.Random;

public class Person {
    private String name;
    private String surname;
    private Integer age;
    private final Random random = new Random();
    private static final int maxAge = 99;

    final String[] nameArray = {"Dmitry", "Olga", "Vitaly", "Makar",
            "Stephanie", "Evgeniy", "Lydia", "Samuel",
            "Bogdan", "Irina", "Vsevolod", "Savely",
            "Gregory", "Arkady", "Elizabeth", "Matvey",
            "Valentina", "Egor", "Fedor", "Tamara",
            "Konstantin", "Abram", "Raisa", "Antonina"};
    final String[] surnameArray = {"Volsky", "Postnikov", "Petrushina", "Karpovich",
            "Parin", "Doroshenko", "Biryukov", "Kettler",
            "Johanson", "Orlovsky", "Gugnina", "Barsov",
            "Mackenzie", "Shipbuilders", "Kudryashov", "Dyachenko",
            "Lunin", "Romashchuk", "Aigi", "Levin"};

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person() {
        this("name", "surname", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{ " +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", age = " + age +
                " }";
    }

    public Person generation(int maxWordsInSurname) {
        String string = "";
        int numWords = (int) (Math.random() * ((maxWordsInSurname)));

        name = nameArray[new Random().nextInt(nameArray.length - 1)];
        if (numWords <= 0) {
            surname = surnameArray[new Random().nextInt(surnameArray.length - 1)];
        } else {
            for (int i = 0; i < numWords; i++) {
                if (i != numWords - 1) {
                    string += surnameArray[new Random().nextInt(surnameArray.length - 1)] + "-";
                } else {
                    string += surnameArray[new Random().nextInt(surnameArray.length - 1)];
                }
                surname = string;
            }
        }
        age = random.nextInt(maxAge) + 1;
        return new Person(name, surname, age);
    }
}
