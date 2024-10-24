package school.faang.broForce;


public class Game {
    private int score;
    private int lives;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public void update(boolean earnedPoints, boolean lostLife) {
        synchronized (lockScore) {
            if (earnedPoints) {
                score++;
                System.out.println("Очки увеличены, текущий счёт: " + score);
            }
        }
        synchronized (lockLives) {
            if (lostLife) {
                lives--;
                System.out.println("Жизни уменьшены, оставшиеся жизни: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    public void gameOver() {
        System.out.println("Game Over");
        Thread.currentThread().interrupt();
    }
}
