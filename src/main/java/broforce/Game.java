package broforce;

public class Game {
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    private int score;
    private int lives = 10;
    private boolean isGameOver;

    public void update(boolean earnPoints, boolean lostLife) {
        synchronized (scoreLock) {
            if (earnPoints && !isGameOver) {
                score++;
                System.out.println("Добавлены очки, общий счет: " + score);
            }
        }
        synchronized (livesLock) {
            if (lostLife && !isGameOver) {
                lives--;
                System.out.println("Отняты жизни, текущий уровень здоровья: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        System.out.println("Игра была завершена.");
    }
}
