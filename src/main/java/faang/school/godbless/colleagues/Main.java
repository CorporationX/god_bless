package faang.school.godbless.colleagues;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Person> people = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10000; i++) {
            people.add(new Person(i));
        }

        List<Person> batch1 = people.subList(1, 2500);
        List<Person> batch2 = people.subList(2500, 5000);
        List<Person> batch3 = people.subList(5000, 7500);
        List<Person> batch4 = people.subList(7500, 10000);

        for (int i = 0; i < 4; i++) {
            executor.submit(new PersonNamePrinter(batch1));
            executor.submit(new PersonNamePrinter(batch2));
            executor.submit(new PersonNamePrinter(batch3));
            executor.submit(new PersonNamePrinter(batch4));
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdownNow();
        System.out.println("program shutdown");
    }
}
