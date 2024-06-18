package faang.school.godbless.multithreading.bigbang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    private static final int THREAD_AMOUNT = 4;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);
        List<Task> tasks = new ArrayList<>(List.of(
                new Task("Имя1", "Задание1"),
                new Task("Имя2", "Задание2"),
                new Task("Имя3", "Задание3"),
                new Task("Имя4", "Задание4")
        ));

        for (Task task : tasks) {
            executorService.execute(task);
        }
        executorService.shutdown();

        while (!executorService.isTerminated()) {}
        System.out.println("Все задачи выполнены");

    }
}
