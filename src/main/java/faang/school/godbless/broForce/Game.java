package faang.school.godbless.broForce;

public class Game {
    private int score = 0;
    private int lives = 5;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public int getScore() {
        synchronized (scoreLock) {
            return score;
        }
    }

    public void update() {
        synchronized (scoreLock) {
            score++;
        }
        synchronized (livesLock) {
            lives--;
            if (lives <= 0) {
                gameOver();
            }
        }
    }

    public void gameOver() {
        System.out.println("Game over!");
        System.exit(0);
    }

    public int getLives() {
        synchronized (livesLock) {
            return lives;
        }
    }


}
