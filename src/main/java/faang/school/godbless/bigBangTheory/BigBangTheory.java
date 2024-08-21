package faang.school.godbless.bigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(new Task("Sheldon", "theory preparation"));
        executorService.execute(new Task("Leonard", "experiment simulation"));
        executorService.execute(new Task("Howard", "tools development"));
        executorService.execute(new Task("Rajesh", "data analysis"));

        executorService.shutdown();

        if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("All tasks completed.");
        }
    }
}
