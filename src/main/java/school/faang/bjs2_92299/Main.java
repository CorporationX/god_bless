package school.faang.bjs2_92299;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Boss boss = new Boss(1);

    public static void main(String[] args) {
        List<Player> players = List.of(new Player("player1"),
                new Player("player2"),
                new Player("player3"),
                new Player("player4"),
                new Player("player5"));

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (Player player : players) {
            executorService.execute(() -> {
                try {
                    player.doBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
    }
}
