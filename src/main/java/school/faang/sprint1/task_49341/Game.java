package school.faang.sprint1.task_49341;

public class Game {

    private int score;
    private int lives;
    private boolean earnedPoints;
    private boolean lostLives;

    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();

    public void update(boolean earnedPoints, boolean lostLife) {
        synchronized (scoreLock) {
            if (earnedPoints) {
                score++;
                System.out.println("Очки увеличены, текущий счёт: " + score);
            }
        }
        synchronized (livesLock) {
            if (lostLife) {
                lives--;
                System.out.println("Жизни уменьшены, оставшиеся жизни: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    public void gameOver() {
        System.out.println("Персонаж погиб");
    }

}
