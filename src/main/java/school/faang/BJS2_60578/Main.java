package school.faang.BJS2_60578;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_SIZE = 10;
    private static final int PEOPLE_SIZE = 10000;
    private static final int MIN_AGE = 20;
    private static final int AGE_RANGE = 50;
    private static final int TIMEOUT = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS_SIZE);
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < PEOPLE_SIZE; i++) {
            String name = "Имя_" + i;
            String surname = "Фамилия_" + i;
            int age = MIN_AGE + i % AGE_RANGE;
            String workplace = "Место_работы_" + i;
            Person person = new Person(name, surname, age, workplace);
            people.add(person);
        }

        int batchSize = people.size() / THREADS_SIZE;
        for (int i = 0; i < THREADS_SIZE; i++) {
            int start = i * batchSize;
            int end = (i == THREADS_SIZE - 1) ? people.size() : (i + 1) * batchSize;
            List<Person> batch = people.subList(start, end);
            executor.submit(new PersonInfoPrinter(batch));
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                System.out.print("Timed out waiting for threads to finish");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            System.err.print("Main thread interrupted\n");
        }
    }
}
