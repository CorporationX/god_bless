package school.faang.module3.bro_force;

public class Game {
    private int score = 0;
    private int lives = 7;
    private Object scoreLock = new Object();
    private Object livesLock = new Object();

    public void update(boolean isScoreGain) {
        if (isScoreGain) {
            synchronized (scoreLock) {
                score++;
                System.out.printf("players gain score, current score %d\n", score);
            }
            return;
        }
        synchronized (livesLock) {
            if (lives == 0) {
                System.out.println("game overed!");
                return;
            }

            System.out.printf("the players lost a health point, current lives %d\n", --lives);
            if (lives == 0) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        System.out.println("game over!");
    }
}

