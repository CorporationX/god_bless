package faang;

public final class Main {
    public static void main(final String[] args) throws InterruptedException {
        final Player player = new Player();
        final Thread[] threads = {
                new Thread(player::pause),
                new Thread(player::play),
                new Thread(player::skip),
                new Thread(player::previous)
        };

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
