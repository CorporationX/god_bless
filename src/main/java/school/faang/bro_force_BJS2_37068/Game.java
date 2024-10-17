package school.faang.bro_force_BJS2_37068;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Game {
    private int scores;
    private int lives;

    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public void update(boolean earnScore, boolean lostLive) {
        synchronized (lockScore) {
            if (earnScore) {
                scores++;
                System.out.printf("You got score +1\nYour score: %d\n\n", scores);
            }
        }
        synchronized (lockLives) {
            if (lostLive) {
                lives--;
                System.out.printf("You lost 1 live\nYour left lives: %d\n\n", lives);
                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.printf("You lost all lives\nGame Over\nYour score: %d\n\n", scores);
    }
}

