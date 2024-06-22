package faang.school.godbless.bro_force;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private int score = 0;
    private int lives = 0;
    private Object scoreLock = new Object();
    private Object livesLock = new Object();
    private List<Player> players = new ArrayList<>();
    private Random random = new Random();

    private void gameOver(Player player) {
        System.out.printf("%s: game over for %s\n", Thread.currentThread().getName(), player.getName());
    }

    public void update() {
        players.get(random.nextInt(players.size())).setAlive(false);

        for (Player player : players) {
            if (player.isAlive()) {
                synchronized (scoreLock) {
                    score++;
                    lives--;
                    System.out.printf("%s: %s scored!\n", Thread.currentThread().getName(), player.getName());
                }
            } else {
                gameOver(player);
            }
        }
    }

    public void addPlayer(@NonNull Player player) {
        players.add(player);
        lives++;
    }
}
