package faang.school.godbless.BJS2_24060;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class Game {

    private static Random rand = new Random();
    private final Object scoreLock = new Object();
    private final Object lostLivesLock = new Object();

    private int lostLives;
    private int score;
    private final List<Player> players;

    public void update() {
        while (isAlive()) {
            int index = rand.nextInt(players.size());
            Player player = players.get(index);
            boolean isLostLive = rand.nextBoolean();

            if (isLostLive) {
                synchronized (lostLivesLock) {
                    player.loseLife();
                    lostLives++;
                    System.out.printf("У игрока %s жизней: %d\n", player.getName(), player.getLives());

                    if (!player.isAlive()) {
                        gameOver();
                        return;
                    }
                }
            }

            synchronized (scoreLock) {
                score++;
                System.out.println("Score увеличен: " + score);
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
            System.out.println("lost lives: " + lostLives);
        }
    }
}
