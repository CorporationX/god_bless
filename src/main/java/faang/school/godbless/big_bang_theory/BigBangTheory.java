package faang.school.godbless.big_bang_theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task task1 = new Task("Sheldon", "Data analysis");
        Task task2 = new Task("Hovard", "Programming");
        Task task3 = new Task("Leonar", "Frontend");
        Task task4 = new Task("Rajesh", "Design");

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);
        executor.submit(task4);

        executor.shutdown();
        //нашел алтернативный метод isInterrupted также
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println();
                System.out.println("Not all task completed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed!");
    }
}
