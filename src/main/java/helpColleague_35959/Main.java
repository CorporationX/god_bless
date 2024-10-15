package helpColleague_35959;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int COUNT_PERSONS = 10000;
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < COUNT_PERSONS; i++) {
            persons.add(new Person("Name" + i,
                    "Surname" + i,
                    new Random().nextInt(18, 80),
                    "Workplace" + i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        int batchSize = persons.size() / THREAD_POOL_SIZE;
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            int start = batchSize * i;
            int end = batchSize * (i + 1);
            List<Person> batch = persons.subList(start, end - 1);
            executorService.execute(new PersonInfoPrinter(batch));
        }
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Программа завершает свою работу.");
            } else {
                System.out.println("Программа не завершилась");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
