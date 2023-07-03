package Help;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            String name = "Person " + i;
            String surname = "Surname " + i;
            String workPlace = "WorkPlace " + i;
            persons.add(new Person(name, surname, i, workPlace));
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            int startIndex = i;
            int endIndex = (i + 1) * 10;
            List<Person> batch = persons.subList(startIndex, endIndex);

            for (Person person : batch){
                executor.submit(new PersonNamePrinter(person));
            }

        }
        executor.shutdown();
    }
}
