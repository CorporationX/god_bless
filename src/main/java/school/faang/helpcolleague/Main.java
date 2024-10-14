package school.faang.helpcolleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 8;
    private static final int COUNT_PEOPLES = 10_000;
    private static final int MAX_TIME_WAIT = 100;
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < COUNT_PEOPLES; i++) {
            persons.add(new Person("Name" + i, "Surname" + i, 25 + (i % 50), "Workplace" + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        int batchSize = persons.size() / THREAD_POOL_SIZE;
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            int start = i * batchSize;
            int end = (i == THREAD_POOL_SIZE - 1) ? persons.size() : (i + 1) * batchSize;
            List<Person> batch = persons.subList(start, end);

            executor.submit(new PersonInfoPrinter(batch));
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(MAX_TIME_WAIT, TimeUnit.SECONDS)) {
                System.out.println("Данные о всех людях выведены");
            } else {
                System.out.println("Завершение не удалось.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}