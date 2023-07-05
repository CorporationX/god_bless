package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Player player1 = new Player("One");
        Player player2 = new Player("Two");
        Player player3 = new Player("Three");
        Player player4 = new Player("Four");
        List<Player> players = new ArrayList<>(List.of(player1, player2, player3, player4));

        for (Player player : players) {
            executorService.submit(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
    }
}
