package faang.school.godbless.sprint3.BJS2_6320;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private final List<Player> players = new ArrayList<>();
    private int score;
    private int lives;
    private boolean isFinished = false;

    public void clearGame() {
        players.clear();
        score = 0;
        lives = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void update(Player player, boolean isScored, boolean isLifeLost) {
        synchronized (scoreLock) {
            if (isScored) {
                score += 1;
                player.setScore(player.getScore() + 1);
                System.out.println("Score increased to: " + score);
            }
        }

        synchronized (livesLock) {
            if (isLifeLost) {
                lives += 1;
                System.out.println("Lives increased to: " + lives);
                player.setLives(player.getLives() - 1);

                if (player.getLives() == 0) {
                    player.setAlive(false);
                    System.out.println("Player is dead: " + player.getName());
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        isFinished = true;
        System.out.println("Game Over! Final Score: " + score);
        clearGame();
    }
}
