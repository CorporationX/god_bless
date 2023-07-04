package faang.school.godbless.help_colleague;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final int COUNTS_OF_THREAD = 10;

    public static void main(String[] args) {
        List<Person> people = createPeople();

        ExecutorService executorService = Executors.newFixedThreadPool(COUNTS_OF_THREAD);
        int onePartOfList = people.size() / COUNTS_OF_THREAD;
        int startIndex = 0;
        int endIndex = onePartOfList;

        for (int i = 0; i < COUNTS_OF_THREAD; i++) {
            List<Person> batch = people.subList(startIndex, endIndex);
            PersonNamePrinter personNamePrinter = new PersonNamePrinter(batch);
            executorService.submit(personNamePrinter);

            startIndex = endIndex;
            endIndex = Math.min(endIndex + onePartOfList, people.size());
        }
        executorService.shutdown();
        try {
            boolean terminated = executorService.awaitTermination(1, TimeUnit.SECONDS);
            if (terminated) {
                System.out.println("All tasks have completed successfully.");
            } else {
                System.out.println("Timeout occurred before all tasks completed.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Workplace info have been sent");
    }

    private static List<Person> createPeople() {
        return IntStream.range(0, 10000)
                .mapToObj(i -> {
                    String name = "Person " + i;
                    String surname = "Surname " + i;
                    int age = i % 100;
                    String workplace = "Workplace " + i;
                    return new Person(name, surname, age, workplace);
                })
                .collect(Collectors.toList());
    }
}
