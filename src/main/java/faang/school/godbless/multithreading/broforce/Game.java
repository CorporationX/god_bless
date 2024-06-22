package faang.school.godbless.multithreading.broforce;

import java.util.Random;

public class Game {
    private int score = 0;
    private int lives = 0;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(Player player) {
        Random random = new Random();
        while (true) {
            boolean lossLive = getLossLive();
            if (lossLive) {
                synchronized (livesLock) {
                    player.decreaseLive();
                    lives++;

                    if (!player.isAlive()) {
                        gameOver();
                        return;
                    }
                }
            } else {
                synchronized (scoreLock) {
                    if (player.isAlive()) {
                        player.increaseScore();
                        score++;
                    }

                }
            }

        }
    }

    public boolean getLossLive() {
        return new Random().nextInt(10) < 5;
    }

    public void gameOver() {
        System.out.println("Игра окончена с max score: " + score);
        System.out.println("Игра окончена с max lives: " + lives);
    }
}
