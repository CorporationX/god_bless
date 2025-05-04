package school.faang.broforce;

public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean scoredPoint, boolean lostLife) {
        if (scoredPoint) {
            synchronized (scoreLock) {
                score++;
                System.out.println(Thread.currentThread().getName() + " увеличил счёт до: " + score);
            }
        }

        if (lostLife) {
            synchronized (livesLock) {
                lives--;
                System.out.println(Thread.currentThread().getName() + " потерял жизнь. Осталось жизней: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Игра окончена! Финальный счёт: " + score);
    }

}
