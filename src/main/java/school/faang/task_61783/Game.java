package school.faang.task_61783;

public class Game {
    private static final Object SCORE_LOCK = new Object();
    private static final Object LIVES_LOCK = new Object();
    private static final int DEFAULT_SCORE = 0;
    private static final int DEFAULT_LIVES = 5;
    private static final int LIVES_LIMIT = 0;

    private int score = DEFAULT_SCORE;
    private int lives = DEFAULT_LIVES;

    public void update(boolean isScoresIncrease, boolean isLivesDecrease) {
        if (isScoresIncrease) {
            synchronized (SCORE_LOCK) {
                score++;
                System.out.printf("Количество очков увеличено. Текущий счёт: %d%n", score);
            }
        }
        if (isLivesDecrease) {
            synchronized (LIVES_LOCK) {
                lives--;
                System.out.printf("Количество жизней уменьшено. Текущие жизни: %d%n", lives);
                if (lives <= LIVES_LIMIT) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Все жизни потрачены - игра окончена!");
        score = DEFAULT_SCORE;
        lives = DEFAULT_LIVES;
    }
}
