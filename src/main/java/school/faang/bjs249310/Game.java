package school.faang.bjs249310;

public class Game {

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private int score = 0;
    private int lives = 10;

    public void update(boolean earnedPoints, boolean lostLife) {
        synchronized (scoreLock) {
            if (earnedPoints) {
                score += 10;
            }
        }
        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                System.out.println("Жизни уменьшены, оставшиеся жизни: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        synchronized (scoreLock) {
            synchronized (livesLock) {
                if (lives == 0) {
                    System.out.println("Game Over! Your score is " + score);
                    System.exit(0);
                }
            }
        }
    }

}
