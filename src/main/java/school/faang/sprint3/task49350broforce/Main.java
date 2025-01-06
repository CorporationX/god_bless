package school.faang.sprint3.task49350broforce;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(5);
        List<Player> players = IntStream.range(1, 6)
                .mapToObj(i -> new Player("Player" + i))
                .toList();
        game.addPlayers(players);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (Player player : players) {
            boolean earnedPoints = Math.random() > 0.2;
            boolean lostLife = Math.random() > 0.7;
            executor.submit(() -> {
                while (game.isGameOn()) {
                    game.update(player, earnedPoints, lostLife);
                }
            });
        }
        executor.shutdown();
    }
}
