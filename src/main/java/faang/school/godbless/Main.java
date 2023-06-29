package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            people.add(new Person("Person" + i, "Surname" + i, i, "Workplace" + i));
        }

        int numThreads = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        int batchSize = people.size() / numThreads;
        for (int i = 0; i < numThreads; i++) {
            List<Person> partListPerson = people.subList(i * batchSize, (i + 1) * batchSize);
            for (Person person : partListPerson) {
                PersonNamePrinter printer = new PersonNamePrinter(person);
                executorService.submit(printer);
            }
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        System.out.println("Программа завершена.");
    }
}
