package school.faang.sprint_3.task_43548;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int PEOPLE_LIST_SIZE = 10_000;
    private static final int POOL_SIZE = 10;
    private static final int BATCH_SIZE = PEOPLE_LIST_SIZE / POOL_SIZE;
    private static final int TIMEOUT = 1;
    private static final int BASE_AGE = 18;
    private static final int DIVIDER = 50;

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        createPeople(people);

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        executePersonBatch(people, executor);

        executor.shutdown();

        try {
            if (executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Все задачи завершены.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static void createPeople(List<Person> people) {
        for (int i = 0; i < PEOPLE_LIST_SIZE; i++) {
            people.add(new Person("Name " + i, "Surname " + i,
                    BASE_AGE + (i % DIVIDER), "Workplace " + i));
        }
    }

    private static void executePersonBatch(List<Person> people, ExecutorService executor) {
        int start;
        int end;
        List<Person> batch;
        for (int i = 0; i < POOL_SIZE; i++) {
            start = BATCH_SIZE * i;
            end = BATCH_SIZE * (i + 1);
            batch = people.subList(start, end);
            executor.execute(new PersonInfoPrinter(batch));
        }
    }
}
