package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person("Name" + i, "Surname" + i, 25 + (i % 50), "Workplace" + i));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        int batchSize = persons.size() / THREAD_POOL_SIZE;
        for (int i = 0; i < THREAD_POOL_SIZE; ++i) {
            int start = i * batchSize;
            int end = (i == THREAD_POOL_SIZE - 1) ? persons.size() : (i + 1) * batchSize;
            List<Person> batch = persons.subList(start, end);
            executorService.submit(new PersonInfoPrinter(batch));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Not all tasks have been completed");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println("All tasks have been completed");
    }
}
