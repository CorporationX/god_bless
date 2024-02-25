package faang.school.godbless.r_edzie.parallelism.weasley;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int TERMINATION_TIMEOUT = 5;
    public static void main(String[] args) throws InterruptedException {
        String[] chores = {"1", "2", "3", "4"};
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }

        executorService.shutdown();
        executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.MINUTES);
    }
}
