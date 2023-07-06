package faang.school.godbless.multithreading.parallelism_thread.bigbang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {

        List<Task> tasks = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        Task task1 = new Task("Sheldon", "task 1");
        Task task2 = new Task("Leonard", "task 2");
        Task task3 = new Task("Howard", "task 3");
        Task task4 = new Task("Radjesh", "task 4");

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.submit(tasks.get(i));
        }
        executor.shutdown();
    }
}
