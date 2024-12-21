package school.faang.task_49272;

public class Game {
    private int score = 0;
    private int lives = 10;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();


    public synchronized boolean update(boolean earnedPoint, boolean isDed) {
        if (earnedPoint) {
            synchronized (scoreLock) {
                score++;
                System.out.println("Очки заработаны и добавлены в общий счет: " + score);
            }
        }
        synchronized (livesLock) {
            if (isDed) {
                lives--;
                System.out.println("Вы потеряли одну жизнь, текущее количество: " + lives);
                if (lives <= 0) {
                    gameOver();
                    return false;
                }
            }
        }
        return true;
    }

    private void gameOver() {
        System.out.println("Ваша игра закончена, больше нет доступных жизней");
        System.out.println("Количество набранных очков: " + score);
    }
}
