package school.faang.task48100;

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
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person("Name" + i, "Surname" + i, i % 2 == 0 ? 25 : 35,
                    "Workplace" + i));
        }

        int numThreads = 5;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        int batchSize = persons.size() / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int start = i * batchSize;
            int end = (i == numThreads - 1) ? persons.size() : (i + 1) * batchSize;

            List<Person> batch = persons.subList(start, end);
            batch.forEach(a -> executor.submit(new PersonInfoPrinter(a)));

        }
        executor.shutdown();

        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.info("Work is done .");
            } else {
                log.info("Work is not done!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
