package school.faang.godbless.bjs2_35973;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int WORKERS_NUMBER = 10000;
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 150;
    private static final int THREADS_NUMBER = 17;

    public static void main(String[] args) {
        List<Person> workers = generateWorkers(WORKERS_NUMBER, MIN_AGE, MAX_AGE);
        ExecutorService pool = Executors.newFixedThreadPool(THREADS_NUMBER);
        int batchSize = WORKERS_NUMBER / THREADS_NUMBER;
        submitToPool(workers, pool, batchSize);
        pool.shutdown();
        try {
            if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
                log.info("All info printed");
            } else {
                log.error("The pool is not terminated");
            }
        } catch (InterruptedException e) {
            log.error("Main thread interrupted");
            Thread.currentThread().interrupt();
        }
    }

    private static List<Person> generateWorkers(int workersNum, int minAge, int maxAge) {
        return IntStream.rangeClosed(1, workersNum).mapToObj(number ->
                        new Person("Name" + number, "Surname" + number,
                                ThreadLocalRandom.current().nextInt(minAge, maxAge + 1),
                                "Workplace" + number))
                .toList();
    }

    private static void submitToPool(List<Person> workers, ExecutorService pool, int batchSize) {
        int startIndex = 0;
        while (startIndex < workers.size()) {
            List<Person> batch = new ArrayList<>();
            int endIndex = startIndex >= workers.size() - batchSize ? workers.size() : startIndex + batchSize;
            for (int i = startIndex; i < endIndex; ++i) {
                batch.add(workers.get(i));
            }
            PersonInfoPrinter printer = new PersonInfoPrinter(batch);
            pool.submit(printer);
            startIndex = endIndex;
        }
    }
}
