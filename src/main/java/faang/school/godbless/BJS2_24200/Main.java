package faang.school.godbless.BJS2_24200;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUMBER_THREADS = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_THREADS);
        List<Person> people = getPeople();

        int step = people.size() / NUMBER_THREADS;
        for (int i = 0; i < people.size(); i += step) {
            List<Person> subList = people.subList(i, Math.min(i + step, people.size()));
            executor.execute(new PersonNamePrinter(subList));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("Конец");
    }

    private static List<Person> getPeople() {
        return IntStream.rangeClosed(1, 500000)
                .mapToObj(i -> {
                    String stringI = String.valueOf(i);
                    return new Person(stringI, stringI, i, stringI);
                })
                .toList();
    }
}
