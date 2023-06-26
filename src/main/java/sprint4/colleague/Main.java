package sprint4.colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) {
        fillList();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int startIndex = i * 1000;
            int endIndex = startIndex + 1000;
            List<Person> divided = PEOPLE.subList(startIndex, endIndex);
            service.execute(new PersonNamePrinter(divided));
        }
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
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
