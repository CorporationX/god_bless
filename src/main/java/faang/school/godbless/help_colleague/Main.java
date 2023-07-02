package faang.school.godbless.help_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int threadsNumber = 5;
        int personCount = 10_000;
        int batchSize = personCount/threadsNumber;

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < personCount; i++) {
            personList.add(new Person(Integer.toString(i),Integer.toString(i),i,Integer.toString(i)));
        }

        ExecutorService executor = Executors.newFixedThreadPool(threadsNumber);
        for (int i = 0; i < threadsNumber; i++) {
            List<Person> batch = personList.subList(i * batchSize, (i + 1) * batchSize);
            executor.submit(() -> new PersonNamePrinter(batch).run());
        }
        executor.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("Все данные выведены!");
        executor.shutdown();
    }
}
