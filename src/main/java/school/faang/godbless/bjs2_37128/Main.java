package school.faang.godbless.bjs2_37128;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    private static final int NUMBER_OF_THREADS = 10;
    private static final int WAIT_EACH_ITERATION = 500;

    public static void main(String[] args) {
        Player player1 = new Player(1, "Player1", 10);
        Player player2 = new Player(2, "Player2", 10);
        Player player3 = new Player(3, "Player3", 10);
        Player player4 = new Player(4, "Player4", 10);
        Player player5 = new Player(5, "Player5", 10);
        List<Player> players = List.of(player1, player2, player3, player4, player5);
        ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        Game game = new Game();
        players.forEach(player -> {
            pool.submit(() -> {
                while (player.getLives() != 0) {
                    if (ThreadLocalRandom.current().nextInt(1, 3) == 1) {
                        game.update(player, Game.UpdateType.LOOSE_LIFE);
                    } else {
                        game.update(player, Game.UpdateType.SCORE_POINT);
                    }
                    try {
                        Thread.sleep(WAIT_EACH_ITERATION);
                    } catch (InterruptedException e) {
                        log.warn("Player thread interrupted while playing");
                        Thread.currentThread().interrupt();
                    }
                }
            });
            game.addPlayer(player);
        });
    }
}
