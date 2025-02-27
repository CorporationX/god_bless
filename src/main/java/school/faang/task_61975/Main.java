package school.faang.task_61975;

public class Main {
    private static final int NUMBER_OF_THREADS = 5;
    private static final int UPDATES_PER_THREAD = 10;
    private static final int DELAY = 500;

    public static void main(String[] args) {
        Game game = new Game(0, 10);

        Thread[] threads = new Thread[NUMBER_OF_THREADS];

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < UPDATES_PER_THREAD; j++) {
                    boolean gainedScore = Math.random() > 0.5;
                    boolean lostLife = Math.random() > 0.7;

                    game.update(gainedScore, lostLife);

                    try {
                        Thread.sleep(DELAY);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
