package faang.school.godbless.multithreading.helpcolleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_PERSONS = 10000;
    private static final int DEL = 100;

    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < NUM_PERSONS; i++) {
            int value = i % DEL;
            persons.add(
                    new Person(
                            "Имя" + i,
                            "Фамилия" + i,
                            value,
                            "Организация" + value
                    )
            );
        }

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        List<PersonNamePrinter> printers = Stream.iterate(0, n -> n + 1).limit(NUM_THREADS)
                .map(i -> {
                    List<Person> personsToPrinter = Stream
                            .iterate(
                                    i * NUM_PERSONS / NUM_THREADS,
                                    n -> n + 1
                            )
                            .limit(NUM_PERSONS / NUM_THREADS)
                            .map(persons::get)
                            .toList();
                    return new PersonNamePrinter(personsToPrinter);
                })
                .toList();

        for (PersonNamePrinter printer : printers) {
            executor.execute(printer);
        }

        executor.shutdown();
        boolean isTerminated = executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Все потоки завершены: " + isTerminated);
    }
}
