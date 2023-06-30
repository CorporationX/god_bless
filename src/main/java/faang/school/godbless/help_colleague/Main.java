package faang.school.godbless.help_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = IntStream
                .rangeClosed(1, 10000)
                .mapToObj(i -> new Person(String.valueOf(i), String.valueOf(i)))
                .toList();
        final int THREAD_COUNT = 12;
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<List<Person>> partitions = new ArrayList<>(1000);

        for (int i = 0; i < persons.size(); i += THREAD_COUNT) {
            int end = Math.min(i + THREAD_COUNT, persons.size());
            List<Person> partition = persons.subList(i, end);
            partitions.add(partition);
        }

        for (List<Person> personList : partitions) {
            executorService.submit(new PersonNamePrinter(personList));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS))
                executorService.shutdownNow();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done");
    }
}
