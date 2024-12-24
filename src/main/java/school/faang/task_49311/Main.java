package school.faang.task_49311;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            boolean earnedPoints = random.nextBoolean();
            boolean lostLife = random.nextBoolean();

            game.update(earnedPoints, lostLife);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
