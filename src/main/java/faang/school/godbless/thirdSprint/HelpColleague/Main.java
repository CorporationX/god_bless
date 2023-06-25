package faang.school.godbless.thirdSprint.HelpColleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int threadsAmount = 10;
        List<Person> persons = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(threadsAmount);

        for (int i = 0; i < 10000; i++) {
            persons.add(new Person("Bib" + i, "Bob", i, "Uber"));
        }

        int startIndex = 0;
        int endIndex = persons.size() / threadsAmount;
        for (int i = 0; i < threadsAmount; i++) {
            List<Person> batch = persons.subList(startIndex, endIndex);
            service.submit(new PersonNamePrinter(batch));

            startIndex = endIndex;
            endIndex += persons.size() / threadsAmount;
        }
        service.shutdown();

        try {
            boolean terminated = service.awaitTermination(10, TimeUnit.SECONDS);
            if (terminated) {
                System.out.println("Программа завершила свою  работу");
            } else {
                System.out.println("Программа не успела завершить свою работу в течении 10 секунд");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
