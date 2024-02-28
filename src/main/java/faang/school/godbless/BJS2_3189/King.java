package faang.school.godbless.BJS2_3189;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) throws InterruptedException {
        var knightBob = new Knight("Bob");
        var knightSam = new Knight("Sam");
        knightBob.addTrial(new Trial("First"));
        knightBob.addTrial(new Trial("Second"));
        knightSam.addTrial(new Trial("Third"));
        knightSam.addTrial(new Trial("Fourth"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        knightBob.startTrials(executorService);
        knightSam.startTrials(executorService);

        executorService.shutdown();
        boolean isFinished = executorService.awaitTermination(60, TimeUnit.SECONDS);
        executorService.shutdownNow();
        if (isFinished) {
            System.out.println("All trials finished!");
        } else {
            System.out.println("Not all trials finished!");
        }

    }
}
