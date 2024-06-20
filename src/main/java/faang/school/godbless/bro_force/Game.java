package faang.school.godbless.bro_force;

import lombok.Getter;

@Getter
public class Game {
    private final Object livesLock = new Object();
    private final Object scoreLock = new Object();
    private int lives = 0;
    private int score = 0;
    private volatile boolean isSomeoneDead = false;

    public void update(Player player) {
        boolean playerFightingSuccess = player.isFightSuccessful();

        if (playerFightingSuccess) {
            synchronized (scoreLock) {
                if (!isSomeoneDead) {
                    player.incrementScore();
                    score++;
                    System.out.println(player.getPlayerName() + " earned one point");
                } else {
                    Thread.currentThread().interrupt();
                }
            }
        } else {
            synchronized (livesLock) {
                if (!isSomeoneDead) {
                    player.decrementLives();
                    lives++;
                    System.out.println(player.getPlayerName() + " lost his life");
                    if (!player.isAlive()) {
                        isSomeoneDead = true;
                        gameOver();
                    }
                } else {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game is over");
        System.out.println("Total spent lives: " + lives);
        System.out.println("Total earned score: " + score);
        Thread.currentThread().interrupt();
    }
}
