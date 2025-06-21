package school.faang.bjs2_81290;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        int personsCount = 10_000;
        int threadsCount = 5;

        for (int i = 0; i < personsCount; i++) {
            persons.add(new Person("Имя" + i, "Фамилия" + i, 18 + (i % 50), "Работа" + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(threadsCount);
        int batchSize = personsCount / threadsCount;

        for (int i = 1; i <= threadsCount; i++) {
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
