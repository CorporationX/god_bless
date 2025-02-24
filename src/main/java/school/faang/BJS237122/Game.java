package school.faang.BJS237122;

public class Game {
    private int score = 0;
    private int lives = 10;
    private final Object scoreLock = new Object();
    private final Object livesLock = new Object();
    private boolean isGameOver = false;

    public void update(boolean earnedPoints, boolean lostPoints) {
        synchronized (scoreLock) {
            if (earnedPoints) {
                score ++;
                System.out.println("Очки увеличены, текущий счет: " + score);
            }
        }

        synchronized (livesLock) {
            if (lostPoints && lives > 0) {
                lives --;
                System.out.println("Жизни уменьшены, оставшиеся жизни: " + lives);
                if (lives == 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
        System.out.println("Game over");
    }

    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 100; i ++) {
            if (game.isGameOver) {
                break;
            }
            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.6;
            game.update(earnedPoints, lostLife);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
