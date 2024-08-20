package bigbang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        try (ExecutorService executor = Executors.newFixedThreadPool(4)) {
            Task sheldonTask = new Task("Sheldon", "preparing theory");
            Task leonardTask = new Task("Leonard", "modeling experiment");
            Task howardTask = new Task("Howard", "designing instrumentation");
            Task rajeshTask = new Task("Rajesh", "analyzing data");
            executor.execute(sheldonTask);
            executor.execute(leonardTask);
            executor.execute(howardTask);
            executor.execute(rajeshTask);
            executor.shutdown();
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("All tasks completed");
            } else {
                System.out.println("Completion time out");
            }
        }
    }
}
