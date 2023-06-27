package faang.school.godbless.sprint4.multithreading_parallelism_thread.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();
        int personsCount = 10_000;
        for (int i = 0; i < personsCount; i++) {
            persons.add(new Person("Name " + i, "Surname " + i, i, "Workplace " + i));
        }

        int nThreads = 5;
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        for (int i = 0; i < nThreads; i++) {
            executor.submit(new PersonNamePrinter(persons.subList(i * personsCount / nThreads, (i + 1) * personsCount / nThreads)));
        }

        executor.shutdown();

        executor.awaitTermination(100, TimeUnit.MILLISECONDS);

        System.out.println("Done");
    }
}
