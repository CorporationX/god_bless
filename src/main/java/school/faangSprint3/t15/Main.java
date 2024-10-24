package school.faangSprint3.t15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person(
                    "Name" + i,
                    "Surname" + i,
                    25 + (i % 50),
                    "Workplace" + i
            ));
        }

        int numThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Starting processing with " + numThreads + " threads");

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        int batchSize = persons.size() / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int start = i * batchSize;
            int end = (i == numThreads - 1) ? persons.size() : (i + 1) * batchSize;
            List<Person> batch = persons.subList(start, end);

            executor.submit(new PersonInfoPrinter(batch, i));
        }

        try {
            executor.shutdown();
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("All tasks completed successfully");
            } else {
                System.out.println("Timeout occurred before completion");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}