package school.faang.bjs2_92277;

public class Game {
    private int score;
    private int lives = 3;

    final Object scoreLock = new Object();
    final Object livesLock = new Object();

    public void update(boolean isPointsAdded, boolean isLifeMinused) {
        if (isPointsAdded) {
            synchronized (scoreLock) {
                score++;
                System.out.printf("Score is %d\n", score);
            }
        }

        if (isLifeMinused) {
            synchronized (livesLock) {
                lives--;
                System.out.printf("Life count is %d\n", lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.printf("Game over with score %d", score);
        Main.is_game_over = true;
    }
}
