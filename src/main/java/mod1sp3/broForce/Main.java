package mod1sp3.broForce;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Thread thread = new Thread(() -> {
            while (game.isGameStarted()) {
                boolean getScore = new Random().nextBoolean();
                boolean lostLive = !getScore;
                game.update(getScore, lostLive);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Sleep method error " + e.getMessage(), e);
                }
            }
        });
        thread.start();
    }
}
