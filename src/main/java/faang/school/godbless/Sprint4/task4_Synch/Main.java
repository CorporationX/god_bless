package faang.school.godbless.Sprint4.task4_Synch;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_PLAYERS = 2;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);

        List<Player> players = List.of(new Player("Player1"),
                new Player("Player2"),
                new Player("Player3"),
                new Player("Player4"),
                new Player("Player5")
        );

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (Player player : players) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            executor.submit(() -> player.startBattle(boss));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The battle is over");
    }
}
