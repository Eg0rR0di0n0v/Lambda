import java.util.LinkedList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        final int numPerson = 15;

        List<Person> peoplesList = generateClients(numPerson);
        peoplesList.sort(new PeopleComparator());

        System.out.print("\nList:\n");
        for (Person person : peoplesList) {
            System.out.printf("Name: %-25s, Surname: %-50s, Age: %3d\n", person.getName(), person.getSurname(), person.getAge());
        }
    }

    public static LinkedList<Person> generateClients(int numPerson) {
        int maxWordsInSurname = 5; // 0 - There is no limit
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
