package faang.school.godbless.helpColleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person("Name " + i, "Surname " + i, i, "Workplace " + i));
        }

        int numThreads = 4;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        int batchSize = persons.size() / numThreads;
        int startIndex = 0;
        int endIndex = batchSize;

        for (int i = 0; i < numThreads; i++) {
            List<Person> batch = persons.subList(startIndex, endIndex);
            PersonNamePrinter personNamePrinter = new PersonNamePrinter(batch);
            executorService.submit(personNamePrinter);

            startIndex = endIndex;
            endIndex = Math.min(endIndex + batchSize, persons.size());
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        System.out.println("The programme is completed");
    }
}

