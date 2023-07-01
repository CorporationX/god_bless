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
        int count = numberOfPersons / numberOfThreads;
        List<Person> persons = new ArrayList<>();
        for (int i = 1; i <= numberOfPersons; i++) {
            persons.add(new Person("Name" + i, "Surname" + i, getRandomAge(), "Place work" + i));
        }
        List<Person> a = persons.subList(0, 2000);

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfPersons; i++) {
            if (i < count) {
                executorService.submit(new PersonNamePrinter(a));
            } else if (i >= count && i < count * 2) {
                executorService.submit(new PersonNamePrinter(persons.get(i)));
            } else if (i >= count * 2 && i < count * 3) {
                executorService.submit(new PersonNamePrinter(persons.get(i)));
            } else if (i >= count * 3 && i < count * 4) {
                executorService.submit(new PersonNamePrinter(persons.get(i)));
            } else if (i >= count * 4 && i < numberOfPersons) {
                executorService.submit(new PersonNamePrinter(persons.get(i)));
            }
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
