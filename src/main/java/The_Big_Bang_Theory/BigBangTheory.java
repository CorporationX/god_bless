package The_Big_Bang_Theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Sheldon", "theory preparation");
        Task task2 = new Task("Leonard","simulation of the experiment");
        Task task3 = new Task("Howard","tools development");
        Task task4 = new Task("Rajesh","data analysis");

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);
        executorService.execute(task4);

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks done");
    }
}
