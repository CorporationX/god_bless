package school.faang.bro;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Runnable gameTask = () -> {
            for (int i = 0; i < 100; i++) {
                boolean earnedPoints = Math.random() > 0.5;
                boolean lostLife = Math.random() > 0.6;

                game.update(earnedPoints, lostLife);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(gameTask);
        thread1.start();

        Thread thread2 = new Thread(gameTask);
        thread2.start();

        Thread thread3 = new Thread(gameTask);
        thread3.start();
    }
}
