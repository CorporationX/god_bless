package school.faang.colleguehelp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int PEOPLE_COUNT = 10000;
    public static final int THREAD_COUNT = 10;

    public static void main(String[] args) {
        List<Person> people = populatePeopleList();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        int batchSize = PEOPLE_COUNT / THREAD_COUNT;

        for (int i = 0; i < THREAD_COUNT; i++) {
            List<Person> batchPeople = people.subList(i * batchSize, Math.min((i + 1) * batchSize, people.size()));
            executor.submit(new PersonInfoPrinter(batchPeople));
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Execution has not completed in 30 seconds, terminating all threads");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static List<Person> populatePeopleList() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < PEOPLE_COUNT; i++) {
            people.add(new Person("Name_" + i, "Surname_" + i, new Random().nextInt(60) + 20, "SuperCompany_" + i));
        }
        return people;
    }
}
