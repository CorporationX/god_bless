package helping_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            persons.add(new Person(String.valueOf(i), String.valueOf(i), i, String.valueOf(i)));
        }
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 8; i++) {
            executor.submit(new PersonNamePrinter(persons.subList(i * 10000 / 8, (i + 1) * 10000 / 8)));
        }
        executor.shutdown();
        executor.awaitTermination(100, TimeUnit.MILLISECONDS);

        System.out.println("Done");
    }

}

