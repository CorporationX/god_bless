package school.faang.helpacolleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        IntStream.range(0, 10000).forEach(i ->
                people.add(new Person("Name" + i, "Surname" + i, 20 + (i % 30), "Company" + (i % 10)))
        );

        int numThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        int chunkSize = people.size() / numThreads;
        List<List<Person>> partitions = new ArrayList<>();

        for (int i = 0; i < people.size(); i += chunkSize) {
            partitions.add(people.subList(i, Math.min(i + chunkSize, people.size())));
        }

        partitions.forEach(partition -> executorService.submit(new PersonInfoPrinter(partition)));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Some tasks did not finish in 1 minute, forcing shutdown...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("The main thread was interrupted while waiting for tasks to complete.");
            executorService.shutdownNow();
        }

        System.out.println("Processing of all person data is completed.");
    }
}

