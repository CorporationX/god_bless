package faang.school.godbless;

public class Game {
    private int score;
    private int lives;
    private Object scoreLock;
    private Object livesLock;
    public Game() {
        score = 0;
        lives = 10;
        scoreLock = new Object();
        livesLock = new Object();
    }

    public void update() {
        synchronized (scoreLock) {
            score++;
        }

        synchronized (livesLock) {
            if (lives > 0) {
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
        }
    }


}
