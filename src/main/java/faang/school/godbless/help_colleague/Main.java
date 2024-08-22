package faang.school.godbless.help_colleague;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final int THREADS = 10;
    private static final int LIST_SIZE = 10000;
    private static final int BATCH_SIZE = LIST_SIZE / THREADS;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        List<Person> batch = new ArrayList<>();
        List<Person> people = IntStream.range(0, LIST_SIZE)
                .mapToObj(n -> new Person("Name " + n,
                        "Surname " + n,
                        n % 10 + 18,
                        "Address " + n))
                .toList();

        for(int i = 0; i < people.size(); i++) {
            batch.add(people.get(i));
            if ((i + 1) % BATCH_SIZE == 0) {
                executor.submit(new PersonNamePrinter(batch));
                batch = new ArrayList<>();
            }
        }
        executor.shutdown();
        try {
            while(!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Tasks being processed...");
            }
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("===========================");
        System.out.println("Finished processing records");
    }
}
