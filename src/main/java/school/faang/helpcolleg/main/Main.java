package school.faang.helpcolleg.main;

import school.faang.helpcolleg.maincode.Person;
import school.faang.helpcolleg.maincode.PersonInfoPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 5;
    private static final int PERSON_COUNT = 10000;

    private static int batchSize = PERSON_COUNT / THREAD_COUNT;

    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < PERSON_COUNT; i++) {
            String name = "name_" + i;
            String surname = "surname_" + i;
            int age = 18 * (i % 50);
            String workplace = "workplace_" + i;

            persons.add(new Person(name, surname, age, workplace));
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i + 1) * batchSize;

            List<Person> batch = persons.subList(startIndex, endIndex);

            executor.submit(new PersonInfoPrinter(batch));
        }

        executor.shutdown();

        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Все задачи заверешены");
        } else {
            System.out.println("Завершение не удалось");
        }
    }
}
