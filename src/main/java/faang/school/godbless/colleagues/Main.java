package faang.school.godbless.colleagues;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Person> people = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            people.add(new Person(i));
        }

        List<Person> batch = people.subList(1, 10);

        for (int i = 0; i < 10; i++) {
            executor.submit(new PersonNamePrinter(batch));

        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdownNow();
        System.out.println("program shutdown");
    }
}
