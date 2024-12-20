package school.faang.sprint_3.task_48043;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int AMOUNT_OF_PERSONS = 10000;
    private static final int AMOUNT_OF_THREADS = 8;
    private static final int AWAIT_TERMINATION_DELAY = 5;

    public static void main(String[] args) {
        List<Person> persons = generatePersons(AMOUNT_OF_PERSONS);

        ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);

        int currentPositionInPersonList = 0;
        int amountOfPersonPerThread = AMOUNT_OF_PERSONS / AMOUNT_OF_THREADS;
        int endPositionInPersonList = 0;
        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            endPositionInPersonList += amountOfPersonPerThread;
            List<Person> personsToOneThread = persons.subList(currentPositionInPersonList, endPositionInPersonList);
            currentPositionInPersonList = endPositionInPersonList;

            executorService.execute(new PersonInfoPrinter(personsToOneThread));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_DELAY, TimeUnit.SECONDS)) {
                System.out.println("Threads did not terminate, shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    private static List<Person> generatePersons(int amountOfPersons) {
        List<Person> persons = new ArrayList<>();
        for (int i = 1; i <= amountOfPersons; i++) {
            persons.add(new Person("Name " + i,
                    "Surname " + i,
                    20 + (i % 10),
                    "Workplace " + i));
        }
        return persons;
    }
}
