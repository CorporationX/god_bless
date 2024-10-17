package bjs2_35744;

public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game(int score, int lives) {
        this.score = score;
        this.lives = lives;
    }

    public void update(boolean gainedScore, boolean lostLive) {

        if (gainedScore) {
            synchronized (scoreLock) {
                score++;
                System.out.printf("Score gained! Current score: %d\n", score);
            }
        }
        if (lostLive) {
            synchronized (livesLock) {
                lives--;
                System.out.printf("Life lost! Lives available: %d\n", lives);

                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over!");
    }
}
