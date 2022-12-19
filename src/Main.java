import java.util.LinkedList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        final int numPerson = 15;
        final int limitWordsInSurname = 5;

        List<Person> peoplesList = generateClients(numPerson);
//        peoplesList.sort(new PeopleComparator());

        peoplesList.sort((o1, o2) -> {
            int o1NumOfWords, o2NumOfWords;
            String[] sn1 = o1.getSurname().split("-", limitWordsInSurname);
            String[] sn2 = o2.getSurname().split("-", limitWordsInSurname);
            o1NumOfWords = sn1.length;
            o2NumOfWords = sn2.length;
            if (o1NumOfWords == o2NumOfWords) {
                return o2.getAge() - o1.getAge();
            } else {
                return o2NumOfWords - o1NumOfWords;
            }
        });

        System.out.print("\nList:\n");
        for (Person person : peoplesList) {
            System.out.printf("Name: %-25s, Surname: %-50s, Age: %3d\n", person.getName(), person.getSurname(), person.getAge());
        }
    }

    public static LinkedList<Person> generateClients(int numPerson) {
        int maxWordsInSurname = 6; // 0 - There is no limit
        LinkedList<Person> generateClients = new LinkedList<>();
        Person newPerson = new Person();
        System.out.println("______________DATA______________");
        for (int i = 0; i < numPerson; i++) {
            generateClients.offer(newPerson.generation(maxWordsInSurname));
            System.out.println(newPerson);
        }
        System.out.println("________________________________");
        return generateClients;
    }
}
