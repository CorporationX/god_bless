package Sprint_4_Task_The_Big_Bang_Theory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {

    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {

        List<Task> tasks = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        Task task1 = new Task("Sheldon", "write code");
        Task task2 = new Task("Leonard", "visit planning");
        Task task3 = new Task("Howard", "make coffee");
        Task task4 = new Task("Rajesh", "turn on lights");

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);

        for (int i = 0; i < THREAD_COUNT; i++) {
//            executor.submit(task1);
//            executor.submit(task2);
//            executor.submit(task3);
//            executor.submit(task4);
            executor.submit(tasks.get(i));
        }
        executor.shutdown();

    }
}
