package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@AllArgsConstructor
@Slf4j
public class Game {
    private int score;
    private int lives;

    private final Object lockScore = new Object();
    private final Object lockLives = new Object();


    public void update(boolean isScoreUpdated, boolean isLifeLost) {
        if (isScoreUpdated) {
            synchronized (lockScore) {
                score++;
                log.info("Очки заработаны. Общий счет " + score);

            }
        }

        if (isLifeLost) {
            synchronized (lockLives) {
                lives--;
                log.info("Вы потеряли жизнь. Оставшиеся жизни: " + lives);
                if (lives <= 0) {
                    log.info("Игра окончена, вы мертвы. Счет: " + score);
                }

            }
        }

    }

}
