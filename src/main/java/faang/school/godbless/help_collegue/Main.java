package faang.school.godbless.help_collegue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_NUM = 4;
    private static final int NUMBER_OF_TASKS = 10000;
    private static final int TIME_OUT = 10;

    public static void main(String[] args) {
        List<Person> personList = getAllTasks();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);
        int numberOfTasksPerThread = NUMBER_OF_TASKS / THREAD_NUM;

        for (int i = 0; i < THREAD_NUM; i++) {
            int startPosition = i * numberOfTasksPerThread;
            int endPosition = startPosition + numberOfTasksPerThread;
            List<Person> personListToThread = personList.subList(startPosition, endPosition);
            PersonNamePrinter personNamePrinter = new PersonNamePrinter(personListToThread);
            executor.execute(personNamePrinter);
        }

        executor.shutdown();

        try {
            boolean isTimeOut = executor.awaitTermination(TIME_OUT, TimeUnit.SECONDS);
            if (isTimeOut) {
                System.out.println("The task is executed on time");
            } else {
                System.out.println("The task is not executed on time");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Person> getAllTasks(){
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_TASKS; i++) {
            personList.add(new Person(String.valueOf(i), String.valueOf(i), i, String.valueOf(i)));
        }
        return personList;
    }
}
