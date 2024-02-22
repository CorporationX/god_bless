package faang.school.godbless.r_edzie.parallelism.trials;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private static final int TERMINATION_TIMEOUT = 5;
    private static final int THREAD_AMOUNT = 2;

    public static void main(String[] args) throws InterruptedException {
        Knight arthur = new Knight("Arthur");
        Knight lancelot = new Knight("Lancelot");

        List<Knight> knights = List.of(arthur, lancelot);

        for (Knight knight : knights) {
            knight.addTrial(new Trial(knight.getName(), "1"));
            knight.addTrial(new Trial(knight.getName(), "2"));
            knight.addTrial(new Trial(knight.getName(), "3"));
        }

        ExecutorService executors = Executors.newFixedThreadPool(THREAD_AMOUNT);

        for (Knight knight : knights) {
            executors.submit(knight.startTrials());
        }

        executors.shutdown();
        executors.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS);
    }
}
