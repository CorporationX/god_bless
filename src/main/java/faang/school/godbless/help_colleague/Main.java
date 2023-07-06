package faang.school.godbless.help_colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    private static final int BATCH_SIZE = 200;

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        List<String> names = List.of("John", "Ann", "Tim", "Steve", "Jill", "Mary");
        List<String> surnames = List.of("Smith", "Johnson", "Biden", "May", "Parker");
        List<String> workplaces = List.of("Apple", "Microsoft", "McDonald's", "Vodafone", "Google");

        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Person> employees = IntStream.range(0, 10_000)
                .mapToObj(i -> Person.builder()
                        .name(names.get(random.nextInt(names.size())))
                        .surname(names.get(random.nextInt(surnames.size())))
                        .age(random.nextInt(100))
                        .workplace(workplaces.get(random.nextInt(workplaces.size())))
                        .build())
                .toList();
        int employeesSize = employees.size();

        List<Person> batch = new ArrayList<>(BATCH_SIZE);
        PersonNamePrinter printer = new PersonNamePrinter(batch);

        for (int i = 0; i < employeesSize; i++) {
            batch.add(employees.get(i));

            if (batch.size() == BATCH_SIZE) {
                executor.submit(printer);
                batch = new ArrayList<>(BATCH_SIZE);
            }
        }
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("\nTask completed");
    }
}
