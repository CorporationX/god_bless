package faang.school.godbless.multithreading.colleague;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Person> people = IntStream.rangeClosed(1, 10000)
                .mapToObj(i -> new Person(
                        "Person-" + i,
                        "Surname-" + i,
                        random.nextInt(18, 70),
                        "Workplace-" + i))
                .toList();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            int from = i * 2000;
            int to = (i + 1) * 2000;

            executorService.submit(new PersonNamePrinter(people.subList(from, to)));
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("The names of all people have been printed");
            }
        } catch (Exception ignored) {}
    }
}
