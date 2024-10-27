package school.faang.BJS2_37202;

public class Game {
    private int totalScore = 0;
    private int totalLives = 0;
    private boolean gameOver = false;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean earnedPoint, boolean lostLife) {
        synchronized (scoreLock) {
            if (earnedPoint) {
                totalScore++;
                System.out.println("Очки увеличены, текущий счёт: " + totalScore);
            }
        }

        synchronized (livesLock) {
            if (lostLife) {
                totalLives++;
                System.out.println("Жизни уменьшены, текущее количество жизней: " + totalLives);
                if (totalLives >= 9) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        gameOver = true;
        System.out.println("Game over!");
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
