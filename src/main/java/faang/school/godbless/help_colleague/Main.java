package faang.school.godbless.help_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> personsList = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            personsList.add(new Person("Name: " + i, "Surname:  " + i, 20 + i, "Office #" + i));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            List<Person> batch = personsList.subList((i - 1) * 1000, i * 1000);
            PersonNamePrinter personNamePrinter = new PersonNamePrinter(batch);
            executorService.submit(personNamePrinter);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("End");
    }
}
