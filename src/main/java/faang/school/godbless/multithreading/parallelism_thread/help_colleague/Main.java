package faang.school.godbless.multithreading.parallelism_thread.help_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int EMPLOYEE_COUNT = 10000;
    private static final int PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static final int TIMEOUT = 15; // в секундах


    public static void main(String[] args) {
        List<Person> employees = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            employees.add(new Person(Integer.toString(i), Integer.toString(i), i, Integer.toString(i)));
        }

        ExecutorService executor = Executors.newFixedThreadPool(PROCESSORS);
        int increment = EMPLOYEE_COUNT / PROCESSORS;

        for (int i = 0; i < employees.size(); i += increment) {
            int startIndex = i;
            int endIndex = i + increment;
            List<Person> batch = employees.subList(startIndex, endIndex);
            PersonNamePrinter personNamePrinter = new PersonNamePrinter(batch);
            executor.submit(personNamePrinter);
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                System.out.println("Все задачи в пуле потоков завершены");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
