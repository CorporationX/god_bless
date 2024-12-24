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

    public void update(boolean scoreAdd, boolean liveLose) {
        if (liveLose) {
            synchronized (lockLives) {
                if (lives > 0) {
                    lives--;
                    System.out.println(String.format("Lives: %d.", lives));
                    if (lives == 0) {
                        gameOver();
                    }
                } else {
                    gameOver();
                }
            }
        }
        if (scoreAdd) {
            synchronized (lockScore) {
                score++;
                System.out.println(String.format("Game score: %d", score));
            }
        }
    }

    private void gameOver() {
        System.out.println("Game over.");
        System.out.println(String.format("Game score: %d", score));
    }
}
