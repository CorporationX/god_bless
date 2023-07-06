package faang.school.godbless.sprint4_multithreading.collegue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            personList.add(new Person("name" + i, "surname" + i, i, "workplace" + i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int startIndex = i * 1000;
            int endIndex = startIndex + 1000;
            executorService.submit(new PersonNamePrinter(personList.subList(startIndex, endIndex)));
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
