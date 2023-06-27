package faang.school.godbless.help_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NamePrinter {

    public static void main(String[] args) {
        int quantity = 10000;
        int totalThreads = 3;
        int batchSize = quantity / totalThreads;

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            people.add(new Person("Name" + i, "SureName" + i, i, "Work Place"));
        }

        ExecutorService executor = Executors.newFixedThreadPool(totalThreads);

        for (int i = 0; i < totalThreads; i++) {
            int startIndex = i * batchSize;
            int endIndex = (i == totalThreads - 1) ? quantity : (i + 1) * batchSize;
            List<Person> subList = people.subList(startIndex, endIndex);

            PersonNamePrinter namePrinter = new PersonNamePrinter(subList);
            executor.submit(namePrinter);
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                System.out.println("Program complete");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
