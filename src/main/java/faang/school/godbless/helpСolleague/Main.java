package faang.school.godbless.helpСolleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int personsForOneThread = 1000;
        List<Person> listOfPersons = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            String name = "Name" + i;
            String surname = "Surname" + i;
            String workSpace = "Work space" + i;
            listOfPersons.add(new Person(name, surname, i, workSpace));
        }
        ExecutorService executor = Executors.newFixedThreadPool(10); // 1 thread = 1000 persons
        for (int i = 0; i < 10; i++) {
            int head = i;
            int tail = (i + 1) * 1000;
            List<Person> thousandOfPersons = listOfPersons.subList(head, tail);
            head = i + 1000;
            for (Person person : thousandOfPersons) {
                executor.submit(new PersonNamePrinter(person));
            }
        }
        executor.shutdown();
    }
}
