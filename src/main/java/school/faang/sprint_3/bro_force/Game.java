package school.faang.sprint_3.bro_force;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Game {
    private Integer score;
    private Integer lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(String updatePoint) {
        switch (updatePoint) {
            case "score" -> {
                synchronized (scoreLock) {
                    score++;
                }
            }
            case "lives" -> {
                synchronized (livesLock) {
                    lives--;
                    if (lives <= 0) {
                        gameOver();
                    }
                }
            }
            default -> throw new IllegalArgumentException("Invalid update point");
        }
    }

    private void gameOver() {
        log.info("Game over");
    }
}
