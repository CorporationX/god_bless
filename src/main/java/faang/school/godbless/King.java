package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private static final List<Trial> trials = new ArrayList<>();
    private static final int nThreads = 2;
    private static final int threadTerminationTimeout = 60;

    public static void main(String[] args) {

        System.out.println("Hello Almas!");

        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        List<Knight> knights = new ArrayList<>();
        Knight knight1 = new Knight("Vasya");
        knight1.addTrial("Defend innocent child");
        knight1.addTrial("Rescue beautiful princess");
        knights.add(knight1);

        Knight knight2 = new Knight("Petya");
        knight2.addTrial("Defense the Castle");
        knight2.addTrial("Ride wild horse");
        knights.add(knight2);

        startTrials(knights, executorService);

    }

    public static void startTrials(List<Knight> knights, ExecutorService executorService) {
        for (Knight knight : knights) {
            trials.addAll(knight.trials);
        }
        for (Trial trial : trials) {
            executorService.submit(trial);
        }
        executorService.shutdown();

        try {
            if(executorService.awaitTermination(threadTerminationTimeout, TimeUnit.SECONDS))
                System.out.println("All threads finished");
        } catch (InterruptedException e) {
            throw new RuntimeException("threads are interrupted", e);
        }
    }
}