package school.faang.bjs2_60723;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"wash the dishes", "sweep the floor", "cook dinner", "wash the clothes", "dust"};
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All the work is done!");
    }
}
