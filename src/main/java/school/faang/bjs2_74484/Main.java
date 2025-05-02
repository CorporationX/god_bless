package school.faang.bjs2_74484;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int WAIT_TIME = 10;

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        ExecutorService executor = masterCardService.getSingleThreadExecutor();
        masterCardService.doAll();
        executor.shutdown();
        try {
            if (!executor.awaitTermination(WAIT_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Interrupted");
        }
    }
}
