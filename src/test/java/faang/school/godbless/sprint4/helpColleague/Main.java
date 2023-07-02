package faang.school.godbless.sprint4.helpColleague;

import faang.school.godbless.sprint4.helpColleague.classes.PersonNamePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static List<Integer> persons = new ArrayList<>();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        fillArray();
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 2_000;
            List<Integer> subList = persons.subList(startIndex, startIndex + 2_000);
            service.submit(new PersonNamePrinter(subList));
        }
        service.shutdown();
        try {
            if (service.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Done");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fillArray() {
        for (int i = 0; i < 10_000; i++) {
            persons.add(i);
        }
    }
}
