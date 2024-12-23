package school.faang.sprint3.bjs_49320;

public class Main {
    private static final double SCORE_THRESHOLD = 0.5;
    private static final int GAME_STEP_DELAY = 1000;
    private static final int LIVES_COUNT = 6;

    public static void main(String[] args) {
        boolean isScoreEarned;
        boolean isLiveLost;

        Game game = new Game(LIVES_COUNT);

        while (game.getLives() > 0) {
            isScoreEarned = getRandomValue();
            isLiveLost = getRandomValue();
            game.update(isScoreEarned, isLiveLost);
            try {
                sleepThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean getRandomValue() {
        return Math.random() < SCORE_THRESHOLD;
    }

    private static void sleepThread() throws InterruptedException {
        Thread.sleep(GAME_STEP_DELAY);
    }
}
