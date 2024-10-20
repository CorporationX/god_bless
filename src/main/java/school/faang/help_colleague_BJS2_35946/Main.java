package school.faang.help_colleague_BJS2_35946;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int COUNT_PEOPLE = 10000;
        final int COUNT_THREADS = 100;
        final int BATCH_SIZE = COUNT_PEOPLE / COUNT_THREADS;
        final int AWAITING_TIME = 3;

        List<Person> people = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < COUNT_PEOPLE; i++) {
            final int AGE_FROM = 18;
            final int AGE_TO = 60;

            String name = "person" + i;
            String surname = "surname" + i;
            int age = random.nextInt(AGE_FROM, AGE_TO);
            String workPlace = "workPlace" + i;

            people.add(i, new Person(name, surname, age, workPlace));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);

        for (int i = 0; i < COUNT_THREADS; i++) {
            int startIndex = i * BATCH_SIZE;
            int endIndex = startIndex + BATCH_SIZE;
            List<Person> batch = people.subList(startIndex, endIndex);
            executorService.submit(new PersonInfoPrinter(batch));
        }
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
                System.out.println("All tasks completed");
            } else {
                System.out.println("Some tasks failed");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}