package school.faang.spring3.task_48071;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            persons.add(new Person("Name" + i, "Surname" + i, random.nextInt(20, 70), "Workplace" + i));
        }

        int batchSize = persons.size() / THREAD_COUNT;
        int startIndex = 0;
        int endIndex = batchSize;
        List<Person> batch;
        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            startIndex = i * batchSize;
            if (i == THREAD_COUNT - 1) {
                endIndex = persons.size();
            } else {
                endIndex = (i + 1) * batchSize;
            }
            batch = persons.subList(startIndex, endIndex);
            service.execute(new PersonInfoPrinter(batch));
        }

        service.shutdown();

        if (service.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("completed");
        } else {
            System.out.println("not completed");
        }
    }
}
