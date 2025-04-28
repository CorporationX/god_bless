package school.faang.bjs2_73032;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        ExecutorService executor = weasleyFamily.getExecutorService();
        for (Chore c : weasleyFamily.getToDo()) {
            executor.execute(c);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread interrupted");
        }
    }
}
