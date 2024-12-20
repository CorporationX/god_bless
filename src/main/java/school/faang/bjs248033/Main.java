package school.faang.bjs248033;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int PEOPLE_AMOUNT = 100_000;
    private static final int THREADS_AMOUNT = 10;
    private static final int PEOPLE_PER_THREAD = PEOPLE_AMOUNT / THREADS_AMOUNT;

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        IntStream.rangeClosed(0, PEOPLE_AMOUNT)
                .mapToObj(i -> Person.builder()
                        .name(String.format("Name%d", i))
                        .surname(String.format("Surname%d", i))
                        .age(30 + (i % 50))
                        .workspace(String.format("Workplace%d", (i % 10) + 1))
                        .build())
                .forEach(people::add);

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

        List<List<Person>> partitions = ListUtil.partition(people, PEOPLE_PER_THREAD);
        IntStream.range(0, THREADS_AMOUNT)
                .forEach(i -> {
                    System.out.println("start");
                    int startIndex = i * PEOPLE_PER_THREAD;
                    int endIndex = Math.min(startIndex + PEOPLE_PER_THREAD, people.size());
                    log.info("Thread {}: startIndex = {}, endIndex = {}", i, startIndex, endIndex);
                    PersonInfoPrinter printer = new PersonInfoPrinter(partitions.get(i));
                    executorService.submit(printer);
                });

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("The delivery tasks were not completed in 5 seconds, we forcefully stop the ThreadPool");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The main thread was interrupted while waiting, we forcefully stop the ThreadPool {} ",
                    Thread.currentThread().getName());
            executorService.shutdownNow();
        }
    }
}