package school.faang.bjs2_72669;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREADS_COUNT = 5;
    private static final int PERSONS_COUNT = 10000;
    private static final int BATCH_SIZE = PERSONS_COUNT / THREADS_COUNT;
    private static final int AWAIT_TIMEOUT_SECOND = 30;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Person> persons = generatePersons();

        for (int i = 0; i < THREADS_COUNT; i++) {
            executorService.submit(new PersonInfoPrinter(persons.subList(i * BATCH_SIZE, (i + 1) * BATCH_SIZE)));
        }
        dispose(executorService);
    }

    private static List<Person> generatePersons() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person("name_%d".formatted(i + 1), "surname_%d".formatted(i + 1), i + 1,
                    "workplace_%d".formatted(i + 1)));
        }
        return persons;
    }

    private static void dispose(ExecutorService executorService) {
        log.info("Disposing executor service");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TIMEOUT_SECOND, TimeUnit.SECONDS)) {
                log.warn("Task didn't finished by timeout. Finishing tasks...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            executorService.shutdownNow();
        }
    }
}