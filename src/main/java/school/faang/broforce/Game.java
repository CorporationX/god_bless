package school.faang.broforce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
@NoArgsConstructor
public class Game {
    private Integer score = 0;
    private Integer lives = 15;
    private final Lock scoreLock = new ReentrantLock();
    private final Lock livesLock = new ReentrantLock();

    public void update(Boolean isScoreLoss, Boolean isLiveBurned) {
        if (!isScoreLoss) {
            scoreLock.lock();
            score++;
            scoreLock.unlock();
            System.out.println("Прибавилось очков, их теперь " + score);
        }

        if (isLiveBurned) {
            livesLock.lock();
            lives--;
            livesLock.unlock();
            if (lives == 0) {
                gameOver();
            }
            System.out.println("Уменьшились жизни, их теперь " + lives);
        }
    }

    private void gameOver() {
        throw new RuntimeException("Игра окончена");
    }
}
