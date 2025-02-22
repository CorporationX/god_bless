package school.faang.task_60889;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person(
                    "Name" + i,
                    "Surname" + i,
                    25 + (i % 50),
                    "Workplace" + i));
        }
        int numThreads = Runtime.getRuntime().availableProcessors();
        log.info("AvailableProcessors: {}", numThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        int subListSize = persons.size() / numThreads;
        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * subListSize;
            int endIndex = (i == numThreads - 1) ? persons.size() : (i + 1) * subListSize;
            List<Person> batch = new ArrayList<>(persons.subList(startIndex, endIndex));
            executorService.submit(new PersonInfoPrinter(batch, counter, i, subListSize));
        }

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("All tasks are performed.");
            } else {
                System.out.println("All persons printed to console.");
            }
        } catch (InterruptedException e) {
            log.info("Print was interrupted by {}.", Thread.currentThread().getName());
        }
    }
}

