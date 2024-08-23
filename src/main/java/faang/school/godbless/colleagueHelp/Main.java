package faang.school.godbless.colleagueHelp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int LIMIT_PERSONS = 10000;
    private static final int LIMIT_THREADS = 20;

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < LIMIT_PERSONS; i++) {
            persons.add(new Person("Name_" + i, "Surname_" + i, "WorkPlace_" + i, i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(LIMIT_THREADS);
        for (int i = 0; i < LIMIT_THREADS; i++) {
            int finalI = i;
            executorService.submit(() ->
                    new PersonNamePrinter(persons.subList(finalI * LIMIT_PERSONS / LIMIT_THREADS,
                            finalI * LIMIT_PERSONS / LIMIT_THREADS + LIMIT_PERSONS / LIMIT_THREADS)).run());
        }
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1000L, TimeUnit.SECONDS)) {
                System.out.println("FIN");
            } else {
                System.out.println("Somebody won't get an award");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
