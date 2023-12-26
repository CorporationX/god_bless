package faang.school.godbless.multithreading.parallelism.kingLandingTournament;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class King {
    public static void main(String[] args) {
        startTrials();
    }

    public static void startTrials() {
        Knight knight1 = new Knight("Knight1");
        Knight knight2 = new Knight("Knight2");

        knight1.addTrial(new Trial(knight1, "The trap"));
        knight1.addTrial(new Trial(knight1, "The saw"));
        knight2.addTrial(new Trial(knight2, "The trap"));
        knight2.addTrial(new Trial(knight2, "The saw"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            futures.add(executorService.submit(knight1.getTrials().get(i)));
            futures.add(executorService.submit(knight2.getTrials().get(i)));
        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupt.");
            } catch (ExecutionException e) {
                System.out.println("Task execution failed.");
            }
        }
        System.out.println("All Knights finished trials.");
        executorService.shutdown();
    }
}
