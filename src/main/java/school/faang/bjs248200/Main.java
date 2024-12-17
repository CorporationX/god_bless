package school.faang.bjs248200;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_AMOUNT = 4;
    private static final String[] CHORES = {"wash dishes", "sweep the floor", "do laundry", "take out trash"};

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

        for (String chore : CHORES) {
            Chore newChore = new Chore(chore);
            executorService.execute(newChore);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted: " + e.getMessage());
        }
        System.out.println("main ended");

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("The works were not completed in 5 minutes, we forcefully stop the ThreadPool");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("The main thread was interrupted while waiting, we forcefully stop the ThreadPool");
            executorService.shutdownNow();
        }
    }
}