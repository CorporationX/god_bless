package school.faang.theywherevery48758;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "wash the dishes",
                "sweep the floor",
                "cook dinner"
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            executorService.execute(task);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
