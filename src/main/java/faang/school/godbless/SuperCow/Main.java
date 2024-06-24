package faang.school.godbless.SuperCow;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(10, 0);
        List<Player> players = List.of(
                new Player("Player 1"), new Player("Player 2"),
                new Player("Player3"), new Player("Player 4"),
                new Player("Player 5"), new Player("Player 6")
        );

        ExecutorService excecutor = Executors.newFixedThreadPool(3);
        for (Player player : players) {
            excecutor.submit(() ->
                player.startBattle(boss));
        }

        excecutor.shutdown();


    }
}
