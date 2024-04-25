package faang.school.godbless.sprint_3.help_a_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POLL_SIZE = 10;

    public static void main(String[] args) {
        List<Person> personList = initializePersons();
        int batchSize = personList.size() / THREAD_POLL_SIZE;
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POLL_SIZE);

        for (int i = 1; i < THREAD_POLL_SIZE; i++) {
            int startBatch = batchSize * i;
            int endBatch = startBatch + batchSize - 1;
            List<Person> batch = personList.subList(startBatch, endBatch);
            PersonWorkPlacePrinter personWorkPlacePrinter = new PersonWorkPlacePrinter(batch);
            executorService.execute(personWorkPlacePrinter);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Person> initializePersons() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            personList.add(new Person("Test-" + i, "Test-" + i, 1, "Work place-" + i));
        }
        return personList;
    }
}