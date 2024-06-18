package faang.school.godbless.TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        Task theory = new Task("Sheldon", "theory preparation");
        Task modeling = new Task("Leonard", "simulation of experiment");
        Task development = new Task("Howard", "tool development");
        Task data = new Task("Rajesh", "data analysis");
        threadPool.submit(theory);
        threadPool.submit(modeling);
        threadPool.submit(development);
        threadPool.submit(data);
        try {
            threadPool.awaitTermination(2, SECONDS);
        } catch (InterruptedException e) {
            throw new InterruptedException();
        }
        System.out.println("All tasks completed");
    }
}
