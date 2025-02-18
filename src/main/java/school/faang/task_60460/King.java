package school.faang.task_60460;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight loras = new Knight("Loras Tyrell");
        Knight gregor = new Knight("Gregor Clegane");

        loras.addTrial(new Trial(loras.getName(), "Archery"));
        loras.addTrial(new Trial(loras.getName(), "Running at speed"));
        gregor.addTrial(new Trial(gregor.getName(), "Push-ups"));
        gregor.addTrial(new Trial(gregor.getName(), "Hunting"));

        ExecutorService executor = Executors.newFixedThreadPool(2);
        loras.startTrials(executor);
        gregor.startTrials(executor);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
