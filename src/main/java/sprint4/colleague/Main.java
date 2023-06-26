package sprint4.colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final List<Person> PEOPLE = new ArrayList<>();

    static {
        fillList();
    }
    private static final int COUNT_THREADS = 10;
    private static final int THREAD_ON_HUMAN = PEOPLE.size() / COUNT_THREADS;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(COUNT_THREADS);
        for (int i = 0; i < COUNT_THREADS; i++) {
            int startIndex = i * THREAD_ON_HUMAN;
            int endIndex = startIndex + THREAD_ON_HUMAN - 1;

            List<Person> peopleGroup = PEOPLE.subList(startIndex, endIndex);
            service.execute(new PersonNamePrinter(peopleGroup));
        }

        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
            service.shutdownNow();
        } catch (InterruptedException e) {
            throw new RuntimeException("Да взлетит оно все к чертям");
        }
    }

    private static void fillList() {
        for (int i = 0; i < 10000; i++) {
            PEOPLE.add(new Person("Number: " + i, "Bot", 1000 + i, "Workplace№" + i));
        }
    }
}
