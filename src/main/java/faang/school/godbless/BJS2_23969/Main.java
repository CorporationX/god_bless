package faang.school.godbless.BJS2_23969;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final List<Person> persons = new ArrayList<>();
    private static final int TOTAL_PERSONS = 1000;
    private static final int THREAD_COUNT = 5;
    private static final int PERSONS_TO_PROCESS = TOTAL_PERSONS / THREAD_COUNT;

    public static void main(String[] args) {

        for (int i = 0; i < TOTAL_PERSONS; i++) {
            persons.add(new Person("name" + i, "surname" + i, i, "some place" + i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        int startIndex = 0;
        int endIndex = PERSONS_TO_PROCESS;

        for (int i = 0; i < THREAD_COUNT; i++) {
            List<Person> batch = persons.subList(startIndex, endIndex);
            executorService.submit(new PersonNamePrinter(batch));
            startIndex = 1 + endIndex;
            endIndex += PERSONS_TO_PROCESS;
        }
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All names were printed");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
