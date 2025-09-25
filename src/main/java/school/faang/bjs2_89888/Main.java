package school.faang.bjs2_89888;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int THREAD_COUNT = 4;
    public static final int PERSON_COUNT = 10000;
    public static final int PERSON_SUBGROUP_COUNT = PERSON_COUNT / THREAD_COUNT;
    public static final int MIN_AGE = 20;

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < PERSON_COUNT; i++) {
            people.add(new Person(
                    "Name" + i,
                    "Surname" + i,
                    MIN_AGE + (i % 50),
                    "Company" + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIndex = i * PERSON_SUBGROUP_COUNT;
            int endIndex = (i == THREAD_COUNT - 1) ? people.size() : (i + 1) * PERSON_SUBGROUP_COUNT;

            List<Person> subList = people.subList(startIndex, endIndex);
            executor.submit(new PersonInfoPrinter(subList));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            throw new RuntimeException(e);
        }

        System.out.println("Работа завершена.");
    }
}
