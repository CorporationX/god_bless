package help_collegue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final List<Person> people = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            people.add(new Person("Person" + i, "Surname" + i, i, "Workplace" + i));
        }

        final int threads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        final int batchSize = people.size() / threads;
        final int remaining = people.size() % threads;
        int startIndex = 0;

        for (int i = 0; i < threads; i++) {
            int endIndex = startIndex + batchSize + (remaining > 0 ? 1 : 0);
            List<Person> batch = people.subList(startIndex, endIndex);
            executorService.submit(new PersonNamePrinter(batch));
            startIndex = endIndex;
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("ExecutorService has been shut down.");
    }
}
