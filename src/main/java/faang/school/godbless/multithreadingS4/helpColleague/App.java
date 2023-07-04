package faang.school.godbless.multithreadingS4.helpColleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    private static final int COUNT_PERSONS = 10_000;
    private static final int COUNT_THREADS = 5;
    private static List<Person> persons;

    public static void main(String[] args) {
        fillPersonsList();
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);
        int countItemInBatch = COUNT_PERSONS / COUNT_THREADS;
        for (int i = 0; i < COUNT_THREADS; i++) {
            int startIndex = countItemInBatch * i;
            int endIndex = countItemInBatch * (i + 1);
            executorService.submit(new PersonNamePrinter(persons.subList(startIndex, endIndex)));
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println("\tProcessing of all users is finished!");
        } catch (InterruptedException e){
            e.getStackTrace();
        }
    }

    private static void fillPersonsList() {
        persons = new ArrayList<>(COUNT_PERSONS);
        for (int i = 0; i < COUNT_PERSONS; i++) {
            persons.add(new Person(String.format("Name person %d", i),
                    String.format("Surname person %d", i),
                    i,
                    String.format("Worplace person %d", i))
            );
        }
    }
}
