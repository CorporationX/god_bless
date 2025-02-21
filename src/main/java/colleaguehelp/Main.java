package colleaguehelp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int numberOfPersons = 10000;
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        logger.info("Available processor cores: " + numberOfThreads);

        List<Person> persons = new ArrayList<>();
        for (int i = 1; i <= numberOfPersons; i++) {
            persons.add(new Person("Name " + i, "Surname " + i,
                    random.nextInt(60) + 18, "Job " + i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        int subPersonsSize = (int) Math.ceil((double) numberOfPersons / numberOfThreads);

        for (int i = 0; i < persons.size(); i += subPersonsSize) {
            List<Person> subPersons = persons.subList(i, Math.min(subPersonsSize + i, persons.size()));
            executorService.submit(new PersonInfoPrinter(subPersons));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            logger.severe("Interrupted!!!");
        }
        logger.info("All threads have completed their work!");
    }
}