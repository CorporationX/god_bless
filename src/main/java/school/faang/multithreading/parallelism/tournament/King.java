package school.faang.multithreading.parallelism.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private final static int THREAD_POOL_SIZE = 2;

    public static void main(String[] args) throws InterruptedException {
        Knight knight1 = new Knight("knightName1");
        Knight knight2 = new Knight("knightName2");

        knight1.addTrial("trialForKnight1-1");
        knight1.addTrial("trialForKnight1-2");
        knight1.addTrial("trialForKnight1-3");

        knight2.addTrial("trialForKnight2-1");
        knight2.addTrial("trialForKnight2-2");
        knight2.addTrial("trialForKnight2-3");

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        submitKnightTrials(executor, knight1);
        submitKnightTrials(executor, knight2);

        executor.shutdown();
        if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
            executor.shutdownNow();
        }
    }

    private static void submitKnightTrials(ExecutorService executor, Knight knight) {
        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " - отправляет рыцаря " + knight.getName() + " на испытания: " + knight.getTrials());
            knight.startTrials();
        });
    }
}
