package faang.school.godbless.TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    public static void main(String[] args) throws InterruptedException {
        final int AMOUNT_TREADS = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_TREADS);
        executorService.execute(new Task("Sheldon", "Theory preparation."));
        executorService.execute(new Task("Leonard", "Simulation of the experiment."));
        executorService.execute(new Task("Howard", "Development of tools."));
        executorService.execute(new Task("Rajesh", "Data analysis."));

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("All tasks completed");
    }
}
