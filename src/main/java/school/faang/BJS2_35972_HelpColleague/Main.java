package school.faang.BJS2_35972_HelpColleague;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final String PERSONS_CSV_FILE_PATH = "src/main/files/HelpColleague/persons.csv";
    private static final CsvLoader CSV_LOADER = new CsvLoader();
    private static final int THREAD_POOL_SIZE = 5;
    private static final int START_INDEX = 0;
    private static final int AWAIT_TERMINATION_SECONDS = 15;

    public static void main(String[] args) {
        List<Person> persons = CSV_LOADER.loadFromCsv(PERSONS_CSV_FILE_PATH, Person.class);
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        int personsAmount = persons.size();
        int batchSize = personsAmount / THREAD_POOL_SIZE;

        for (int index = START_INDEX; index < personsAmount; index += batchSize) {
            service.submit(new PersonInfoPrinter(persons, index, index + batchSize));
        }

        service.shutdown();
        try {
            if (service.awaitTermination(AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                System.out.println("Information about all the persons was released on time!");
            } else {
                System.out.println("Not all information about all the persons was released on time. Shutting down executor service!");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            throw new IllegalStateException(
                    "The thread was interrupted while waiting for threads to finish. Shutting down executor service!",
                    e
            );
        }
    }
}
