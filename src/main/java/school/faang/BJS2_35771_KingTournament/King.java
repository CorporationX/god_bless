package school.faang.BJS2_35771_KingTournament;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class King {
    private static final int THREAD_POOL_SIZE = 2;
    private static final int TERMINATION_WAIT_SECONDS = 15;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Knight firstKnight = new Knight("Oleja");
        Knight secondKnight = new Knight("Stepasha");

        firstKnight.addTrial(new Trial(firstKnight.getName(), "Jousting with a rubber chicken"));
        firstKnight.addTrial(new Trial(firstKnight.getName(), "Tickling a dragon until it surrenders"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "Dancing a ballet with a suit of armor"));
        secondKnight.addTrial(new Trial(secondKnight.getName(), "Solving riddles with a talking frog"));

        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        Future<Boolean> firstKnightSuccess = service.submit(firstKnight::startTrials);
        Future<Boolean> secondKnightSuccess = service.submit(secondKnight::startTrials);

        service.shutdown();
        if (firstKnightSuccess.get() && secondKnightSuccess.get()) {
            System.out.println("All knights completed their trials successfully.");
        } else {
            System.out.println("Not all knights completed their trials in time. Some tasks were forcibly terminated.");
        }
    }
}
