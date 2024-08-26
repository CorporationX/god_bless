package faang.school.godbless.help_on_work;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        List<Person> workerList = new ArrayList<>();
        PersonNamePrinter mainPersons = new PersonNamePrinter(workerList);

        for (int i = 0; i <= 10000; i++) {
            mainPersons.addPerson(new Person(new Random().nextInt(1, 100),
                    new Random().nextInt(1, 100),
                    new Random().nextInt(1, 5),
                    new Random().nextInt(18, 65)));
        }

        ExecutorService poolThreads = Executors.newFixedThreadPool(5);


        int batchSize = 2000;
        int startIndex = 0;
        int totalWorkers = workerList.size();

        while (startIndex < totalWorkers) {
            int endIndex = startIndex + batchSize;

            List<Person> batch = new ArrayList<>(workerList.subList(startIndex, endIndex));
            PersonNamePrinter temp = new PersonNamePrinter(batch);

            poolThreads.submit(temp);

            startIndex = endIndex;
        }

        poolThreads.shutdown();

        try {
            if (poolThreads.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Все задачи завершены.");
            } else {
                System.out.println("Некоторые задачи не завершены.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Пул потоков был прерван.");
        }
    }
}
