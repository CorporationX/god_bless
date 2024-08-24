package faang.school.godbless.bbt;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    private static final long TIMEOUT = 15000;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List.of(
                new Task("Sheldon", "Prepare Theory"),
                new Task("Leonard", "Experiment Model"),
                new Task("Howard", "Equipment Preparation"),
                new Task("Rajesh", "Data Analysis")
        ).forEach(executor::execute);

        executor.shutdown();
        long startTime = System.currentTimeMillis();
        try {
            while(!executor.awaitTermination(4, TimeUnit.SECONDS)) {
                if (System.currentTimeMillis() - startTime > TIMEOUT) {
                    System.out.println("--------------------");
                    System.out.printf("Timeout reached: %d%n", TIMEOUT);
                    executor.shutdownNow();
                } else {
                    System.out.println("------------- Tasks in progress...");
                }
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=============================");
        System.out.println("Executor finished operating!");
    }
}
