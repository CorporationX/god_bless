package school.faang.task_61819;

public class Game {
    private final Object livesLock = new Object();
    private final Object scoreLock = new Object();

    private int score;
    private int lives;

    public Game(int lives) {
        this.lives = lives;
        this.score = 0;
    }

    public int getLives() {
        synchronized (livesLock) {
            return lives;
        }
    }

    public void update(boolean isPointsEarned, boolean isLifeLost) {
        synchronized (livesLock) {
            if (lives <= 0) {
                return;
            }
            if (isLifeLost) {
                this.lives--;
                System.out.printf("Получен урон. Оставшийся жизни: %d%n", this.lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
        synchronized (scoreLock) {
            if (isPointsEarned) {
                this.score++;
                System.out.printf("Получены очки. Текущий счёт: %d%n", this.score);
            }
        }
    }

    private void gameOver() {
        System.out.printf("Игра окончена. Общий счёт за игру: %d%n", score);
    }
}
