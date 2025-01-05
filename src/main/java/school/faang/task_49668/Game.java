package school.faang.task_49668;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private Integer score = 0;
    private Integer lives = 100;

    public void update(boolean earnedPoints, boolean lostLife) {
        synchronized (scoreLock) {
            if (earnedPoints) {
                score++;
                System.out.println("Очки увеличены, текущий счёт: " + score);
            }
            synchronized (livesLock) {
                if (lostLife) {
                    lives--;
                    System.out.printf("Жизнь уменьшена, осталось: %s%n", lives);
                    if (lives <= 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game Over!");
        System.out.printf("Итоговый счёт: %d", score);
        System.exit(0);
    }
}
