package faang.school.godbless;

public class Game {
    final private Object scoreLock;
    final private Object livesLock;
    private int score;
    private int lives;

    public Game() {
        score = 0;
        lives = 10;
        scoreLock = new Object();
        livesLock = new Object();
    }

    public void update() {
        if (lives > 0) {
            synchronized (scoreLock) {
                score++;
            }
        } else {
            synchronized (livesLock) {
                lives--;
            }
        }

        if (lives == 0) {
            gameOver();
        }
    }

    private void gameOver() {
        System.out.println("Game over");
        System.exit(0);
    }


    public void displayScore() {
        synchronized (scoreLock) {
            System.out.println("Score: " + score);
        }
    }

    public void displayLives() {
        synchronized (livesLock) {
            System.out.println("Lives: " + lives);
            lives--;
        }
    }

    public int getLives() {
        return lives;
    }

}
