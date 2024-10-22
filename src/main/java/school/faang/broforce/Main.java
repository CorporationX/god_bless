package school.faang.broforce;

public class Main {

    private final static int LIVES = 3;
    private final static int COUNT_THREADS = 13;
    public static void main(String[] args) {
        Game game = new Game(LIVES);

        Thread[] threads = new Thread[COUNT_THREADS];
        for (int i = 0; i < COUNT_THREADS; i++) {
            threads[i] = new Thread(() -> {
                while (game.getLives() > 0) {
                    game.update();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
    }
}
