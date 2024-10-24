package school.faang.broForce;

public class Main {
    private static final double CHANCE_LOST_LIVE = 0.9;
    private static final double CHANCE_ADD_POINT = 0.5;
    private static final double COUNT_GAME_STEPS = 50;

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

