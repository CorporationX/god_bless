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

        int list = 10000;
        for (int i = 0; i < list; i++) {
            people.add(new Person(i));
        }

        int sizePersonsInPrinter  = people.size() / 4;
        int startIndex = 0;
        int endIndex = sizePersonsInPrinter - 1;
        for (int i = 0; i < 4; i++) {
            List<Person> batch1 = people.subList(1, sizePersonsInPrinter );
            executor.submit(new PersonNamePrinter(batch1));
            startIndex += sizePersonsInPrinter;
            endIndex += sizePersonsInPrinter;
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdownNow();
        System.out.println("program shutdown");
    }
}
