package school.faang.broforce;

public class Game {
    private static final int COUNT_LIVES = 5;
    private static final double CHANCE_LOST_LIVE = 0.9;
    private static final double CHANCE_ADD_POINT = 0.5;
    private static final double COUNT_GAME_STEPS = 50;
    private final Object lockScore = new Object();
    private final Object lockLives = new Object();

    private Integer score = 0;
    private Integer lives = COUNT_LIVES;

    public void update(boolean earnedPoints, boolean lostLife) {
        synchronized (lockScore) {
            if (earnedPoints) {
                score++;
                System.out.println("Очки увеличены, текущий счёт: " + score);
            }
        }

        synchronized (lockLives) {
            if (lostLife) {
                lives--;
                System.out.println("Жизни уменьшены, оставшиеся жизни: " + lives);
                if (lives <= 0) {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        System.out.println("Game OVER!");
        Thread.currentThread().interrupt();
    }

    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < COUNT_GAME_STEPS; i++) {
            boolean earnedPoints = Math.random() > CHANCE_ADD_POINT;
            boolean lostLife = Math.random() > CHANCE_LOST_LIVE;

            game.update(earnedPoints, lostLife);

            try {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                } else {
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}