package faang.school.godbless.sprint3.help;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(10000);
        for(int i = 0; i < 10000; i++){
            String name = "Person" + i;
            String surname = "Surname" + i;
            String workplace = "Workplace" + i;
            personList.add(new Person(name, surname, i, workplace));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int startIndex = i;
            int endIndex = (i + 1) * 1000;
            List<Person> batch = personList.subList(startIndex, endIndex);
            startIndex = i + 1000;

            for (Person person : batch) {
                executorService.submit(new PersonNamePrinter(person));
            }
        }
        executorService.shutdown();
    }
}
