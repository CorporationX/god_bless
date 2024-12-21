package school.faang.task_49231;

import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    private final AtomicInteger score = new AtomicInteger(0);
    private final AtomicInteger lives = new AtomicInteger(10);

    public void update(boolean earnedPoints, boolean lostLife) {
        if (earnedPoints) {
            score.incrementAndGet();
            System.out.println("Очки увеличены, текущий счёт: " + score);
        }

        if (lostLife) {
            lives.decrementAndGet();
            System.out.println("Жизни уменьшены, оставшиеся жизни: " + lives);
            if (lives.get() <= 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over!");
    }
}
