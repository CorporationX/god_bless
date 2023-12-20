package faang.school.godbless.BJS_1059;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Task("Sheldon", "Theory preparation"));
        executorService.execute(new Task("Leonard", "Experiment simulation"));
        executorService.execute(new Task("Howard", "Tool developer"));
        executorService.execute(new Task("Rajesh", "Data analysis"));
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);
        System.out.println("Project is completed");
    }
}
