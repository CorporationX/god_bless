package school.faang.task324.game;

public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object scoreObject = new Object();
    private final Object livesObject = new Object();
    private boolean isGameOver = false;

    public void update(boolean isScoreChanged, boolean isLivesChanged) {
        synchronized (scoreObject) {
            if (isGameOver) {
                Thread.currentThread().interrupt();
            }

            if (!Thread.currentThread().isInterrupted()) {
                if (isScoreChanged) {
                    score++;
                    System.out.println("Счет увеличен , текущий счет : " + score);
                }
            }
        }
        synchronized (livesObject) {
            if (isGameOver) {
                Thread.currentThread().interrupt();
            }

            if (!Thread.currentThread().isInterrupted()) {
                if (isLivesChanged) {
                    lives--;
                    System.out.println("Жизни уменьшины , текущее кол-во : " + lives);
                    if (lives == 0) {
                        gameOver();
                    }
                }
            }
        }
    }

    public void gameOver() {
        System.out.println("Игра закончена текущий счет : " + score);
        isGameOver = true;
        Thread.currentThread().interrupt();
    }
}
