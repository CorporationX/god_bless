package faang.school.godbless.alexbulgakoff.multithreading.synchronization.broforce;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Bulgakov
 */
@Getter
@ToString
public class Game {
    static final int COUNT_PLAYERS = 6;
    static final int PLAYER_MAX_LIVE = 5;
    static final int COUNT_THREADS = COUNT_PLAYERS / 2;

    private long scores;
    private long lives;
    private final Live live = new Live();
    private final Score score = new Score();
    private final List<Player> playerList;

    public Game(List<Player> playerList) {
        this.playerList = playerList;
        lives = playerList.stream().mapToLong(Player::getHealth).sum();
    }

    @SneakyThrows
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        for (int i = 1; i < COUNT_PLAYERS; i++) {
            players.add(new Player(String.valueOf(i), PLAYER_MAX_LIVE));
        }

        Game game = new Game(players);

        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);

        for (Player player : game.getPlayerList()) {
            executorService.submit(() -> {
                synchronized (game) {
                    while (game.getLives() != 0) {
                        game.update();
                    }
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.MINUTES);

    }

    public void update() {
        for (Player player : playerList) {
            if (player.isAlive()) {
                synchronized (live) {
                    player.damageToPlayer();
                    lives--;
                }
                synchronized (score) {
                    scores++;
                }
            }

            if (!player.isAlive()) {
                System.out.println("Игрок " + player.getName() + " погиб!");
            }
        }

        if (lives == 0) {
            gameOver();
        }
    }

    private void gameOver() {
        System.out.println("Игра окончена!");
    }

    static class Live {}
    static class Score {}
}
