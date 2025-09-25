package bjs2_90154;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 20; j++) {
                    boolean earnedPoints = Math.random() < 0.5;
                    boolean lostLife = Math.random() < 0.3;

                    game.update(earnedPoints, lostLife);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
    }
}
