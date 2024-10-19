package school.faang.thirdStream.BJS2_37117;

public class Game {
    private int score;
    private int lives;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public Game() {
        score = 0;
        lives = 3;
    }

    public void update(boolean playerEarnedPoints, boolean playerLostLife) {
        if (playerEarnedPoints) {
            synchronized (scoreLock) {
                score++;
                System.out.println("Очки увеличены. Текущий счёт: " + score);
            }
        }

        if (playerLostLife) {
            synchronized (livesLock) {
                lives--;
                System.out.println("Жизнь уменьшена, оставшиеся жизнь: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Игра окончена!");
        System.out.println("Очки: " + score);
        System.out.println("Жизнь: " + lives);
        System.exit(0);
    }
}
