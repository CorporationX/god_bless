package faang.school.godbless.helpColleague;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_PEOPLE = 10000;
    private static final int PEOPLE_PER_THREAD = 100;

    public static void main(String[] args) {
        List<Person> people = new LinkedList<>();

        for (int i = 0; i < NUM_PEOPLE; i++) {
            people.add(new Person("person" + i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.submit(new PersonNamePrinter(people.subList(i * PEOPLE_PER_THREAD, (i + 1) * PEOPLE_PER_THREAD)));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
