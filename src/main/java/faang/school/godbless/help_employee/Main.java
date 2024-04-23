package faang.school.godbless.help_employee;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            people.add(new Person("Person " + i, "Surname " + i, 20 + i % 10, "Workplace " + i));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        int batchSize = people.size() / NUM_THREADS;
        for (int i = 0; i < NUM_THREADS; i++) {
            List<Person> sublist = people.subList(i * batchSize, (i == NUM_THREADS - 1) ? people.size() : (i + 1) * batchSize);
            executorService.submit(new PersonNamePrinter(sublist));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("Все работы выведены в консоль");
    }
}
