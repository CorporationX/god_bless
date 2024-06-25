package faang.school.godbless.bigbang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final int POOL_SIZE = 4;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(POOL_SIZE);
        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(new Task("Sheldon", "theory preparation")));
        threads.add(new Thread(new Task("Leonard", "experimental design")));
        threads.add(new Thread(new Task("Howard", "instrument development")));
        threads.add(new Thread(new Task("Rajesh", "data analysis")));
        for (Thread thread : threads) {
            service.execute(thread);
        }
        service.shutdown();
        try {
            if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("All tasks are done");
    }
}