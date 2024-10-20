package dima.evseenko.help;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int THREADS_COUNT = 10;
    private final static int PERSONS_COUNT = 10000;

    public static void main(String[] args) {
        int batchSize = PERSONS_COUNT / THREADS_COUNT;

        List<Person> persons = new ArrayList<>(getPersons());
        List<List<Person>> sublist = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            sublist.add(persons.subList(i * batchSize, (i + 1) * batchSize));
            executorService.submit(new PersonInfoPrinter(sublist.get(i)));
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(100, TimeUnit.SECONDS)) {
                System.out.println("Done");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < PERSONS_COUNT; i++) {
            persons.add(new Person("name " + i, "surname " + i, new Random().nextInt(35 - 18) + 18, "workplace " + i));
        }
        return persons;
    }
}
