package school.faang.BJS2_35771_KingTournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class King {
    private static final int THREAD_POOL_SIZE = 2;
    private static final int TERMINATION_WAIT_SECONDS = 15;

    public static void main(String[] args) {
        Knight firstKnight = new Knight("Oleja");
        Knight secondKnight = new Knight("Stepasha");

        firstKnight.addTrial(new Trial(firstKnight.getName(), "Jousting with a rubber chicken"));
        firstKnight.addTrial(new Trial(firstKnight.getName(), "Tickling a dragon until it surrenders"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "Dancing a ballet with a suit of armor"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "Solving riddles with a talking frog"));

        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        service.submit(firstKnight::startTrials);
        service.submit(secondKnight::startTrials);

        service.shutdown();
        try {
            if (service.awaitTermination(TERMINATION_WAIT_SECONDS, TimeUnit.SECONDS)) {
                System.out.println("All knights completed trials in time.");
            } else {
                System.out.println("Not all knights completed trials in time. Shutting down executor service.");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            throw new IllegalStateException(
                    "The thread was interrupted while waiting for trials to end. Shutting down executor service.",
                    e
            );
        }
    }
}
