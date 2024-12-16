package school.faang.bjs248200;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String[] chores = {"wash dishes", "sweep the floor", "do laundry", "take out trash"};

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (String chore : chores) {
            Chore newChore = new Chore(chore);
            executorService.execute(newChore);
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("main ended");

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("The works were not completed in 5 minutes, we forcefully stop the ThreadPool");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("The main thread was interrupted while waiting, we forcefully stop the ThreadPool");
            executorService.shutdownNow();
        }
    }
}