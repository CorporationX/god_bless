package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class BigBangTheory {
    private static final int nThreads = 4;
    private static final int threadTerminationTimeout = 60;

    public static void main(String[] args) {
        System.out.println("Hello Almas!");

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        Task task1 = new Task("Sheldon", "prepare the theory");
        Task task2 = new Task("Leo", "simulate the experiment");
        Task task3 = new Task("Howard", "build the tools");
        Task task4 = new Task("Radj", "analyze the data");

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);

        executor.shutdown();

        try {
            if (executor.awaitTermination(threadTerminationTimeout, TimeUnit.SECONDS))
                System.out.println("All threads finished");
        } catch (InterruptedException e) {
            throw new RuntimeException("Threads were interrupted", e);
        }
    }
}