package school.faang.bjs248033;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int PEOPLE_AMOUNT = 10000;
    private static final int THREADS_AMOUNT = 10;
    private static final int PEOPLE_PER_THREAD = PEOPLE_AMOUNT / THREADS_AMOUNT;

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        for (int i = 1; i <= PEOPLE_AMOUNT; i++) {
            String name = String.format("Name%d", i + 1);
            String surname = String.format("Surname%d", i + 1);
            int age = 30 + (i % 50);
            String workplace = String.format("Workplace%d", (i % 10) + 1);
            people.add(new Person(name, surname, age, workplace));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

        for (int i = 1; i <= THREADS_AMOUNT; i++) {
            System.out.println("start");
            int startIndex = i * PEOPLE_PER_THREAD - 1000;
            int endIndex = startIndex + PEOPLE_PER_THREAD;
            log.info("Thread {}: startIndex = {}, endIndex = {}", i, startIndex, endIndex);

            List<Person> batchOfPeople = people.subList(startIndex, startIndex);
            executorService.submit(new PersonInfoPrinter(batchOfPeople, startIndex, startIndex));
            System.out.println("end");
        }

 /*       for (PersonInfoPrinter personInfoPrinter : batchOfPeople) {
            executorService.submit(() -> {
                log.info("Name: {}, Surname: {}, Age: {}, Workplace: {}",
                        person.getName(), person.getSurname(), person.getAge(), person.getWorkplace());
            });
        }*/

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("The delivery tasks were not completed in 5 seconds, we forcefully stop the ThreadPool");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The main thread was interrupted while waiting, we forcefully stop the ThreadPool {} ",
                    Thread.currentThread().getName());
            executorService.shutdownNow();
        }
    }
}