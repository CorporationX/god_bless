package school.faang.bjs2_89657;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static final int COUNT_POOL_THREAD = 10;
    public static final int SIZE_PERSON_LIST = 100_000;
    private static final int TIME_WAITING_THREAD = 5;
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 70;

    public static void main(String[] args) {
        List<Person> persons = IntStream.rangeClosed(0, SIZE_PERSON_LIST)
                .mapToObj(i -> new Person("name " + i,
                        "surname " + i,
                        new Random().nextInt(MIN_AGE, MAX_AGE),
                        "workplace"))
                .collect(Collectors.toCollection(ArrayList::new));

        int batchSize = SIZE_PERSON_LIST / COUNT_POOL_THREAD;

        List<Person> batch = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(COUNT_POOL_THREAD);

        for (int i = 0; i < persons.size(); i++) {
            batch.add(persons.get(i));
            if ((i + 1) % batchSize == 0) {
                PersonInfoPrinter infoPrinter = new PersonInfoPrinter(batch);
                executor.submit(infoPrinter);
                batch = new ArrayList<>();
            }
        }

        if (!batch.isEmpty()) {
            PersonInfoPrinter infoPrinter = new PersonInfoPrinter(batch);
            executor.submit(infoPrinter);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIME_WAITING_THREAD, TimeUnit.MINUTES)) {
                executor.shutdownNow();
                log.info("The waiting time for all thread has ended");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Waiting was interrupted - Forced termination", e);
        }
        log.info("All thread are complete");
    }
}
