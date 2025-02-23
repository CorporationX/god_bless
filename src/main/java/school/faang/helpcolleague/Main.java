package school.faang.helpcolleague;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREADS_COUNT = 4;

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person("name" + i, "surname" + i, i, "workplace" + i));
        }

        int portion = persons.size() / THREADS_COUNT;
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            int startIndex = i * portion;
            int endIndex = (i == THREADS_COUNT - 1) ? persons.size() : startIndex + portion;

            List<Person> subPersons = persons.subList(startIndex, endIndex);
            executor.execute(new PersonInfoPrinter(subPersons));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        log.info("Все потоки завершены");
    }
}
