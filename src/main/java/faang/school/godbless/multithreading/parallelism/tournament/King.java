package faang.school.godbless.multithreading.parallelism.tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class King {
    public static void main(String[] args) {
        Knight knight1 = new Knight("knight1");
        knight1.addTrial(new Trial("trial1"));
        knight1.addTrial(new Trial("trial2"));

        Knight knight2 = new Knight("knight2");
        knight2.addTrial(new Trial("trial3"));
        knight2.addTrial(new Trial("trial4"));

        ExecutorService executor = Executors.newFixedThreadPool(2);

        knight1.startTrials(executor);
        knight2.startTrials(executor);

        executor.shutdown();

        while (!executor.isTerminated()) {
            try {
                System.out.println("Executor is not terminated, wait for it to terminate 1 second");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Executor is terminated");

    }
}
