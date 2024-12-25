package derschrank.sprint03.task07.bjstwo_49649;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_PLAYERS = 10;

    public static void main(String[] args) {
        Boss boss = new Boss(2);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        System.out.println("Fight was started");

        for (int i = 0; i < MAX_PLAYERS; i++) {
            String name = "Player " + i;
            executor.execute(
                    () -> new Player(name).startBattle(boss)
            );
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Executor was interrupted");
        }

        System.out.println("Fight was ended");
    }
}
