package school.faang.bjs2_92277;

import java.util.Random;

public class Main {
    private static final int TIME_FOR_SLEEP = 5000;
    public static boolean is_game_over = false;

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();

        boolean isPointsAdded;
        boolean isLifeMinused;

        while (!is_game_over) {
            Random random = new Random();
            isPointsAdded = random.nextBoolean();
            isLifeMinused = random.nextBoolean();
            game.update(isPointsAdded, isLifeMinused);
        }
        Thread.sleep(TIME_FOR_SLEEP);
    }
}
