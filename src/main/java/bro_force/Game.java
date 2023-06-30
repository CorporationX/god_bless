package bro_force;

public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private boolean isRunning;

    public Game() {
        score = 0;
        lives = 5;
        isRunning = true;
    }

    public void update() {
        synchronized (scoreLock) {
            score++;
            System.out.println("Score increased by 1");
        }
        synchronized (livesLock) {
            if (lives > 0) {
                lives--;
                System.out.println("Lives reduced by 1");
            } else {
                gameOver();
            }
        }
    }

    private void gameOver() {
        setRunning(false);
        System.out.println("Game Over");
    }

    private synchronized boolean isRunning() {
        return isRunning;
    }

    private synchronized void setRunning(boolean running) {
        isRunning = running;
    }

    public static void main(String[] args) {
        Game game = new Game();
        while (game.isRunning()) {
            game.update();
        }
    }
}
