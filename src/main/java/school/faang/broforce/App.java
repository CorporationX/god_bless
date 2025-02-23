package school.faang.broforce;

public class App {
    private static final int ONE_SECOND = 1000;

    public static void main(String[] args) {
        final Game game = new Game();

        Runnable gameTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    boolean earnPoint = true;
                    boolean loseLife = (i % 4 == 0);
                    game.update(earnPoint, loseLife);

                    try {
                        Thread.sleep(ONE_SECOND);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };

        Thread t1 = new Thread(gameTask, "Player1");
        Thread t2 = new Thread(gameTask, "Player2");
        Thread t3 = new Thread(gameTask, "Player3");

        t1.start();
        t2.start();
        t3.start();
    }
}
