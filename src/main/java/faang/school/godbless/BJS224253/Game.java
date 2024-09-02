package faang.school.godbless.BJS224253;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Game {
    private int scores;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object liveLock = new Object();
    private final List<Player> bros = new ArrayList<>();
    private final Random random = new Random();
    private int activePlayersCounter = 0;
    private boolean isGameOver = false;

    public void addPlayer(Player player) {
        bros.add(player);
        activePlayersCounter++;
    }

    public void update() {
        if (isGameOver) {
            return;
        }
        Player player = getRandomPlayer();
        increaseLives(player);
        increaseScore(player);
    }

    private void increaseLives(Player player) {
        synchronized (liveLock) {
            if (player.isAlive() && !isGameOver) {
                player.setLives(player.getLives() - 1);
                lives++;
                System.out.println(player.getName() + " lives: " + player.getLives());
                if (player.getLives() == 0 && player.isAlive()) {
                    player.setAlive(false);
                    activePlayersCounter--;
                    gameOver();
                }
            }
        }
    }

    private void increaseScore(Player player) {
        synchronized (scoreLock) {
            if (player.isAlive() && !isGameOver) {
                player.setScore(player.getScore() + 1);
                scores++;
                System.out.println(player.getName() + " earned score: " + player.getScore());
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        System.out.printf("Game over with max score %d\n", scores);
        System.out.printf("Lost lives %d\n", lives);
    }

    private Player getRandomPlayer() {
        return bros.get(random.nextInt(bros.size()));
    }
}
