package faang.school.godbless.help_colleague;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final long TIMEOUT = 10000;
    private static final int THREADS = 100;
    private static final int LIST_SIZE = 10000;
    private static final int BATCH_SIZE = LIST_SIZE / THREADS;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        List<Person> batch = new ArrayList<>();
        List<Person> people = IntStream.range(0, LIST_SIZE)
                .mapToObj(n -> new Person("Name " + n, "Surname " + n, n % 10 + 18, "Address " + n))
                .toList();
        people.forEach(p -> {
            batch.add(p);
            if (batch.size() % BATCH_SIZE == 0) {
                executor.submit(new PersonNamePrinter(batch));
                batch.clear();
            }
        });

        executor.shutdown();
        long startTime = System.currentTimeMillis();
        try {
            while(!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                if (System.currentTimeMillis() - startTime > TIMEOUT) {
                    System.out.printf("Timeout reached: %d%n", TIMEOUT);
                    executor.shutdownNow();
                } else {
                    log.info("Tasks are currently executed...");
                }
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===========================");
        System.out.println("Finished processing records");
    }
}
