package sprint4.broforce;

import lombok.Data;

import java.util.Random;

@Data
public class Game {
    private static final Random RANDOM_ACTION = new Random();
    private static final boolean EARN_POINTS = true;
    private static final boolean LOSING_LIFE = false;
    private static final int POINTS_RANGE = 100;

    private final Object scoreLock = new Object();
    private boolean gameContinues;
    private int score = 0;
    private int lives = 5;

    public Game() {
        gameContinues = true;
    }

    public void update() {
        boolean someAction = RANDOM_ACTION.nextBoolean();
        if (scoreCheck(someAction)) {
            return;
        }
        lifeCheck(someAction);
    }

    private boolean scoreCheck(boolean someAction) {
        synchronized (scoreLock) {
            if (someAction == EARN_POINTS && gameContinues) {
                score += RANDOM_ACTION.nextInt(POINTS_RANGE);
                System.out.printf("Accumulated %d points!\n", score);
                return true;
            }
        }
        return false;
    }

    private void lifeCheck(boolean someAction) {
        synchronized (scoreLock) {
            if (someAction == LOSING_LIFE && lives > 0) {
                lives--;
                System.out.printf("Life is lost! There's %d left!\n", lives);
            }
            if (lives == 0 && gameContinues) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        System.out.println("You lose!");
        gameContinues = false;
    }
}
