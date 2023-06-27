package faang.school.godbless.HelpYourMate;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> personList = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            personList.add(new Person(String.valueOf(i), String.valueOf(i), i, String.valueOf(i)));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            PersonNamePrinter personNamePrinter = new PersonNamePrinter(personList.subList(i * 1000, (i + 1) * 1000));
            executorService.submit(personNamePrinter);
        }
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
        executorService.shutdown();
        System.out.println("Program finished");
    }
}
