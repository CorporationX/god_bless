package Multithreading.bc2335;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("Artur");
        Knight knight2 = new Knight("Leopold");

        knight1.addTrial(new Trial(knight1.getName(), "Sword duel"));
        knight1.addTrial(new Trial(knight1.getName(), "Riding"));
        knight2.addTrial(new Trial(knight2.getName(), "Shield Fight"));
        knight2.addTrial(new Trial(knight2.getName(), "Fight without weapons"));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        knight1.startTrials(executorService);
        knight2.startTrials(executorService);

        executorService.shutdown();
        try {
            boolean isFinished = executorService.awaitTermination(10, TimeUnit.SECONDS);
            if (isFinished) {

                System.out.println("Trials finished");
            }
        } catch (InterruptedException e) {
            System.out.println("The knight failed the trial");
            throw new RuntimeException(e);
        }


    }
}
