package faang.school.godbless.tournament;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);
    private static final long TIMEOUT = 10000;
    private static final List<Trial> KNIGHT_TRIALS = List.of(
            new Trial("Sword Fighting"),
            new Trial("Fist Fighting")
    );

    public static void main(String[] args) {
        Knight.addTrials(KNIGHT_TRIALS);
        List.of(
                new Knight("William the Brave"),
                new Knight("Harald the Wise")
        ).forEach(EXECUTOR::submit);

        handleExecutorTermination();
    }

    private static void handleExecutorTermination(){
        long startTime = System.currentTimeMillis();
        EXECUTOR.shutdown();

        try {
            while(!EXECUTOR.awaitTermination(3, TimeUnit.SECONDS)) {
                if(System.currentTimeMillis() - startTime > TIMEOUT) {
                    System.out.printf("Timeout reached: %d%n", TIMEOUT);
                    EXECUTOR.shutdownNow();
                } else {
                    System.out.println("--- Trials still being processed...");
                }
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===========================");
        System.out.println("Trials finished processing!");
    }
}
