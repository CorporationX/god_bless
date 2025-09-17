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

import static school.faang.bjs2_89657.Constant.COUNT_POOL_THREAD;
import static school.faang.bjs2_89657.Constant.SIZE_PERSON_LIST;
import static school.faang.bjs2_89657.Constant.TIME_WAITING_THREAD;

@Slf4j
public class Main {

    public static void main(String[] args) {
        List<Person> persons = PersonBatchService.createListPerson();

        ExecutorService executor = Executors.newFixedThreadPool(COUNT_POOL_THREAD);

        PersonBatchService.processPersons(persons, SIZE_PERSON_LIST / COUNT_POOL_THREAD, executor);

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
