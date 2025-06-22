package school.faang.bjs2_81290;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int PERSONS_COUNT = 10_000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < PERSONS_COUNT; i++) {
            StringBuilder sbName = new StringBuilder("Имя" +  i);
            StringBuilder sbSurname = new StringBuilder("Фамилия" +  i);
            StringBuilder sbWorkplace = new StringBuilder("Работа" +  i);
            persons.add(new Person(sbName.toString(), sbSurname.toString(), 18 + (i % 50), sbWorkplace.toString()));
        }
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        int batchSize = PERSONS_COUNT / THREAD_COUNT;

        for (int i = 1; i <= THREAD_COUNT; i++) {
            int startIndex = (i - 1) * batchSize;
            int endIndex = i * batchSize - 1;
            List<Person> batch = persons.subList(startIndex, endIndex);
            executor.submit(new PersonInfoPrinter(batch));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        log.info("Все задачи завершены.");
    }
}
