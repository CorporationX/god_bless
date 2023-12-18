package faang.school.godbless.multi_paral.task9colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int NUM_PEOPLE = 10000;
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < NUM_PEOPLE; i++) {
            people.add(new Person("Name" + i, "Surname" + i, 30, "Workplace" + i));
        }

        int numThreads = Math.max(1, people.size() / 1000);
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        int subPeople = NUM_PEOPLE / numThreads;
        for (int i = 0; i < NUM_PEOPLE; i += subPeople) {
            List<Person> chunk = people.subList(i, Math.min(i + subPeople, NUM_PEOPLE));
            executor.submit(new PersonNamePrinter(chunk, false, false, false, true));
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.NANOSECONDS);

        System.out.println("Информация получена");
    }
}
