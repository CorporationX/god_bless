package school.faang.bjs249651;

public class Game {

    private int score;
    private int lives;
    private Object lockForScore = new Object();
    private Object lockForLives = new Object();

    public Game(int lives) {
        this.score = 0;
        this.lives = lives;
    }

    public void update(boolean earnedPoints, boolean lostLife) {
        if (earnedPoints) {
            synchronized (lockForScore) {
                score++;
                System.out.println(Thread.currentThread().getName() + ". Point gained. Total point is: " + score);
            }
        }

        if (lostLife) {
            synchronized (lockForLives) {
                lives--;
                System.out.println(Thread.currentThread().getName() + ". Live lost. Current health is: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println(Thread.currentThread().getName() + " culprit of loss. Game is over");
        System.out.println("Total score is: " + score);
        System.exit(0);
    }

}
