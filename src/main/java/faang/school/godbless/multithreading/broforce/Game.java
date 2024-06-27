package faang.school.godbless.multithreading.broforce;

import java.util.List;
import java.util.Random;

public class Game {
    private final List<Player> players;
    private int score = 0;
    private int lives = 0;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private volatile boolean isDeath = false;

    public Game(List<Player> players) {
        this.players = players;
    }

    public void update() {
        Random random = new Random();
        int index = random.nextInt(players.size());
        Player player = players.get(index);
        while (true) {
            boolean lossLive = getLossLive();
            if (lossLive) {
                if (decreaseLiveOrGameOver(player)) {
                    break;
                }
            } else {
                if (increaseScore(player)) {
                    break;
                }
            }
        }
    }

    public boolean getLossLive() {
        return new Random().nextInt(10) < 5;
    }

    public void gameOver(Player player) {
        System.out.println("Игра завершилась на игроке: " + player.getName());
        System.out.println("Игра окончена с max score: " + score);
        System.out.println("Игра окончена с max lives: " + lives);
    }

    private boolean decreaseLiveOrGameOver(Player player) {
        synchronized (livesLock) {
            if (!isDeath) {
                player.decreaseLive();
                lives++;

                if (!player.isAlive()) {
                    gameOver(player);
                    isDeath = true;
                    return true;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean increaseScore(Player player) {
        synchronized (scoreLock) {
            synchronized (livesLock) {
                if (!isDeath) {
                    player.increaseScore();
                    score++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
