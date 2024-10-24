package school.faang.broforce;

public class GameSimulation {
    public static void main(String[] args) {
        Game game = new Game();

        Thread gameThread1 = new Thread(() -> runGameLoop(game));
        Thread gameThread2 = new Thread(() -> runGameLoop(game));
        Thread gameThread3 = new Thread(() -> runGameLoop(game));

        gameThread1.start();
        gameThread2.start();
        gameThread3.start();

        try {
            gameThread1.join();
            gameThread2.join();
            gameThread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Final Score: " + game.getScore());
        System.out.println("Remaining Lives: " + game.getLives());
        System.out.println("Game session ended.");
    }

    private static void runGameLoop(Game game) {
        for (int i = 0; i < 100; i++) {
            boolean earnedPoints = Math.random() > 0.5;
            boolean lostLife = Math.random() > 0.7;

            game.update(earnedPoints, lostLife);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Game loop interrupted.");
            }
        }
    }
}

