package faang.school.godbless.dolbahlop.multithreading.synchronization;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class Game {

    private static Random random = new Random();
    private final Object scoreLock = new Object();
    private final Object liveLock = new Object();
    private final List<Player> players;

    private int score;
    private int lives;

    public void update() {
        while (isAlive()) {
            int index = random.nextInt(players.size());
            Player player = players.get(index);
            boolean isLostLife = random.nextBoolean();

            if (isLostLife) {
                synchronized (liveLock) {
                    player.loseLife();
                    lives++;
                    System.out.println(player.getName() + "'s hp " + player.getLives());

                    if (!player.isAlive()) {
                        gameOver();
                    }
                }
            }
            synchronized (scoreLock) {
                score++;
                System.out.println("Score is " + score);
            }
        }
    }

    private boolean isAlive() {
        return players.stream()
                .map(Player::getLives)
                .allMatch(lives -> lives > 0);
    }

    private void gameOver() {
        synchronized (scoreLock) {
            System.out.println("GAME OVER");
            System.out.println("Score: " + score);
            System.out.println("lost lives: " + lives);
        }
    }
}
