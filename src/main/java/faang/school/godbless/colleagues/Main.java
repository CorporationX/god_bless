package faang.school.godbless.colleagues;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> people = new ArrayList<>();
        setUpPeople(people);

        ExecutorService executor = Executors.newFixedThreadPool(4);
        int sizePersonsInPrinter = people.size() / 4;
        int startIndex = 0;
        int endIndex = sizePersonsInPrinter - 1;
        for (int i = 0; i < 4; i++) {
            List<Person> batch1 = people.subList(startIndex, endIndex);
            executor.submit(new PersonNamePrinter(batch1));
            startIndex += sizePersonsInPrinter;
            endIndex += sizePersonsInPrinter;
        }

        if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("program shutdown");
            executor.shutdown();
        }
    }

    private static void setUpPeople(List<Person> people) {
        int list = 10000;
        for (int i = 0; i < list; i++) {
            people.add(new Person(i));
        }
    }
}
