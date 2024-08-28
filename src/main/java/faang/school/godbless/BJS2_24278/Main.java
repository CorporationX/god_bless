package faang.school.godbless.BJS2_24278;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        List<Player> players = new ArrayList<>(
                List.of(
                        new Player("Player 1", rand.nextInt(1, 16)),
                        new Player("Player 2", rand.nextInt(1, 16)),
                        new Player("Player 3", rand.nextInt(1, 16)),
                        new Player("Player 4", rand.nextInt(1, 16)),
                        new Player("Player 5", rand.nextInt(1, 16)),
                        new Player("Player 6", rand.nextInt(1, 16))
                )
        );
        Game game = new Game(players);
        var executorService = Executors.newFixedThreadPool(players.size());
        executorService.execute(game);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}