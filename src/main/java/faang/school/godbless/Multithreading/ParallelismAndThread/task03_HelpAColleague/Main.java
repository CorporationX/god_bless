package faang.school.godbless.Multithreading.ParallelismAndThread.task03_HelpAColleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final List<Person> personList = new ArrayList<>();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            personList.add(new Person(i));
        }
        for (int i = 0; i < 10; i++) {
            int startIndex = i * 1000;
            List<Person> subList = personList.subList(startIndex, startIndex + 1000);
            executorService.submit(new PersonNamePrinter(subList));
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Successfully");
            } else {
                System.out.println("Error");
            }
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
