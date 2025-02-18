package school.faang.task_60576;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            persons.add(new Person("Name" + i, "Surname" + i, 25 + (i % 50), "Workplace" + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        int batchSize = persons.size() / THREADS_COUNT;
        for (int i = 0; i < THREADS_COUNT; i++) {
            int start = i * batchSize;
            int end = (i == THREADS_COUNT - 1) ? persons.size() : (i + 1) * batchSize;
            List<Person> batch = persons.subList(start, end);

            executor.submit(new PersonInfoPrinter(batch));
        }

        executor.shutdown();
        try {
            // Ждем завершения всех потоков
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("Все задачи завершены.");
    }
}
