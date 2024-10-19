package school.faang.Mnogopotochka.ParallelismThread.BJS2_35951;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final int NUMBER_THREAD_POOL = 10;
    private static List<Person> persons = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        addPerson();
        amountPersonsOneStream();
    }

    public static void amountPersonsOneStream(){
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_THREAD_POOL);
        int chunkSize = persons.size() / NUMBER_THREAD_POOL;
        for (int i = 0; i < NUMBER_THREAD_POOL; i++){
            int startIndex = i * chunkSize;
            int endIndex = (i == NUMBER_THREAD_POOL - 1) ? persons.size() : startIndex + chunkSize;
            List<Person> chunk = persons.subList(startIndex, endIndex);
            executorService.submit(new PersonInfoPrinter(chunk));
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                logger.info("All tasks completed.");
            } else {
                logger.warn("Timeout reached before completion.");
            }
        } catch (InterruptedException e) {
            logger.error("Execution interrupted", e);
        }
    }

    public static void addPerson() {
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person(
                    i,
                    getRandomElement(PersonInfo.name),
                    getRandomElement(PersonInfo.surnames),
                    random.nextInt(18, 60),
                    getRandomElement(PersonInfo.workplaces)
            ));
        }
        logger.info("Added {} persons to the list", persons.size());
    }

    private static String getRandomElement(String[] array) {
        if (array == null || array.length == 0) {
            logger.error("Array cannot be null or empty");
            return "";
        }
        return array[random.nextInt(array.length)];
    }
}
