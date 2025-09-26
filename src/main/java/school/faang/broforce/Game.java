package school.faang.broforce;

import java.util.Random;

public class Game {
    private int totalScore;
    private int totalLives;
    private boolean running = true;

    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public void update(Player player) {
        if (running) {
            int action = new Random().nextInt(100);

            if (action < 70) {
                addScore(player, 1);
            } else {
                loseLife(player, 1);
            }
        }
    }

    private void addScore(Player player, int amount) {
        synchronized (lockScore) {
            totalScore += amount;
            player.addScore(amount);
            System.out.println(player.getName() + " earned " + amount +
                    " point. Total=" + totalScore);
            if (totalLives <= 0) {
                gameOver();
            }
        }
    }

    private void loseLife(Player player, int amount) {
        synchronized (lockLives) {
            totalLives -= amount;
            player.loseLife(amount);
            System.out.println(player.getName() + " lost " + amount +
                    " life. Remaining total lives=" + totalLives);
        }
    }

    private void gameOver() {
        running = false;
        System.out.println("Game over! Final score = " + totalScore);
    }

    public boolean isRunning() {
        return running;
    }

    public Game(int initialLives) {
        this.totalLives = initialLives;
    }
}