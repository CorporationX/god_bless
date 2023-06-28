package faang.school.godbless.BigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(new Task("Sheldon", "theory preparation"));
        executor.execute(new Task("Leonard", "experiment simulation"));
        executor.execute(new Task("Howard", "tool development"));
        executor.execute(new Task("Rajesh", "data analysis"));

        executor.shutdown();

        try {
            executor.awaitTermination(4000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All work done");
    }
}
