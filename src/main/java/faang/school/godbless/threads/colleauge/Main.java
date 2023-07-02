package faang.school.godbless.threads.colleauge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int countPerson = 10000;
        List<Person> personList = new ArrayList<>(countPerson);
        for (int i = 0; i < countPerson; i++) {
            personList.add(i, new Person(Integer.toString(i), Integer.toString(i), i, Integer.toString(i)));
        }

        int numberThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(numberThreads);

        for (int i = 0; i < numberThreads; i++) {
            int numberForEachThread = countPerson / numberThreads;
            int startIndex = i * numberForEachThread;
            int endIndex = (i + 1) * numberForEachThread;
            executorService.submit(new PersonNamePrinter(startIndex, endIndex, personList));
        }
        executorService.shutdown();

        try {
            boolean result = executorService.awaitTermination(3, TimeUnit.SECONDS);
            if (result) {
                System.out.println("Job is done");
            } else {
                System.out.println("Timeout");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
