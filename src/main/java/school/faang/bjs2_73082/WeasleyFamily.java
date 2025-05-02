package school.faang.bjs2_73082;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Задача "They were very nice but extremely poor"
 */
public class WeasleyFamily {
    private static final int CHORE_TERMINATION_TIMEOUT_MS = 5000;
    private static final String[] chores = new String[]{
            "помыть посуду",
            "подмести пол",
            "вынести мусор",
            "постирать вещи"
    };

    public static void main(String[] args) {
        ExecutorService choreExecutorsPool = Executors.newCachedThreadPool();

        for (String chore : chores) {
            choreExecutorsPool.execute(new Chore(chore));
        }

        choreExecutorsPool.shutdown();
        try {
            if (!choreExecutorsPool.awaitTermination(CHORE_TERMINATION_TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                choreExecutorsPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            choreExecutorsPool.shutdownNow();
        }
    }
}
