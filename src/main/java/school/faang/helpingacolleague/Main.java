package school.faang.helpingacolleague;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNTS = 5;

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNTS);
        int totalPeople = 10_000;
        int batchSize = totalPeople / THREAD_COUNTS;

        for (int i = 0; i < totalPeople; i++) {
            people.add(new Person("Name" + i, "Surname" + i,
                    i % 100 + 1, "Workplace " + i));
        }

        for (int i = 0; i < THREAD_COUNTS; i++) {
            int start = i * batchSize;
            int end = (i + 1) * batchSize;
            List<Person> sublist = people.subList(start, end);
            executor.execute(new PersonInfoPrinter(sublist));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Ошибка потоков");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
