package faang.school.godbless.helpcollegue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = getPersons();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            final int finalI = i;
            executorService.submit(new PersonNamePrinter(persons.subList(finalI * 2000 + 1, finalI * 2000 + 1 + 2000)));
        }
        executorService.shutdown();
        awaitTermination(executorService);
    }

    private static List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10001; i++) {
            persons.add(new Person("Person " + i, "Person " + i, i, "Person " + i + " workplace"));
        }
        return persons;
    }

    private static void awaitTermination(ExecutorService executorService) {
        try {
            executorService.awaitTermination(5L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
