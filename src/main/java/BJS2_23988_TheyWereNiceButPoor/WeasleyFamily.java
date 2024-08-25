package BJS2_23988_TheyWereNiceButPoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] CHORES = {"Wash all dishes", "Cut the plants", "Fix chair", "Buy products",
            "Buy books", "Send mails", "Take care of animals"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : CHORES) {
            executor.execute(() -> new Chore(chore).run());
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
