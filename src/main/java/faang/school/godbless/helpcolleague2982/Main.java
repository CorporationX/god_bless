package faang.school.godbless.helpcolleague2982;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        List<Person> peopleList = createPeopleList();
        ExecutorService printerExecutor = Executors.newFixedThreadPool(NUM_THREADS);
        int batchSize = peopleList.size() / NUM_THREADS;

        for (int i = 0; i < NUM_THREADS; i++) {
            int startIndex = i * (batchSize);
            int endIndex = (batchSize * (i + 1));
            printerExecutor.submit(new PersonNamePrinter(peopleList.subList(startIndex, endIndex)));
        }

        printerExecutor.shutdown();
        printerExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("PersonNamePrinter done his job :)");
    }

    private static List<Person> createPeopleList() {
        List<Person> result = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 10_000; i++) {
            result.add(new Person("Name #" + i,
                    "Surname #" + i,
                    random.nextInt(18, 60),
                    "Company #" + i));
        }
        return result;
    }
}
