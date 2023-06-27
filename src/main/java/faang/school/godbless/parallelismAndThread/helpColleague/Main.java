package faang.school.godbless.parallelismAndThread.helpColleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBER_OF_PEOPLE = 10000;
    private static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        int numberOfLists = NUMBER_OF_PEOPLE / NUMBER_OF_THREADS;
        List<Person> people = new ArrayList<>(NUMBER_OF_PEOPLE);
        for (int i = 1; i <= NUMBER_OF_PEOPLE; i++) {
            people.add(new Person(String.valueOf(i), "User", 20, "workplace"));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int startIndex = i * numberOfLists + 1;
            int endIndex = i * numberOfLists + numberOfLists;
            List<Person> batch = people.subList(startIndex, endIndex);
            executorService.submit(new PersonNamePrinter(batch));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdownNow();
        System.out.println("Работа завершена!");
    }
}
