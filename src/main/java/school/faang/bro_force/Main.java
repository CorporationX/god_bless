package school.faang.bro_force;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        for (int i = 0; i <= 4; i++) {
            Thread thread = new Thread(() -> {
                while (!game.isGameOver()) {
                    boolean scored = Math.random() < 0.6;
                    boolean lostLife = Math.random() < 0.3;
                    game.update(scored, lostLife);

                    try {
                        Thread.sleep(200 + (int) (Math.random() * 300));
                    } catch (InterruptedException error) {
                        Thread.currentThread().interrupt();

                    }
                }
            }, "Updater-" + i);
            thread.start();
        }
    }
}
