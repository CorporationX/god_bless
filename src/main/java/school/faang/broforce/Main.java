package school.faang.broforce;

public class Main {
    private static final double EARN_POINTS_PROBABILITY = 0.6;
    private static final double LOSE_LIFE_PROBABILITY = 0.8;

    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 100; i++) {
            boolean isScored = Math.random() < EARN_POINTS_PROBABILITY;
            boolean isLostLive = Math.random() < LOSE_LIFE_PROBABILITY;
            new Thread(() -> game.update(isScored, isLostLive)).start();
        }
    }
}