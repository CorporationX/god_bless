package broforce;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
public class Game {
    private final Object scoreLock;
    private final Object livesLock;
    @Getter
    private int score = 0;
    @Getter
    private int lives = 0;

    public void update(@NonNull Player player) {
        while (player.isAlive()) {
            if (ThreadLocalRandom.current().nextInt(100) > 30) {
                synchronized (scoreLock) {
                    var scoreToAdd = (ThreadLocalRandom.current().nextInt(4) + 1) * 500;
                    player.addScore(scoreToAdd);
                    score += scoreToAdd;
                }
            } else {
                synchronized (livesLock) {
                    player.reduceLives();
                    lives++;
                }
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        gameOver(player);
    }

    private void gameOver(@NonNull Player player) {
        System.out.printf("%s lost! His score %d%n", player.getName(), player.getScore());
    }
}
