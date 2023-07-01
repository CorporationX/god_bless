package faang.school.godbless.PersonToWorkplace;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class Main {
    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = newFixedThreadPool(THREADS_COUNT);
        List<Person> persons = Stream.iterate(0, i -> i + 1)
                .limit(10000)
                .map(num -> new Person(num.toString(), num.toString(), num, num.toString()))
                .toList();
        List<PersonNamePrinter> namePrinters = new ArrayList<>();
        var personsPerThread = persons.size() / THREADS_COUNT;
        for (int i = 0; i < THREADS_COUNT; i++) {
            namePrinters.add(new PersonNamePrinter(persons.subList(i * personsPerThread, i * personsPerThread + personsPerThread)));
        }
        for (var printer : namePrinters) {
            executor.submit(printer);
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Good job");
    }
}
