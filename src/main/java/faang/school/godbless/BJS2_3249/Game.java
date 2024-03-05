package faang.school.godbless.BJS2_3249;

import java.util.Random;

public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private final Random random = new Random();

    public boolean update(Player player) {
        if (random.nextBoolean()) {
            synchronized (scoreLock) {
                score++;
                System.out.println("Player " + player.getName() + " inc score");
            }
        } else {
            synchronized (livesLock) {
                lives++;
                player.kill();
                System.out.println("Player " + player.getName() + " killed");
                if (!player.isAlive()) {
                    gameOver(player);
                    return false;
                }
            }
        }
        return true;
    }

    private void gameOver(Player player) {
        System.out.println("Game over for player " + player.getName() + System.lineSeparator() + "Score: " + score + System.lineSeparator() + "Lives: " + lives);
    }
}
