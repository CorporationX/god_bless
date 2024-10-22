package school.faang.synchronization.broForce;

public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean earnedPoints, boolean lostLife) {
        synchronized (scoreLock) {
            if (earnedPoints) {
                score++;
                System.out.println("Score increased, now you score is: " + score);
            }
        }
        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                System.out.println("Remaining live : " + lives);
                if (lives <= 0) {
                    gameOver();
                    System.out.println("Your score is : " + score);
                }
            }
        }

    }

    private void gameOver() {
        System.out.println("Game is over, the player is out of lives");
    }

}
