package school.faang.task_49680;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        List<Player> players = List.of(
                new Player("Bob"),
                new Player("Lin"),
                new Player("Tim")
        );

        while (game.getRemainingLives() > 0) {
            for (Player player : players) {
                game.update(player, Math.random() < 0.5, Math.random() > 0.5);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток прерван: {}", e.getMessage());
                }
            }
        }
    }
}