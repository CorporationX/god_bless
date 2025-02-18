package bjs2_60571;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int personCount = 10_000;
        Person[] persons = new Person[personCount];
        Random rnd = new Random();

        for (int i = 0; i < personCount; i++) {
            persons[i] = new Person(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    rnd.nextInt(10, 80),
                    UUID.randomUUID().toString());
        }

        final int threadsCount = 10;
        final int chunkSize = personCount / threadsCount;

        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);

        for (int i = 0; i < threadsCount; i++) {
            List<Person> chunkData = List.of(Arrays.copyOfRange(persons, chunkSize * i, chunkSize * (i + 1)));

            PersonInfoPrinter printer = new PersonInfoPrinter(chunkData);

            executorService.submit(printer);
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(3, TimeUnit.SECONDS)) {
                System.out.println("Операция завершилась, менее чем за 3 секунды");

                return;
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        Thread.sleep(3000);
        System.out.println("Операция не успела завершиться за 3 секунды");
    }
}
