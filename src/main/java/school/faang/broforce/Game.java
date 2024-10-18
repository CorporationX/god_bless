package school.faang.broforce;

public class Game {
    private int score;
    private int lives;
    private boolean isGameOver = false;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    public Game(int lives) {
        this.lives = lives;
        this.score = 0;
    }

    public void update(boolean pointScored, boolean liveLost) {
        synchronized (lockScore) {
            if (pointScored && !isGameOver) {
                score++;
                System.out.println("Current score: " + score);
            }
        }

        synchronized (lockLives) {
            if (liveLost && !isGameOver) {
                lives--;
                System.out.println("Lives left : " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        System.out.println("Game is over");
    }
}
