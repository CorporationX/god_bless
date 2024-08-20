package faang.school.godbless.BJS2_24156;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task theory = new Task("Sheldon", "theory preparation");
        Task experiment = new Task("Leonard", "experiment simulation");
        Task tools = new Task("Howard", "tools preparation");
        Task analysis = new Task("Rajesh", "data analysis");

        executorService.execute(theory);
        executorService.execute(experiment);
        executorService.execute(tools);
        executorService.execute(analysis);
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All tasks are completed");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
