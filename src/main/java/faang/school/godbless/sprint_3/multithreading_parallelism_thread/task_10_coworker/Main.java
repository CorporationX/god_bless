package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_10_coworker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int COUNT_PERSON = 10_000_000;
    private static final int COUNT_THREAD = 5;
    private static final int STEP = COUNT_PERSON / COUNT_THREAD;
    private static final String MSG_END = "Работа закончена.";

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);
        List<Person> personList =  createPersonList();

        executePersonNamePrinters(executor, personList);

        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(MSG_END);

        // 1 thread = 3m 35s
        // 2 threads = 3m 27s
        // 5 threads = 3m 21s
    }

    private static void executePersonNamePrinters(ExecutorService executor, List<Person> personList) {
        int startIndex = 0;

        for (int i = 0; i < COUNT_THREAD; i++, startIndex += STEP) {
            if (i + 1 >= COUNT_THREAD) {
                executor.execute(new PesonNamePrinter(personList.subList(startIndex, COUNT_PERSON)));
                break;
            }

            executor.execute(new PesonNamePrinter(personList.subList(startIndex, startIndex + STEP)));
        }
    }

    private static List<Person> createPersonList() {
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < COUNT_PERSON; i++) {
            personList.add(new Person("person_" + i));
        }

        return personList;
    }
}
