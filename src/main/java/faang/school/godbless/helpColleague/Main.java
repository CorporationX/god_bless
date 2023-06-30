package faang.school.godbless.helpColleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Person> people = fillPersonList();
        final int THREAD_QUANTITY = 8;
        final int PEOPLE_PER_THREAD = people.size() / THREAD_QUANTITY;
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_QUANTITY);

        for (int i = 0; i < THREAD_QUANTITY; i++) {
            List<Person> batch = people.subList(i * PEOPLE_PER_THREAD, (i + 1) * PEOPLE_PER_THREAD - 1);
            executor.submit(new PersonNamePrinter(batch));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Программа выполнена!");
    }

    public static List<Person> fillPersonList() {
        List<Person> people = new ArrayList<>(10000);

        for (int i = 0; i < 10000; i++) {
            people.add(
                    new Person("Name " + i, "Surname " + i, i, "Workplace " + i)
            );
        }

        return people;
    }
}
