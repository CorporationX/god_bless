package ru.kraiush.BJS2_35961;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {
        int peopleQuantity = 10_000;
        int peopleQuantityPerList = peopleQuantity / THREAD_POOL_SIZE;

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < peopleQuantity; ++i) {
            people.add(new Person("Name" + i, "Surname" + i, new Random().nextInt(18, 65), "Company" + i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < THREAD_POOL_SIZE; ++i) {
            int start = i * peopleQuantityPerList;
            int end = (i + 1) * peopleQuantityPerList;
            List<Person> batchOfPeople = new ArrayList<>();
            for (int j = start; j < end; ++j) {
                batchOfPeople.add(people.get(j));
            }
            executorService.submit(new PersonInfoPrinter(batchOfPeople));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println("All threads finished their work.");
        } catch (InterruptedException e) {
            System.out.println("The threads can't finish their work.");
        }
    }
}
