package school.faang.task_49262;

public class Game {
    private int score;
    private int lives;
    private Object lockScore = new Object();
    private Object lockLives = new Object();


    public Game(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        synchronized (lockScore) {
            return lives;
        }
    }

    public void update() {
        synchronized (lockLives) {
            if (lives > 0) {
                lives--;
                System.out.println(String.format("Lives: %d.", lives));
            } else {
                gameOver();
                return;
            }
        }
        synchronized (lockScore) {
            score++;
            System.out.println(String.format("Game score: %d", score));
        }
    }

    private synchronized void gameOver() {
        System.out.println("Game over.");
        System.out.println(String.format("Game score: %d", score));
    }
}
