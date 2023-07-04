package faang.school.godbless.TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(new Task("Sheldon", "Theory preparing"));
        executorService.execute(new Task("Leonard", "Experiment modeling"));
        executorService.execute(new Task("Goward", "Tools development"));
        executorService.execute(new Task("Rajesh", "Data analyzing"));

        executorService.shutdown();
    }
}
