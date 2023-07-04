package faang.school.godbless.BroForce;

import lombok.Data;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Data
public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private boolean gameIsNotOver = true;
    private List<Player> players;

    public Game(List<Player> players) {
        this.players = players;
    }

    public void update(int i) {
        int randomIndex = new Random().nextInt(players.size());
        if (new Random().nextBoolean()) {
            synchronized (livesLock) {
                List<Integer> playerLives = players.stream().mapToInt(Player::getLives).boxed().toList();
                if (playerLives.stream().allMatch(live -> live > 0)) {
                    players.get(randomIndex).decrementLives();
                    lives++;
                    players.forEach(player -> {
                        System.out.printf("Player: %s | Score: %s | Lives: %s \n", player.getName(), player.getScore(), player.getLives());
                    });
                } else {
                    gameOver();
                }
            }
        } else {
            synchronized (scoreLock) {
                players.get(randomIndex).incrementScore();
                score++;
                players.forEach(player -> {
                    System.out.printf("Player: %s | Score: %s | Lives: %s \n", player.getName(), player.getScore(), player.getLives());
                });
            }
        }

        System.out.println("Round #" + i + "\n");
    }

    private void gameOver() {
        gameIsNotOver = false;
        System.out.println("Game over");
    }
}
