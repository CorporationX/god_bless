package faang.school.godbless.BJS224439;

public class Game {
    private int score = 0;
    private int lives = 3;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update() {
        synchronized (this) {
            synchronized (scoreLock) {
                // Update score
                if (lives > 0) {
                    score++;
                } else {
                    gameOver();
                }
            }
            synchronized (livesLock) {
                // Update lives
                if (lives > 0) {
                    lives--;
                } else {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over! Score: " + score);
        System.exit(0);
    }
}
