package school.faang.bro_force;

import java.util.Random;

public class Main {
    private static final int PLAYER_COUNT = 5;

    private static final Random random = new Random();

    public static void main(String[] args) {
        Game game = new Game();
        startGame(game);
    }

    private static void startGame(Game game) {
        for (int i = 0; i < PLAYER_COUNT; i++) {
            new Thread(createGameCycle(game)).start();
        }
    }

    private static Runnable createGameCycle(Game game) {
        return () -> {
            while (true) {
                boolean addPoint = random.nextBoolean();
                boolean lostLife = random.nextBoolean();
                game.update(addPoint, lostLife);
                sleep();
            }
        };
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Игра прервана", e);
        }
    }
}
