package helping;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static final int LIST_SIZE = 10001;
    public static final int BATCH_SIZE = 10;
    public static final int POOL_SIZE = 10;

    public static void main(String[] args) throws InterruptedException {
        var persons = initPersonList();
        int batchCount = LIST_SIZE / BATCH_SIZE;
        try (ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE)) {
            for (int i = 0; i < batchCount; i++) {
                executor.submit(new PersonNamePrinter(persons.subList(i * BATCH_SIZE, (i + 1) * BATCH_SIZE)));
            }
            if (LIST_SIZE % BATCH_SIZE != 0) {
                executor.submit(new PersonNamePrinter(persons.subList(batchCount * BATCH_SIZE, persons.size())));
            }
            executor.shutdown();
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Printing finished");
            } else {
                System.out.println("Time out");
            }
        }
    }

    public static List<Person> initPersonList() {
        Random rand = new Random();
        return IntStream.rangeClosed(1, LIST_SIZE)
                .boxed()
                .map(i -> new Person("name" + i, "surname" + i,
                        rand.nextInt(40) + 18, "workplace" + i))
                .toList();
    }
}
