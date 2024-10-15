package help_a_colleague;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int PERSON_COUNT = 10000;
    private static final int COUNT_THREADS = 10;
    private static final int AWAIT_SECONDS = 60;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);

    /**
     * Runs the program.
     *
     * <p>It creates a list of 100 persons, splits it into 10 chunks and submits each chunk to a fixed thread pool
     * of 10 threads. Each thread prints out the contents of the chunk it was given.
     *
     * @param args ignored
     */
    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < PERSON_COUNT; i++) {
            persons.add(new Person("Name" + i, "Surname" + i, i + 1, "Workplace" + i));
        }

        int chunkSize = persons.size() / COUNT_THREADS;

        for (int i = 0; i < COUNT_THREADS; i++) {
            int fromIndex = i * chunkSize;
            int toIndex = (i == COUNT_THREADS - 1) ? persons.size() : fromIndex + chunkSize;

            List<Person> subList = persons.subList(fromIndex, toIndex);
            PersonInfoPrinter printer = new PersonInfoPrinter(subList);
            executorService.submit(printer);
        }

        executorService.shutdown();

        if (executorService.awaitTermination(AWAIT_SECONDS, TimeUnit.SECONDS)) {
            System.out.println("Done");
        } else {
            executorService.shutdownNow();
            System.out.println("Timeout");
        }
    }
}
