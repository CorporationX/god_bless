package Multithreading.bc2096;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 5;
        int numberOfPersons = 10000;
        int listPartSize = numberOfPersons / numberOfThreads;

        List<Person> persons = new ArrayList<>();

        for (int i = 1; i <= numberOfPersons; i++) {
            persons.add(new Person("Name" + i, "Surname" + i, getRandomAge(), "Place work" + i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            int startIndex = i * listPartSize;
            int endIndex = startIndex + listPartSize;
            executorService.submit(new PersonNamePrinter(persons.subList(startIndex, endIndex)));

        }
        executorService.shutdown();

        boolean isFinished = executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);

        if (isFinished) {
            System.out.println("Program finished");
        }
    }

    private static int getRandomAge() {
        return new Random().nextInt(43) + 18;
    }
}
