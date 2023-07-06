package faang.school.godbless.task.helpAColleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int FIXED_THREAD_COUNT = 5;
    private static final int PERSONS_COUNT = 10_000;

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(PERSONS_COUNT);

        for (int i = 1; i <= PERSONS_COUNT; i++) {
            String iStr = String.valueOf(i);
            persons.add(new Person(iStr, iStr, i, iStr));
        }

        List<List<Person>> splitPersons = new ArrayList<>(FIXED_THREAD_COUNT);

        for (int i = 0; i < PERSONS_COUNT; i += FIXED_THREAD_COUNT) {
            splitPersons.add(persons.subList(i, i + FIXED_THREAD_COUNT));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(FIXED_THREAD_COUNT);
        for (var splitPersonsChunk : splitPersons) {
            executorService.submit(new PersonNamePrinter(splitPersonsChunk));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            System.out.println(e.getMessage());
        }
    }
}
