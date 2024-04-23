package faang.school.godbless.Syncrhonization.BroForcee;

public class Game {
    private int score;
    private int lives;
    private final Object LOCK = new Object();

    public Game() {
        this.score = 0;
        this.lives = 3;
    }

    public void update() {
        synchronized (LOCK) {
            lives--;
            if (lives <= 0) {
                gameOver();
            }
        }
        synchronized (LOCK) {
            score++;
        }
    }

    private void gameOver() {
        System.out.println("Game over! Total score: " + score);
        System.exit(0);
    }

    public int getScore() {
        synchronized (LOCK) {
            return score;
        }
    }

    public int getLives() {
        synchronized (LOCK) {
            return lives;
        }
    }
}