package Help_a_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numberOfPersons = 10000;
        int numberOfThreads = new Random().nextInt(2, 5);
        int personsPerThread = numberOfPersons / numberOfThreads;
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < numberOfPersons; i++) {
            persons.add(new Person(i));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            int startIndex = i * personsPerThread + 1;
            int endIndex = startIndex + personsPerThread - 1;
            PersonNamePrinter personNamePrinter = new PersonNamePrinter(persons.subList(startIndex,endIndex));
            executorService.submit(personNamePrinter);
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdownNow();
        System.out.println("program shutdown");
    }
}
