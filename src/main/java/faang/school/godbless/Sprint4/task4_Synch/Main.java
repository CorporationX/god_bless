package faang.school.godbless.Sprint4.task4_Synch;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int MAX_PLAYERS = 5;

    public static void main(String[] args) {
        Boss boss = new Boss(2);

        List<Player> players = List.of(new Player("Player1"),
                new Player("Player2"),
                new Player("Player3"),
                new Player("Player4"),
                new Player("Player5")
        );


        ExecutorService executor = Executors.newFixedThreadPool(MAX_PLAYERS);

        for (Player player : players) {
            executor.submit(() -> player.startBattle(boss));
        }

        executor.shutdown();
//        for (Player player : players) {
//            executor.submit(() -> player.endOneBattle(player));
//        }
    }
}
