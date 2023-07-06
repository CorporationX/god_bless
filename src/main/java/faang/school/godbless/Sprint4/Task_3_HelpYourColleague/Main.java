package faang.school.godbless.Sprint4.Task_3_HelpYourColleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            people.add(new Person("Name " + i, "Surname " + i, i, "Workplace " + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(8);

        for (int i = 0; i < 8; i++) {
            int startIndex = i * 1250;
            int endIndex = (i + 1) * 1250;
            List<Person> batch = people.subList(startIndex, endIndex);

            PersonNamePrinter batchNamePrinter = new PersonNamePrinter(batch);
            executor.submit(batchNamePrinter);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Выполнение программы успешно завершено!");
    }
}
