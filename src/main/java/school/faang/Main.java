package school.faang;

import lombok.extern.slf4j.Slf4j;
import school.faang.bro_force.Game;
import school.faang.bro_force.Player;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int TIMEOUT = 10000;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Player> players = List.of(new Player("Igor", 10, 10), new Player("Sarah", 20, 20),
                new Player("Ivan", 1, 1),
                new Player("Ilya", 1, 1),
                new Player("Kirill", 1, 1),
                new Player("Fox", 1, 1));
        int totalScore = players.stream().mapToInt(Player::getScore).sum();
        int totalLives = players.stream().mapToInt(Player::getLives).sum();
        Game game = new Game(totalScore, totalLives);

        players.forEach(player -> executor.execute(() -> player.play(game)));
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            } else {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted during execution", e);
            executor.shutdownNow();
        }
        System.out.println("Program has ended");
    }
}
