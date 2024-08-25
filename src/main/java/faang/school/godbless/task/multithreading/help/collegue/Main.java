package faang.school.godbless.task.multithreading.help.collegue;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_PEOPLE = 10000;
    private static final int THREAD_POOL_SIZE = 50;
    private static final int PEOPLE_IN_THREAD = NUMBER_OF_PEOPLE / THREAD_POOL_SIZE;
    private static final int TASK_TIMER = 1000;

    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static List<Person> people;
    private static List<PersonNamePrinter> personPrinters;

    public static void main(String[] args) {
        people = getPeople();
        personPrinters = getPersonPrinters();
        runTask();
        executor.shutdown();
        waitForEnd();
    }

    private static List<Person> getPeople() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_PEOPLE)
                .mapToObj(i -> new Person("Name " + i, "Surname " + i, 23, "Workplace " + i))
                .toList();
    }

    private static List<PersonNamePrinter> getPersonPrinters() {
        return IntStream
                .range(0, THREAD_POOL_SIZE)
                .mapToObj(Main::splitByDiapason)
                .map(PersonNamePrinter::new)
                .toList();
    }

    private static List<Person> splitByDiapason(int groupIndex) {
        int startIndex = groupIndex * PEOPLE_IN_THREAD;
        int endIndex = startIndex + PEOPLE_IN_THREAD;
        return IntStream
                .range(startIndex, endIndex)
                .mapToObj(i -> people.get(i))
                .toList();
    }

    private static void runTask() {
        personPrinters.forEach(executor::execute);
    }

    private static void waitForEnd() {
        try {
            if (executor.awaitTermination(TASK_TIMER, TimeUnit.MILLISECONDS)) {
                log.info("All done");
            } else {
                log.info("Time out");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
