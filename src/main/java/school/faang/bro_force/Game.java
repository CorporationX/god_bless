package school.faang.bro_force;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
public class Game {

    private int score = 0;
    private int lives = 5;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private boolean isGameOver = false;
    private static final Predicate<Integer> predicateScore = scores -> scores == 10;
    private static final Predicate<Integer> predicateLives = live -> live == 0;

    public void update(boolean isScorePoints, boolean isLosesLives) {
        synchronized (scoreLock) {
            if (isGameOver) {
                log.info("Вы набрали необходимое количество очков, вы выиграли");
                return;
            } else if (isScorePoints) {
                score++;
                System.out.printf("игрок увеличил очки на  %d \n", score);
                checkIfGameOver();
            }
        }

        synchronized (livesLock) {
            if (isGameOver) {
                log.info("Жизни потрачены вы проиграли");
                return;
            } else if (isLosesLives) {
                lives--;
                System.out.printf("игрок теряет прочность на  %d \n", lives);
                checkIfGameOver();
            }
        }
    }

    public void checkIfGameOver() {
        if (predicateScore.test(score)) {
            System.out.println("win");
            isGameOver = true;
        }
        if (predicateLives.test(lives)) {
            System.out.println("Game Over");
            isGameOver = true;
        }
    }
}
