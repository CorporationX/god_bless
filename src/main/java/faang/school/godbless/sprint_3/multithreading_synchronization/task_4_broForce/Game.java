package faang.school.godbless.sprint_3.multithreading_synchronization.task_4_broForce;

public class Game implements Runnable {
    public static final String MSG_GAME_OVER = "GAME OVER";
    private final Object overLock = new Object();
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private int score;
    private int lives;
    private boolean isGameOver;

    public Game() {
        isGameOver = false;
        this.score = 0;
        this.lives = 0;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public synchronized void incScore() {
        score++;
    }

    public synchronized void incLives() {
        lives++;
    }

    public synchronized void setGameOver() {
        isGameOver = true;
    }

    public void update() throws InterruptedException {

        while (true) {
            synchronized (overLock) {
                if (isGameOver) {
                    break;
                }
            }
            synchronized (scoreLock) {
                System.out.println("score: " + score);
            }
            synchronized (livesLock) {
                System.out.println("lives lost: " + lives);
            }
            Thread.sleep(1000);
        }
        System.out.printf("\nTOTAL\n\tscore: %d\n\tlives lost: %d\n", score, lives);
        gameOver();
    }

    private void gameOver() {
        System.out.println(MSG_GAME_OVER);
    }

    @Override
    public void run() {
        try {
            update();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
