package faang.school.godbless.big_bang_theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task sheldonTask = new Task("Sheldon", "theory preparation");
        Task leonardTask = new Task("Leonard", "experiment simulation");
        Task howardTask = new Task("Howard", "tool development");
        Task rajeshTask = new Task("Rajesh", "data analysis");

        executor.submit(sheldonTask);
        executor.submit(leonardTask);
        executor.submit(howardTask);
        executor.submit(rajeshTask);

        executor.shutdown();

        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks have been completed.");
    }
}
