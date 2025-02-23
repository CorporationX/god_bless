package school.faang.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread[] threads = new Thread[4];
        threads[0] = new Thread(() -> player.play());
        threads[1] = new Thread(() -> player.pause());
        threads[2] = new Thread(() -> player.skip());
        threads[3] = new Thread(() -> player.previous());

        for (Thread thread : threads) {
            thread.start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
