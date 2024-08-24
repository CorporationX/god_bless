package faang.school.godbless.BJS2_24224;


import lombok.Getter;

import java.util.Random;

@Getter
public class Game {
    private int score = 0;
    private int lives = 0;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private final Random random = new Random();

    public void update(Player player) {

        if (player.getLives() == 0) {
            gameOver(player);
        }

        boolean winCheck = random.nextInt(20) > 10;

        if (winCheck) {
            synchronized (scoreLock) {
                score++;
                System.out.println("Player " + player.getName() + " wins, score " + score);
            }
        } else {
            synchronized (livesLock) {
                player.playerDead();
                lives++;
            }
        }
    }

    private void gameOver(Player player) {
        System.out.println(player.getName() + " was dead! Game over!!!");
    }
}
